package com.wsl.payments.openpay

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ProgressDialogFragment: DialogFragment() {

    fun newInstance(msgId: Int): ProgressDialogFragment {
        val fragment = ProgressDialogFragment()

        val args = Bundle()
        args.putInt("msgId", msgId)

        fragment.arguments = args

        return fragment
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val msgId = arguments!!.getInt("msgId")
        val dialog = ProgressDialog(activity)
        dialog.setMessage(activity!!.resources.getString(msgId))
        return dialog
    }

}