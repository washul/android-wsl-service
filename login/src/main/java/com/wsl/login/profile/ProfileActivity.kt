package com.wsl.login.profile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.wsl.login.R
import com.wsl.login.database.entities.ECard
import com.wsl.login.helpers.*
import com.wsl.login.payments.fragments.WalletFragment
import com.wsl.login.payments.fragments.SubscriptionFragment
import com.wsl.login.profile.view_model.ProfileViewModel
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_wallet.*


class ProfileActivity : AppCompatActivity() {

    internal lateinit var viewModel: ProfileViewModel

    private lateinit var progressBarCustom: ProgressBarCustom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        progressBarCustom = ProgressBarCustom.build(this, progressBar = findViewById(R.id.progress_bar_))
        progressBarCustom.show()

        viewModel = initDaggerViewModel()

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
                viewModel.subscriptionMutable.value = subscriptionResponse.subscription
            }

            viewModel.getUserCloud { loginResponse ->

                if ( loginResponse == null ){
                    viewModel.getUserLocalAsync {
                        if ( it == null ){
                            return@getUserLocalAsync
                        }
                        loginResponse?.user = it
                    }
                }
                if ( loginResponse == null ){
                    return@getUserCloud
                }

                viewModel.saveUser(loginResponse.user)
                viewModel.userMutable.value = loginResponse.user

            }

            viewModel.userMutable.observe(this@ProfileActivity, Observer {
                viewModel.user = it
                this@ProfileActivity.runOnUiThread {
                    BuildUI().run()
                }
            })

            try {
                val pInfo = this@ProfileActivity.packageManager.getPackageInfo(packageName, 0)
                viewModel.packageVersion = pInfo.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

        }

    }

    inner class BuildUI: Thread() {

        private lateinit var adapter: WalletFragment.AdapterWalletCards

        @SuppressLint("SetTextI18n")
        override fun run() {
            super.run()
            setDefaultObserver()

            Picasso
                .with(this@ProfileActivity)
                .load(viewModel.user.image_uri)
                .into(image_profile_)

            /**Presentation information*/
            name_.text = "${ viewModel.user.name}"
            if (viewModel.user.city != "") city_.text = viewModel.user.city else city_.visibility = View.GONE

            /**Account information*/
            email_.text = viewModel.user.email

            /**OpenPay account*/
            if ( viewModel.user.customer_id != null && viewModel.user.customer_id != "" ){

                constraintLayoutCards.visibility = View.VISIBLE
                buildRecyclerCards()

            }

            /**General information*/
            if ( viewModel.user.name != null && viewModel.user.last_name != null ) {
                full_name_.setSpannableText(
                    getString(R.string.holder_name),
                    "${viewModel.user.name!!} ${viewModel.user.last_name!!}"
                )
            }

            province_.setSpannableText(
                getString(R.string.province),
                "${viewModel.user.country ?: ""} ${viewModel.user.state ?: ""} ${viewModel.user.city ?: ""}"
            )

            address_.setSpannableText(getString(R.string.address), viewModel.user.address ?: "")

            postal_code_.setSpannableText(
                getString(R.string.postal_code),
                viewModel.user.postal_code ?: ""
            )

            phone_.setSpannableText(getString(R.string.phone), viewModel.user.phone ?: "")

            edit_profile_.setOnClickListener {

                progressBarCustom.show()

                val dialog = UpdateProfileFragment()
                val ft = supportFragmentManager.beginTransaction()
                dialog.show(ft, UpdateProfileFragment.TAG)

                progressBarCustom.dismiss()
            }

            /**About*/
            version_.text = "Version: ${viewModel.packageVersion}"

            /**Actions*/
            log_out_.setOnClickListener {
                viewModel.getLogOut {
                    this@ProfileActivity.intent.putExtra( WSL_FLAG_NAME, WSL_PROFILE_ANSWER_LOG_OUT)
                    setResult(Activity.RESULT_OK, this@ProfileActivity.intent)
                    finish()
                }
            }

            progressBarCustom.dismiss()
        }

        private fun setDefaultObserver() {

            viewModel.subscriptionMutable.observe( this@ProfileActivity, Observer { subscription ->
                if ( subscription == null ){
                    account_status.text = getString(R.string.free_version)
                    return@Observer
                }
                account_status.text = getString(R.string.premium)

                /**Subscription Methods*/
                subscription_.visibility = View.VISIBLE
                subscription_.text = viewModel.currentPlan?.name

                subscription_.setOnClickListener {

                    val dialog = SubscriptionFragment()
                    dialog.setSubscriptionData( viewModel )

                    val ft = supportFragmentManager.beginTransaction()
                    dialog.show(ft, SubscriptionFragment.TAG)

                }

            })


        }

        private fun TextView.setSpannableText(firstText: String, secondText: String){

            val spannable = SpannableString("$firstText\n\t$secondText")

            /**primera cadena*/
            spannable.setSpan(
                ForegroundColorSpan(resources.getColor(R.color.colorGray)),
                0,
                firstText.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            /**segunda cadena spanns*/
            spannable.setSpan(
                ForegroundColorSpan(resources.getColor(R.color.colorBlack)),
                firstText.length + 2,
                (firstText.length + 2) + secondText.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannable.setSpan(
                RelativeSizeSpan(1.5f),
                firstText.length + 2,
                (firstText.length + 2) + secondText.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            this.text = spannable


        }

        private fun buildRecyclerCards(){

            viewModel.cardsMutable.observe(this@ProfileActivity, Observer { cardList ->

                viewModel.cards.addAll(cardList)
                adapter.notifyDataSetChanged()

                progressBarCustom.dismiss()

            })

            viewModel.cards.add(
                ECard(
                    id = ID_CASH_WALLET,
                    card_number = getString(R.string.efectivo)
                )
            )

            adapter = WalletFragment.AdapterWalletCards(this@ProfileActivity, viewModel.cards){

            }

            recycler?.apply {

                layoutManager = LinearLayoutManager(this@ProfileActivity)
                this.adapter = this@BuildUI.adapter

            }

        }

    }

}