package com.wsl.login.payments.fragments

//import android.annotation.SuppressLint
//import android.content.Context
//import android.content.DialogInterface
//import android.graphics.*
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.cardview.widget.CardView
//import androidx.core.content.ContextCompat
//import androidx.fragment.app.DialogFragment
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.ItemTouchHelper
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.dialog.MaterialAlertDialogBuilder
//import com.google.android.material.textview.MaterialTextView
//import com.wsl.login.R
//import com.wsl.data.db.entities.ECard
//import com.wsl.login.helpers.*
//import com.wsl.login.payments.viewmodel.WSPaymentViewModel
//import com.wsl.login.payments.Payments
//
//class WalletFragment : DialogFragment()
//{
//
//    lateinit var viewModel: WSPaymentViewModel
//    private lateinit var progressBarCustom: WSProgressBarCustom
//
//    private var UI: View? = null
//
//    companion object {
//        const val TAG = "WalletFragment"
//    }
//
//    override fun onStart() {
//        super.onStart()
//
//        val dialog = dialog
//        if ( dialog != null ) {
//            val width = ViewGroup.LayoutParams.MATCH_PARENT
//            val height = ViewGroup.LayoutParams.MATCH_PARENT
//            dialog.window?.setLayout(width, height)
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        UI = inflater.inflate(R.layout.fragment_wallet, container, false)
//
//        progressBarCustom = WSProgressBarCustom.build( requireActivity(), progressBar = UI!!.findViewById(R.id.progress_bar_) )
//        progressBarCustom.show()
//
//        BuildData().run()
//        return UI
//    }
//
//    private fun optionalMessage( title: String, message: String, function: (Boolean) -> Unit ){
//
//        MaterialAlertDialogBuilder(requireActivity(), R.style.ThemeOverlay_App_MaterialAlertDialog)
//            .setTitle( title)
//            .setMessage( message )
//            .setNeutralButton(getString(R.string.cancel)) { _, _ ->
//                // Respond to neutral button press
//                function(false)
//            }
//            .setNegativeButton(getString(R.string.decline)) { _, _ ->
//                // Respond to negative button press
//                function(false)
//            }
//            .setPositiveButton(getString(R.string.aceptar)) { _, _ ->
//                function(true)
//            }
//            .show()
//
//    }
//
//    override fun onDismiss(dialog: DialogInterface) {
//        if ( viewModel.activityActions.isNotEmpty() && viewModel.activityActions.contains( WSL_PAYMENTS_ACTION_SHOW_WALLET ) ){
//            requireActivity().finish()
//        }
//        super.onDismiss(dialog)
//    }
//
//    inner class BuildData: Thread(){
//
//        override fun run() {
//            super.run()
//
//            getCloudCards()
//
//            BuildUI().run()
//
//        }
//
//        private fun getCloudCards(){
//
////            viewModel.downloadCards { cardList ->
////
////                if ( cardList == null ){
////                    activity?.runOnUiThread {
////                        createOpenPayAccount()
////                    }
////                    return@downloadCards
////                }
////
////                if ( cardList.isEmpty() ){
////                    progressBarCustom.dismiss()
////                    return@downloadCards
////                }
////
////                viewModel.saveCards(cardList)
////
////            }
//
//        }
//
//        private fun createOpenPayAccount(){
//
//            optionalMessage(
//                getString(R.string.title_no_openpay_account_message),
//                getString(R.string.message_no_openpay_account_massage) ) { optionalMessageResponse ->
//
//                if ( !optionalMessageResponse ){
//                    return@optionalMessage
//                }
//
//                viewModel.createOpenPayCustomer { createResponse ->
//
//                    if ( !createResponse ){
//                        UI?.showSnackBarMessage("No se a podido generar la cuenta.")
//                        return@createOpenPayCustomer
//                    }
//
////                    val dialog = OpenPayAddCardFragment()
//                    val ft = childFragmentManager.beginTransaction()
////                    dialog.show(ft, OpenPayAddCardFragment.TAG)
//
//                }
//
//            }
//
//        }
//
//    }
//
//    inner class BuildUI: Thread() {
//        private lateinit var adapter: AdapterWalletCards
//        private val addPaymentMethod = UI?.findViewById<CardView>(R.id.addPaymentMethod)
//
//        override fun run() {
//            super.run()
//
//            buildRecycler()
//
//            /**Add payment method button*/
//            addPaymentMethod?.setOnClickListener {
//
////                val dialog = OpenPayAddCardFragment()
//                val ft = childFragmentManager.beginTransaction()
////                dialog.show(ft, OpenPayAddCardFragment.TAG)
//
//            }
//
//            progressBarCustom.dismiss()
//
//        }
//
//        private fun createSubscription( card: ECard ){
//
//            if ( viewModel.currentPlan != null && viewModel.currentPlan?.planID != "") {
//
//                /**Make message to user about pan*/
//                var period = viewModel.currentPlan?.repeat_every
//
//                val unitString = when( viewModel.currentPlan?.repeat_unit ){
//                    "month" -> if (period!!.toInt() > 1 ) "${getString(R.string.month)}s" else getString(R.string.month)
//                    "week" ->  if (period!!.toInt() > 1 ) "${getString(R.string.week)}s" else getString(R.string.week)
//                    "year" ->  if (period!!.toInt() > 1 ) "${getString(R.string.year)}s" else getString(R.string.year)
//                    else -> ""
//                }
//
//                period = if ( viewModel.currentPlan?.repeat_every == "1" ) "" else viewModel.currentPlan?.repeat_every
//
//                val message = getString(R.string.message_to_plan_pay) + "$period $unitString"
//
//                optionalMessage(viewModel.currentPlan!!.name, message) { responseMessage ->
//
//                    if (!responseMessage)
//                        return@optionalMessage
//
//                    /** Proceed to pay*/
////                    viewModel.generateSubscription( card.id, viewModel.currentPlan!!.planID ) { subscriptionResponse ->
////
////                        if (subscriptionResponse?.subscription == null){
////                            UI?.showSnackBarMessage(getString(R.string.no_pay_message))
////                            return@generateSubscription
////                        }
////
////                        viewModel.saveSubscription( subscriptionResponse.subscription )
////                        (activity as Payments).paidCorrectly( subscriptionResponse.subscription.id )
////
////                        this@WalletFragment.dismiss()
////
////                    }
//
//                }
//
//            }
//
//        }
//
//        private fun RecyclerView.initSwipe() {
//
//            val p = Paint()
//
//            val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
//
//                override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
//                    return false
//                }
//
//                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                    val position = viewHolder.adapterPosition
//
//                    if (direction == ItemTouchHelper.LEFT) {
//                        removeCard( position )
//                    } else {
//                        removeView( viewHolder.itemView )
//                    }
//                }
//
//                override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
//
//                    val icon: Bitmap
//                    if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//
//                        val itemView = viewHolder.itemView
//                        val height = itemView.bottom.toFloat() - itemView.top.toFloat()
//                        val width = height / 3
//
//                        if (dX < 0)  {
//                            p.color = Color.parseColor("#D32F2F")
//                            val background = RectF(itemView.right.toFloat() + dX, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
//                            c.drawRect(background, p)
//                            icon = ContextCompat.getDrawable( context!!, R.drawable.ic_trash )!!.getBitmap()
//                            val iconDest = RectF(itemView.right.toFloat() - 2 * width, itemView.top.toFloat() + width, itemView.right.toFloat() - width, itemView.bottom.toFloat() - width)
//                            c.drawBitmap(icon, null, iconDest, p)
//                        }
//                    }
//                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
//                }
//            }
//            ItemTouchHelper( simpleItemTouchCallback ).attachToRecyclerView(this)
//
//        }
//
//        private fun removeCard( position: Int ){
//
//            activity?.runOnUiThread {
//                progressBarCustom.show()
//
////                viewModel.removeCard( viewModel.cards[position].id ){ response ->
////                    when {
////                        response == null -> {
////                            progressBarCustom.dismiss()
////                            adapter.notifyItemChanged( position )
////                            return@removeCard
////                        }
////                        response.code == "1007" -> {
////                            UI?.showSnackBarMessage(response.message ?: "Error")
////                            adapter.notifyItemChanged( position )
////                        }
////                        else -> {
////                            adapter.removeItem(position)
////                            UI?.showSnackBarMessage(getString(R.string.card_remove_succesfully))
////                        }
////                    }
////
////                    progressBarCustom.dismiss()
////                }
//            }
//
//        }
//
//        private fun buildRecycler(){
//
////            viewModel.cardsMutable.observe(this@WalletFragment, Observer { cardList->
////
////                viewModel.cards.addAll(cardList)
////                adapter.notifyDataSetChanged()
////
////                progressBarCustom.dismiss()
////
////            })
//
//            viewModel.cards.add(
//                ECard(
//                    id = ID_CASH_WALLET,
//                    card_number = getString(R.string.efectivo)
//                )
//            )
//
//            adapter = AdapterWalletCards( context!!, viewModel.cards ){ card ->
//
//                createSubscription( card )
//
//            }
//
//            UI?.findViewById<RecyclerView>(R.id.recycler)?.apply {
//
//                layoutManager = LinearLayoutManager( context!! )
//                this.adapter = this@BuildUI.adapter
//
//            }
//
//            UI?.findViewById<RecyclerView>(R.id.recycler)?.initSwipe()
//        }
//
//    }
//
//    class AdapterWalletCards(private val context: Context,
//                             private var cards: List<ECard>, private val function: (ECard) -> Unit):
//        RecyclerView.Adapter<AdapterWalletCards.ViewHolder>() {
//
//        @SuppressLint("SetTextI18n")
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//            val item = cards[position]
//
////            holder.title.text = "•••• ${item.card_number?.subSequence(item.card_number.length-4, item.card_number.length)}"
//
//            if (item.id == ID_CASH_WALLET){
//
//                holder.title.text = item.card_number
////                holder.image.buildResource( R.drawable.money, context )
//
//            }
//
//            if ( item.brand == "visa" ){
//
////                holder.image.buildResource( R.drawable.visa_logo, context )
//
//            }
//
//            holder.itemView.setOnClickListener {
//
//                function(item)
//
//            }
//
//        }
//
//        fun addItem( newItems: List<ECard> ){
//
//            this.cards = newItems
//            notifyItemInserted( cards.size )
//
//        }
//
//        fun removeItem( position: Int ){
//            notifyItemRemoved( position )
//            (this.cards as ArrayList<ECard>).removeAt( position )
//
//        }
//
//        inner class ViewHolder( view: View ): RecyclerView.ViewHolder( view ) {
//
//            val title = view.findViewById<MaterialTextView>(R.id.number_card)
////            val image = view.image_card!!
//
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
//            ViewHolder( LayoutInflater.from(context).inflate(R.layout.cardview_wallet_card, parent, false) )
//
//        override fun getItemCount(): Int = cards.size
//
//    }
//
//}