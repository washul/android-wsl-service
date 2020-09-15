package com.wsl.payments.retrofit

import android.app.Application
import com.google.gson.Gson
import com.wsl.payments.dagger.DaggerApplication
import com.wsl.payments.utils.APPID
import com.wsl.payments.utils.Preferences
import com.wsl.payments.utils.URL_BASE
import com.wsl.payments.viewmodel.RepositoryPayments
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitClient @Inject constructor() {

    private var retrofit: Retrofit? = null

    @Inject
    lateinit var repository: RepositoryPayments

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

        override fun intercept(chain: Interceptor.Chain): Response {

            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .build()

            var requestBuilder = original.newBuilder().url(url)

            /**If the instance is not initialized, the metod returned the same request*/
            if ( !::prefs.isInitialized || !::repository.isInitialized || prefs.tokenUser == "" )
                return  chain.proceed(requestBuilder.build())

//            val user = repository.getLocalUser()

            requestBuilder = original.newBuilder()
                .addHeader("auth", prefs.tokenUser )
//                .addHeader("uuid_user", user.uuid )
//                .addHeader("tokendevice", user.tokendevice )
                .addHeader("appID", APPID )
                .url(url)


            return chain.proceed(requestBuilder.build())
        }

    }

}

private class RequestInterceptorSetJsonModel : Interceptor {

    val JSON = MediaType.parse("application/json; charset=utf-8")
    val GSON = Gson()

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response = chain.proceed(request)
        val body = response.body()

//        TODO: Verificar el modo de interceptar el response
        val apiResponse = GSON.fromJson(body!!.string(), RequestBody::class.java)
        body.close()

        val newResponse = response.newBuilder()
            .body(ResponseBody.create(JSON, ( apiResponse ).toString()))

        return newResponse.build()
    }

}





