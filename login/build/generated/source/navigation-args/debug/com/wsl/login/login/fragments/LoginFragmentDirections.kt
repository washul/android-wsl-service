package com.wsl.login.login.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.wsl.login.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun loginFragmentToRegisterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.login_fragment_to_registerFragment)
  }
}
