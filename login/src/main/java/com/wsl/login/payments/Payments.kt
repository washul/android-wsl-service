package com.wsl.login.payments

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.wsl.login.R
import com.wsl.login.dagger.DaggerApplication
import com.wsl.login.dagger.RetroViewModelFactory
import com.wsl.login.database.ECard
import com.wsl.login.payments.viewmodel.PaymentViewModel
import com.wsl.login.utils.buildResource
import com.wsl.login.payments.openpay.OpenPayAddCardFragment
import kotlinx.android.synthetic.main.cardview_wallet_card.view.*
import kotlinx.android.synthetic.main.fragment_wallet.*
import javax.inject.Inject
import com.wsl.login.helpers.TAG
import com.wsl.login.helpers.initDaggerViewModel

class Payments : AppCompatActivity() {

    @Inject
    lateinit var paymentsViewModel: PaymentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        paymentsViewModel = initDaggerViewModel()

        setContentView( R.layout.fragment_wallet )
        BuildAll().run()

    }

    inner class BuildAll: Thread(){

/*      TODO: necesitamos recibir un usuario que este validado y/o validarlo en esta activity
*       con el fin de que podamos tokenizar tarjetas y clientes en openpay
*       crear los endpoints al server
*
* */

        private lateinit var adapter: AdapterWalletCards
        private var cards: List<ECard>? = ArrayList()

        override fun run() {
            super.run()

            paymentsViewModel.getUserLiveData().observe( this@Payments, Observer {  user ->

                if ( user == null ){

//                    TODO: Implement error with the user or lunch login
                    return@Observer

                }

                paymentsViewModel.downloadCards {

                    Log.e(TAG, it.toString())

                    if ( it == null ){
                        return@downloadCards
                    }

                    paymentsViewModel.saveCards(it)

                }

                buildRecycler()

            })

            addPaymentMethod.setOnClickListener {

                val dialog = OpenPayAddCardFragment()
                val ft = supportFragmentManager.beginTransaction()
                dialog.show(ft, OpenPayAddCardFragment.TAG)

            }

        }

        private fun buildRecycler(){

            paymentsViewModel.getCardsLiveData().observe(this@Payments, Observer { cardList->
                //TODO: las tarjetas se estan duplicando por que no se limpia el recyclerview
                if (cardList != null && cardList.isNotEmpty() ) {

                    (this.cards as ArrayList).addAll(cardList)
                    adapter.notifyDataSetChanged()

                }

            })

            (this.cards as ArrayList).add(
                ECard(
                    id = com.wsl.login.utils.ID_CASH_WALLET,
                    card_number = getString(R.string.efectivo)
                )
            )

            adapter = AdapterWalletCards( this@Payments, this@BuildAll.cards!! )

            recycler?.apply {

                layoutManager = LinearLayoutManager( this@Payments )
                this.adapter = this@BuildAll.adapter

            }

            initSwipe()

        }

        private fun initSwipe() {

            val p = Paint()

            val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

                override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition

                    if (direction == ItemTouchHelper.LEFT) {
//                        userViewModel.removeCard( this@BuildAll.cards!![position] ){}
                    } else {
                        removeView()
                    }
                }

                override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                    val icon: Bitmap
                    if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                        val itemView = viewHolder.itemView
                        val height = itemView.bottom.toFloat() - itemView.top.toFloat()
                        val width = height / 3

                        if (dX < 0)  {
                            p.color = Color.parseColor("#D32F2F")
                            val background = RectF(itemView.right.toFloat() + dX, itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
                            c.drawRect(background, p)
                            icon = BitmapFactory.decodeResource(resources, R.drawable.ic_trash)
                            val iconDest = RectF(itemView.right.toFloat() - 2 * width, itemView.top.toFloat() + width, itemView.right.toFloat() - width, itemView.bottom.toFloat() - width)
                            c.drawBitmap(icon, null, iconDest, p)
                        }
                    }
                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                }
            }
            val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
            itemTouchHelper.attachToRecyclerView(recycler)
        }

        private fun removeView() {
//            if (this@Payments.parent != null) {
//                (this@Payments.parent as ViewGroup).removeView(this@Payments.view)
//            }
        }

    }

    class AdapterWalletCards(private val context: Context,
                             private var cards: List<ECard> ):
        RecyclerView.Adapter<AdapterWalletCards.ViewHolder>() {

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val item = cards[position]

            holder.title.text = "•••• ${item.card_number?.subSequence(item.card_number!!.length-4, item.card_number!!.length)}"

            if (item.id == com.wsl.login.utils.ID_CASH_WALLET){

                holder.title.text = item.card_number
                holder.image.buildResource( R.drawable.money, context )

            }

            if ( item.brand == "visa" ){

                holder.image.buildResource( R.drawable.visa_logo, context )

            }

        }

        fun addItem( newItems: List<ECard> ){

            this.cards = newItems
            notifyItemInserted( cards.size )

        }

        fun removeItem( position: Int ){
            notifyItemRemoved( position )
            (this.cards as ArrayList<ECard>).removeAt( position )

        }

        inner class ViewHolder( view: View ): RecyclerView.ViewHolder( view ) {

            val title = view.findViewById<MaterialTextView>(R.id.number_card)
            val image = view.image_card!!

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder( LayoutInflater.from(context).inflate(R.layout.cardview_wallet_card, parent, false) )

        override fun getItemCount(): Int = cards.size

    }

}

