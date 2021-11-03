package com.wsl.login.login.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.wsl.login.R

public class RegisterFragmentDirections private constructor() {
  public companion object {
    public fun registerFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.registerFragment_to_loginFragment)
  }
}
