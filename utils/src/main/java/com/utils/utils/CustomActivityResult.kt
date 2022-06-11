package com.utils.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class CustomActivityResult: ActivityResultContract<Int, Intent?>() {

        override fun createIntent(context: Context, intentType: Int) =
            Intent()

        override fun parseResult(resultCode: Int, result: Intent?) : Intent? {
            if (resultCode != Activity.RESULT_OK) {
                return null
            }
            return result
        }


}