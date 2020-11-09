package com.wsl.wsl_service

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wsl.login.helpers.*
import com.wsl.login.login.WSLoginActivity
import com.wsl.login.payments.Payments
import com.wsl.login.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginIntent = Intent(this@MainActivity, WSLoginActivity()::class.java)
        loginIntent.putExtra( WSL_ACTION_PARAM_NAME, WSL_LOGIN_ACTION_AUTO_SIGN_IN )
        startActivityForResult( loginIntent, WSL_LOGIN_VIEW_REQUEST_CODE )

        button_payments.setOnClickListener {

            val intent = Intent(this@MainActivity, Payments()::class.java)
            startActivityForResult( intent, WSL_PAYMENTS_VIEW_REQUEST_CODE )
        }

        button_wallet.setOnClickListener {

            val arrayList = ArrayList<Int>()
            arrayList.add(WSL_PAYMENTS_ACTION_SHOW_WALLET)

            val intent = Intent(this@MainActivity, Payments()::class.java)
            intent.putExtra( WSL_ACTION_PARAM_NAME, arrayList )

            startActivityForResult( intent, WSL_PAYMENTS_VIEW_REQUEST_CODE )
        }

        button_profile.setOnClickListener {
            startActivityForResult( Intent(this@MainActivity, ProfileActivity()::class.java), WSL_PROFILE_VIEW_REQUEST_CODE )

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ( resultCode != Activity.RESULT_OK ){
            return
        }

        val flag = data?.extras?.getInt(WSL_FLAG_NAME)

        when ( requestCode ){

            /**Login Answers*/
            WSL_LOGIN_VIEW_REQUEST_CODE -> {

                when(flag){
                    WSL_LOGIN_ANSWER_NO_SIGN_IN -> {
                        Log.e(TAG,"*****USER NO SIGN IN" )
                    }
                    WSL_LOGIN_ANSWER_SIGN_IN -> {
                        Log.e("*****USER LOGIN", data.extras?.getString(WSL_LOGIN_UUID_USER).toString() )
                    }
                }

            }

            /**Profile Answers*/
            WSL_PROFILE_VIEW_REQUEST_CODE -> {

                when(flag){

                    WSL_PROFILE_ANSWER_LOG_OUT ->{
                        Log.e( TAG, "*****USER LOG OUT" )
                    }

                }

            }

            /**Payments Answers*/
            WSL_PAYMENTS_VIEW_REQUEST_CODE -> {

                when(flag){

                    WSL_PAYMENTS_ACTION_PAY_SUBSCRIPTION -> {

                        Log.e("****PAY SUBSCRIPTION", data.extras?.getString( WSL_PAYMENTS_SUBSCRIPTION_ID ).toString() )

                    }

                }

            }

        }

    }

}