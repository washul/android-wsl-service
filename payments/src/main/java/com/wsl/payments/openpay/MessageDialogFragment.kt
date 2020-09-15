package com.wsl.payments.openpay

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle

class MessageDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        val title = arguments.getInt("tiempo_estimado")
        val message = arguments.getString("message")

        return AlertDialog.Builder(activity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                "ok"
            ) { dialogInterface, i -> dialogInterface.dismiss() }
            .create()
    }

    companion object {
        fun newInstance(title: Int, message: String): MessageDialogFragment {
            val fragment = MessageDialogFragment()

            val args = Bundle()
            args.putInt("tiempo_estimado", title)
            args.putString("message", message)

            fragment.arguments = args

            return fragment
        }
    }

}// Empty constructor required for DialogFragment
