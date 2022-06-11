package com.wsl.login.login

import com.domain.domain.login.models.LoginResponse
import com.domain.domain.login.models.RegisterResponse
import com.domain.domain.login.models.SensitiveTokens
import com.domain.domain.login.models.User
import com.domain.domain.login.use_cases.*
import com.utils.utils.Failure
import com.utils.utils.Result
import com.utils.utils.map
import com.utils.utils.onSuccess

class CommonAuthenticationManager(
    private val getSensitiveTokensUseCase: GetSensitiveTokensUseCase,
    private val setUserIDUseCase: SetUserIDUseCase,
    private val setDeviceIDUseCase: SetDeviceIDUseCase,
    private val setTokenUserUseCase: SetTokenUserUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val localSigiInUseCase: LocalSigiInUseCase,
    private val loginUseCase: LoginUseCase,
    private val logOutUserCase: LogOutUserCase,
    private val registerUserUseCase: RegisterUserUseCase,
    private val saveOrUpdateUserUseCase: SaveOrUpdateUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase
): BaseAuthenticationManager() {

    var tokenUser: String? = null
    var userID: String? = null
    var deviceID: String? = null

    override suspend fun localSignIn(): Result<Failure, Boolean> {
        return localSigiInUseCase().map { it.isNotEmpty() }
    }

    override suspend fun login(email: String, password: String): Result<Failure, Boolean> {
        return loginUseCase(
            LoginUseCase.Params(email, password)
        ).map {
            it.auth ?: false
        }
    }

    override suspend fun saveUserOrUpdate(user: User): Result<Failure, Boolean> {
        return saveOrUpdateUserUseCase(
            SaveOrUpdateUserUseCase.Params(user)
        ).map { it }
    }

    override suspend fun registerUser(user: User): Result<Failure, Boolean> {
        return registerUserUseCase(
            RegisterUserUseCase.Params(user)
        ).map { !it.token.isNullOrEmpty() }
    }

    override suspend fun updateUser(user: User): Result<Failure, Boolean> {
        return updateUserUseCase(
            UpdateUserUseCase.Params(user)
        ).map { !it.token.isNullOrEmpty() }
    }

    override suspend fun getUser(): Result<Failure, User?> {
        return getUserUseCase().map { it.user }
    }

    override suspend fun logOut(): Result<Failure, Boolean> {
        return logOutUserCase().map { it }
    }

    override fun getSensitiveTokens(): Result<Failure, SensitiveTokens> {
        return getSensitiveTokensUseCase().also {
            it.onSuccess { sensitiveTokens ->
                tokenUser = sensitiveTokens.tokenUser
                deviceID = sensitiveTokens.deviceID
                userID = sensitiveTokens.userID
            }
        }
    }

    override suspend fun setTokenDevice(
        tokenDevice: String
    ): Result<Failure, Boolean>
        = setDeviceIDUseCase(
            SetDeviceIDUseCase.Params( tokenDevice )
        )

    override suspend fun setTokenUSer(
        token: String
    ): Result<Failure, Boolean>
        = setTokenUserUseCase(
            SetTokenUserUseCase.Params( token )
        )

    override suspend fun setUserID(
        userID: String
    ): Result<Failure, Boolean>
        = setUserIDUseCase(
            SetUserIDUseCase.Params( userID )
        )

}