package wsl.com.tepeheapp.Utils.retrofit

import com.wsl.login.model.EUser
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface RetrofitServices {

    @POST("signin/")
    fun login(@Body user: EUser): Observable<ResponseBody>


    @POST("register/")
    fun registerUser(@Body user: EUser ): Observable<ResponseBody>

}