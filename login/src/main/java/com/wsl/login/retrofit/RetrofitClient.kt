package com.wsl.login.retrofit

import android.app.Application
import com.wsl.login.dagger.DaggerApplication
import com.wsl.login.helpers.Preferences
import com.wsl.login.helpers.URL_BASE
import com.wsl.login.login.view_model.RepositoryLogin
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitClient @Inject constructor() {

    private var retrofit: Retrofit? = null

    @Inject
    lateinit var repository: RepositoryLogin

    @Inject
    lateinit var prefs: Preferences

    companion object {

        private lateinit var instance: RetrofitClient

        fun build( application: Application ): RetrofitClient {

            if ( !::instance.isInitialized ){

                instance = RetrofitClient()

                val appComponent = DaggerApplication().initDaggerComponent( application )
                appComponent.inject(instance)

            }

            return instance

        }

    }

    fun buildRetrofit(): Retrofit {

        if ( retrofit == null ) {

            val client = OkHttpClient
                .Builder()
                .addInterceptor( RequestInterceptorAddAppID() )
                .addInterceptor( RequestInterceptorAddHeaders() )
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl("http://$URL_BASE")
                .client( client )
                .addConverterFactory( GsonConverterFactory.create() )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .build()

        }

        return retrofit!!

    }

    inner class RequestInterceptorAddHeaders: Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response? {

            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .build()

            var requestBuilder = original.newBuilder().url(url)

            /**If the instance is not initialized, the metod returned the same request*/
            if ( !::prefs.isInitialized || !::repository.isInitialized || prefs.tokenUser == "" )
                return chain.proceed( requestBuilder.build() )

            val user = repository.getLocalUserNoAsync()


            requestBuilder = original.newBuilder()
                .addHeader("auth", prefs.tokenUser )
                .addHeader("uuid_user", user.uuid_user )
                .addHeader("tokendevice", prefs.tokenDevice )
                .addHeader("appID", prefs.appID )
                .url(url)


            return chain.proceed(requestBuilder.build())
        }

    }

    inner class RequestInterceptorAddAppID: Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response? {

            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .build()

            var requestBuilder = original.newBuilder().url(url)

            requestBuilder = original.newBuilder()
                .addHeader("appID", prefs.appID )
                .url(url)


            return chain.proceed(requestBuilder.build())
        }

    }

}





