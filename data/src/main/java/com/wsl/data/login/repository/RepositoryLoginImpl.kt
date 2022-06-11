package com.wsl.data.login.repository

import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.*
import com.domain.domain.login.models.LoginResponse
import com.domain.domain.login.models.RegisterResponse
import com.domain.domain.login.models.SensitiveTokens
import com.domain.domain.login.models.User
import com.wsl.data.db.entities.EUser
import com.wsl.data.db.entities.toEUser


class RepositoryLoginImpl constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
    ): RepositoryLogin {

//    MARK: LOCAL METHODS
    override suspend fun localSignIn(): Result<Failure, String> {
        val token =  localDataSource.localSignIn()
         return if (token.isEmpty()) {
             Result.Failure(Failure.CustomError("No token finded"))
         } else {
             Result.Success(token)
         }
    }

    override suspend fun saveUserOrUpdate(
        user: User
    ) = localDataSource.saveUserOrUpdate(user.toEUser())

    //    MARK: CLOUD METHODS
    override suspend fun login(
        email: String,
        password: String
    ): Result<Failure, LoginResponse>
        = remoteDataSource.login(EUser(uuid_user = "", email= email, password = password))
            .onSuccess { response->
                val token = response.token
                val userResponse = response.user
                val userLogged = response.auth ?: false
                //val message = response.message

                //token not null
                //uuid_user not null
                //user logged true
                if ( !token.isNullOrEmpty()
                        .and( !userResponse?.uuid_user.isNullOrEmpty() )
                        .and( userLogged )
                ) {
                    response.user?.let { localDataSource.saveUserOrUpdate(it.toEUser()) }
                    localDataSource.tokenUser = token!!
                    localDataSource.uuidUser = userResponse!!.uuid_user
                }
            }

    override suspend fun registerUser(
        user: User
    ): Result<Failure, RegisterResponse>
        = remoteDataSource.registerUser( user.toEUser() )


    override suspend fun updateUser(
        user: User
    ): Result<Failure, RegisterResponse> {
        return remoteDataSource.updateUser( user.toEUser() )
            .onSuccess {
                it.token?.let { tokenUser ->
                    localDataSource.tokenUser = tokenUser
                    localDataSource.saveUserOrUpdate(user.toEUser())
                }
            }
            .onFailure {

            }
    }

    override suspend fun getUser(): Result<Failure, LoginResponse> {
        return remoteDataSource.getUser()
            .onSuccess {
                it.user?.let { user ->
                    it.token?.let { token ->
                        localDataSource.saveUserOrUpdate(user.toEUser())
                        localDataSource.tokenUser = token
                        localDataSource.uuidUser = user.uuid_user
                    }
                }
            }
    }

    override fun getSensitiveTokens(): Result<Failure, SensitiveTokens> {
        val token = localDataSource.tokenUser
        val tokenDevice = localDataSource.tokenDevice
        val userID = localDataSource.uuidUser

        return if (token.isNotEmpty() && tokenDevice.isNotEmpty() && userID.isNotEmpty() ){
            Result.Success(SensitiveTokens(token, tokenDevice, userID))
        } else {
            Result.Failure(Failure.CustomError("No sensitive token available"))
        }

    }

    override fun setTokenDevice(tokenDevice: String): Result<Failure, Boolean> {
        return try {
            localDataSource.tokenDevice = tokenDevice
            Result.Success(true)
        }catch (e: Throwable){
            e.printStackTrace()
            Result.Failure(Failure.ServerError(e))
        }
    }

    override fun setTokenUSer(token: String): Result<Failure, Boolean> {
        return try {
            localDataSource.tokenUser = token
            Result.Success(true)
        } catch (e: Throwable) {
            e.printStackTrace()
            Result.Failure(Failure.ServerError(e))
        }
    }

    override fun setUserID(userID: String): Result<Failure, Boolean> {
        return try {
            localDataSource.uuidUser = userID
            Result.Success(true)
        } catch (e: Throwable){
            e.printStackTrace()
            Result.Failure(Failure.ServerError(e))
        }
    }

    override fun logOut()
        = localDataSource.logOut()

 }