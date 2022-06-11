package com.wsl.data.retrofit

import com.wsl.data.login.WSPreferences
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val URL_BASE = "209.182.219.193:4433/wsl/"
class RetrofitClient constructor(
    private val prefs: WSPreferences
) {

    var retrofit: Retrofit? = null

    companion object {

        private lateinit var instance: RetrofitClient

        fun build(prefs: WSPreferences): RetrofitClient {

            if ( !::instance.isInitialized ){

                instance = RetrofitClient(prefs)
                buildRetrofit()

            }

            return instance
        }

        private fun buildRetrofit() {
            if ( instance.retrofit == null ) {

                val client = OkHttpClient
                    .Builder()
                    .addInterceptor( instance.RequestInterceptorAddAppID() )
                    .addInterceptor( instance.RequestInterceptorAddHeaders() )
                    .build()

                instance.retrofit = Retrofit.Builder()
                    .baseUrl("http://$URL_BASE")
                    .client( client )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                    .build()

            }
        }
    }



    inner class RequestInterceptorAddHeaders: Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response? {

            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .build()

            var requestBuilder = original.newBuilder().url(url)

            /**If the instance is not initialized, the metod returned the same request*/
            if ( prefs.tokenUser == "" )
                return chain.proceed( requestBuilder.build() )


            requestBuilder = original.newBuilder()
                .addHeader("auth", prefs.tokenUser )
                .addHeader("uuid_user", prefs.userID )
                .addHeader("tokendevice", prefs.tokenDevice )
                .addHeader("appID", prefs.appID )
                .url(url)


            return chain.proceed(requestBuilder.build())
        }

    }

    inner class RequestInterceptorAddAppID: Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response? = chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader("appID", prefs.appID)
                    .build()
            )

        }

    }

}





