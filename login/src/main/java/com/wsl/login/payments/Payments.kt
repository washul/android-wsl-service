package com.wsl.login.payments

//import android.annotation.SuppressLint
//import android.app.Activity
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.textview.MaterialTextView
//import com.wsl.login.R
//import com.wsl.data.db.entities.EPlan
//import com.wsl.login.helpers.*
//import com.wsl.login.login.WSLoginActivity
//import com.wsl.login.payments.fragments.WalletFragment
////import com.wsl.login.payments.viewmodel.WSPaymentViewModel
//
//class Payments : AppCompatActivity()
//{
//
////    lateinit var viewModel: WSPaymentViewModel
//
//    private lateinit var progressBarCustom: WSProgressBarCustom
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        viewModel.activityActions = intent.getIntegerArrayListExtra( WSL_ACTION_PARAM_NAME ) ?: ArrayList()
//
//        if ( viewModel.activityActions.isNotEmpty() && viewModel.activityActions.contains( WSL_PAYMENTS_ACTION_SHOW_WALLET ) ){
//
//            walletDialog()
//
//        }else{
//            BuildData().run()
//        }
//
//    }
//
//    internal fun paidCorrectly(subscriptionID: String ){
//        this.intent.putExtra( WSL_FLAG_NAME, WSL_PAYMENTS_ACTION_PAY_SUBSCRIPTION )
//        this.intent.putExtra( WSL_PAYMENTS_SUBSCRIPTION_ID, subscriptionID )
//        setResult(Activity.RESULT_OK, this.intent)
//        finish()
//    }
//
//    fun walletDialog() {
//
//        /**Call to wallet fragment to select the payment method and proceed to pay*/
//        val dialog = WalletFragment()
//        dialog.viewModel = viewModel
//        val ft = supportFragmentManager.beginTransaction()
//        dialog.show(ft, WalletFragment.TAG)
//
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if ( resultCode != Activity.RESULT_OK ){
//            return
//        }
//
//        when ( requestCode ){
//            WSL_LOGIN_VIEW_REQUEST_CODE -> {
//
//                Log.e("*****USER LOGIN", data?.extras?.getString("uuid").toString() )
//                BuildData().run()
//
//            }
//        }
//
//    }
//
//    inner class BuildData: Thread() {
//
//       override fun run() {
//           super.run()
//
//           //        TODO: TEMPORAL
////           viewModel.openPayPlan = EPlan(
////               id = "paz9dmysxsw0jar6az6m",
////               name = "te pehe-hora monthly subscription",
////               amount = "180",
////               creation_date = "2020-07-19T11:46:18-05:00",
////               repeat_every = "1",
////               repeat_unit = "month",
////               retry_times = "2",
////               status = "active",
////               status_after_retry = "cancelled",
////               trial_days = "30",
////               currency = "MXN"
////           )
//
////           viewModel.getUserLiveData().observe( this@Payments, Observer { user ->
////
////               if ( user == null ){
////
////                   startActivityForResult( Intent(this@Payments, WSLoginActivity()::class.java), WSL_LOGIN_VIEW_REQUEST_CODE)
////                   this.interrupt()
////                   return@Observer
////               }
////           })
//
//           if ( viewModel.currentPlan == null ){
//
////               viewModel.getPlanList { planResponse ->
////
////                   if ( planResponse == null ){
////                       return@getPlanList
////                   }
////                   if ( planResponse.planList == null ){
////                       return@getPlanList
////                   }
////
////                   viewModel.planList = planResponse.planList
////
////               }
//
//           } else {
//               walletDialog()
//           }
//
//           viewModel.planListMutable.observe( this@Payments, Observer {
//
//               runOnUiThread {
//                   BuildUI().run()
//               }
//
//           })
//
//       }
//
//   }
//
//    inner class BuildUI: Thread() {
//
//        private lateinit var adapter: AdapterPlan
//
//        override fun run() {
//            super.run()
//            this@Payments.setContentView(R.layout.activity_payments)
//
////            progressBarCustom = WSProgressBarCustom.build(this@Payments, progressBar = progress_bar_)
//            progressBarCustom.show()
//
//            buildRecycler()
//
//            if ( viewModel.planList.isNotEmpty() ){
//
//                adapter.addItem( viewModel.planList )
//            }
//
//            progressBarCustom.dismiss()
//
//        }
//
//        private fun buildRecycler(){
//
//            adapter = AdapterPlan( this@Payments ){ plan ->
//
//                viewModel.currentPlan = plan
//                walletDialog()
//            }
//
////            recycler?.apply {
////
////                layoutManager = LinearLayoutManager( context!! )
////                this.adapter = this@BuildUI.adapter
////            }
//
//        }
//
//        inner class AdapterPlan(private val context: Context, private val function: (EPlan) -> Unit):
//            RecyclerView.Adapter<AdapterPlan.ViewHolder>() {
//
//            private var itemList = ArrayList<EPlan>()
//
//            @SuppressLint("SetTextI18n")
//            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//                val item = itemList[position]
//
////                holder.image.buildResource( R.drawable.google, context )
//                holder.name.text = item.name
//                holder.repeat_Every_.text = "${item.repeat_every} ${item.repeat_unit}"
//                holder.amount_.text = item.amount
//                holder.trial_days_.text = item.trial_days
//
//                holder.itemView.setOnClickListener {
//                    function(item)
//                }
//
//            }
//
//            fun addItem( newItems: List<EPlan> ){
//
//                this.itemList = newItems as ArrayList<EPlan>
//                notifyItemInserted( itemList.size )
//
//            }
//
//            inner class ViewHolder( view: View ): RecyclerView.ViewHolder( view ) {
//
////                val image = view.image_card!!
//                val name = view.findViewById<MaterialTextView>(R.id.name_)
//                val repeat_Every_ = view.findViewById<MaterialTextView>(R.id.repeat_unit_text_)
//                val trial_days_ = view.findViewById<MaterialTextView>(R.id.trial_days_option_)
//                val amount_ = view.findViewById<MaterialTextView>(R.id.amount_)
//
//
//            }
//
//            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
//                ViewHolder( LayoutInflater.from(context).inflate(R.layout.cardview_plan, parent, false) )
//
//            override fun getItemCount(): Int = itemList.size
//
//        }
//
//    }
//}

