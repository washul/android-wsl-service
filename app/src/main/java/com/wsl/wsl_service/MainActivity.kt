package com.wsl.wsl_service

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wsl.login.login.WSLoginActivity
import com.wsl.login.payments.Payments

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivityForResult( Intent(this@MainActivity, WSLoginActivity()::class.java), 1234)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when ( requestCode ){
            1234 -> {
                if ( resultCode != Activity.RESULT_OK ){
                    return
                }

                Log.e("*****USER LOGIN", data?.extras?.getString("uuid").toString() )

                startActivityForResult( Intent(this@MainActivity, Payments()::class.java), 1234)


            }
        }

    }

}