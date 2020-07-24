package wsl.com.tepeheapp.Utils.retrofit

import com.google.gson.Gson
import com.wsl.login.URL_BASE
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private var retrofit: Retrofit? = null

    val instance: Retrofit
        get() {

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

private class RequestInterceptorAddHeaders : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val auth = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlcl93aXRoX25vX29wZW5wYXlfYWNjb3VudCIsImVtYWlsIjoiZGV2ZWxvcC53c2wxQGdtYWlsLmNvbSIsInRva2VuZGV2aWNlIjoidG9rZW50ZXN0MCIsIm5vdyI6MTU5NTAxMzA2OSwiZXhwIjoxNTk2MjIyNjY5fQ.tg06CfUndqGFHFyZ7kCdZBvXtICmLvQ8eoWc-O0nCbo"
        val uuid_user = "testuser_with_no_openpay_account"
        val tokendevice = "tokentest0"


        val url = originalHttpUrl.newBuilder()
            .build()

        val requestBuilder = original.newBuilder()
            .addHeader("auth", auth)
            .addHeader("uuid_user", uuid_user)
            .addHeader("tokendevice", tokendevice)
            .addHeader("appID", "wsl.com.tepeheapp")
            .url(url)

        val request = requestBuilder.build()

        return chain.proceed(request)
    }

}