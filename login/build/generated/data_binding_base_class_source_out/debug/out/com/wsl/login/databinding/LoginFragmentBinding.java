// Generated by data binding compiler. Do not edit!
package com.wsl.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.wsl.login.R;
import com.wsl.login.login.view_model.WSLoginViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LoginFragmentBinding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText editTextEmail;

  @NonNull
  public final TextInputLayout email;

  @NonNull
  public final TextInputEditText extiTextPassword;

  @NonNull
  public final AppCompatButton googleLogin;

  @NonNull
  public final ImageView iconView;

  @NonNull
  public final Button iniciarSesion;

  @NonNull
  public final TextInputLayout passwordLayout;

  @NonNull
  public final Button registrarme;

  @NonNull
  public final TextView textView;

  @Bindable
  protected WSLoginViewModel mVm;

  protected LoginFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextInputEditText editTextEmail, TextInputLayout email, TextInputEditText extiTextPassword,
      AppCompatButton googleLogin, ImageView iconView, Button iniciarSesion,
      TextInputLayout passwordLayout, Button registrarme, TextView textView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.editTextEmail = editTextEmail;
    this.email = email;
    this.extiTextPassword = extiTextPassword;
    this.googleLogin = googleLogin;
    this.iconView = iconView;
    this.iniciarSesion = iniciarSesion;
    this.passwordLayout = passwordLayout;
    this.registrarme = registrarme;
    this.textView = textView;
  }

  public abstract void setVm(@Nullable WSLoginViewModel vm);

  @Nullable
  public WSLoginViewModel getVm() {
    return mVm;
  }

  @NonNull
  public static LoginFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.login_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LoginFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LoginFragmentBinding>inflateInternal(inflater, R.layout.login_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static LoginFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.login_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LoginFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LoginFragmentBinding>inflateInternal(inflater, R.layout.login_fragment, null, false, component);
  }

  public static LoginFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LoginFragmentBinding bind(@NonNull View view, @Nullable Object component) {
    return (LoginFragmentBinding)bind(component, view, R.layout.login_fragment);
  }
}
