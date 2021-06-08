package com.wsl.login.payments.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.google.android.material.textview.MaterialTextView
import com.wsl.login.R
import com.wsl.login.helpers.buildResource
import com.wsl.login.helpers.showSnackBarMessage
import com.wsl.login.profile.view_model.WSProfileViewModel
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.cardview_wallet_card.view.*


class SubscriptionFragment : DialogFragment() {

    private var UIView: View? = null
    private lateinit var viewModel: WSProfileViewModel

    companion object {
        const val TAG = "SubscriptionFragment"
    }

    override fun onStart() {
        super.onStart()

        val dialog = dialog

        if ( dialog != null ) {

            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        UIView = inflater.inflate(R.layout.fragment_subscription, container, false)
        BuildUI().run()
        return UIView
    }

    fun setSubscriptionData( viewModel: WSProfileViewModel ){
        this.viewModel = viewModel
        BuildData().run()
    }

    inner class BuildData: Thread() {

        override fun run() {
            super.run()

            viewModel.getSubscription { subscriptionResponse ->
                if (subscriptionResponse?.subscription == null){
                    return@getSubscription
                }

                subscriptionResponse.plan?.let { plan -> viewModel.savePlan( plan ) }
                viewModel.saveSubscription( subscriptionResponse.subscription )

                viewModel.currentPlan = subscriptionResponse.plan
                viewModel.subscriptionMutable.postValue(subscriptionResponse.subscription)
            }

        }

    }

    inner class BuildUI: Thread() {

        override fun run() {
            super.run()

            setDefaultObserver()

            /**cancelar subscription*/
            UIView?.findViewById<Button>(R.id.cancel_subscription_)?.setOnClickListener {
                viewModel.cancelSubscription( viewModel.subscriptions[0].id ){ subscriptionResponse ->

                    if ( subscriptionResponse == null ){
                        scrollview_parent_.showSnackBarMessage(getString(R.string.no_response_from_server_try_again))
                        return@cancelSubscription
                    }


                }

            }

        }

        @SuppressLint("SetTextI18n")
        private fun setDefaultObserver() {

            viewModel.subscriptionMutable.observe( this@SubscriptionFragment, Observer { subscription ->
                if ( subscription == null ){
                    account_status.text = getString(R.string.free_version)
                    return@Observer
                }
                val item = viewModel.currentPlan

                UIView?.findViewById<TextView>(R.id.name_)?.text = item?.name
                UIView?.image_card?.buildResource( R.drawable.google, context!! )
                UIView?.findViewById<MaterialTextView>(R.id.repeat_unit_text_)?.text = "${item?.repeat_every} ${item?.repeat_unit}"
                UIView?.findViewById<MaterialTextView>(R.id.trial_days_option_)?.text = item?.trial_days
                UIView?.findViewById<MaterialTextView>(R.id.amount_)?.text = item?.amount
            })


        }

    }

}