package wsl.com.tepeheapp.Utils.retrofit

import com.wsl.login.model.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface RetrofitServices {

    @POST("login/")
    fun login(@Body parameters: EUser): Observable<LoginResponse>


    @POST("register/")
    fun registerUser(@Body user: EUser ): Observable<RegisterResponse>

}