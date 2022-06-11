package com.wsl.data.login.mappers

import com.domain.domain.login.models.User
import com.wsl.data.db.entities.EUser

class LoginMapper (
    val makeUserMapper: (User) -> EUser
)