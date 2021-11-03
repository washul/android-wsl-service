package com.wsl.wsl_service

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.wsl.login.helpers.*
import com.wsl.login.login.WSLoginActivity
import com.wsl.login.payments.Payments
import com.wsl.login.profile.ProfileActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                onActivityResultCustom(data)
            }
        }

        val intent = Intent(this, WSLoginActivity::class.java)
        intent.putExtra( WSL_ACTION_PARAM_NAME, WSL_LOGIN_ACTION_AUTO_SIGN_IN )
        resultLauncher.launch(intent)
    }

    private fun loadUI() {
        setContentView(R.layout.activity_main)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        val button_payments = findViewById<Button>(R.id.button_payments)
        val button_wallet = findViewById<Button>(R.id.button_wallet)
        val button_profile = findViewById<Button>(R.id.button_profile)
        button_payments.setOnClickListener {

            val intent = Intent(this@MainActivity, Payments()::class.java)
            resultLauncher.launch( intent )
        }

        button_wallet.setOnClickListener {

            val arrayList = ArrayList<Int>()
            arrayList.add(WSL_PAYMENTS_ACTION_SHOW_WALLET)

            val intent = Intent(this@MainActivity, Payments()::class.java)
            intent.putExtra( WSL_ACTION_PARAM_NAME, arrayList )
            resultLauncher.launch(intent)
        }

        button_profile.setOnClickListener {
            val intent = Intent(this@MainActivity, ProfileActivity()::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun onActivityResultCustom(data: Intent?) {
        val flag = data?.extras?.getInt(WSL_FLAG_NAME)
        when (data?.extras?.getInt(WSL_ACTION_PARAM_NAME)){

            /**Login Answers*/
            WSL_LOGIN_VIEW_REQUEST_CODE -> {

                when(flag){
                    WSL_LOGIN_ANSWER_NO_SIGN_IN -> {
                        Log.e(TAG,"*****USER NO SIGN IN" )
                    }
                    WSL_LOGIN_ANSWER_SIGN_IN -> {
                        Log.e("*****USER LOGIN", data.extras?.getString(WSL_LOGIN_UUID_USER).toString() )
                        loadUI()
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