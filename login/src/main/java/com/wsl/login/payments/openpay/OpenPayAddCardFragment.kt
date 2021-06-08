package com.wsl.login.payments.openpay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.wsl.login.R
import com.wsl.login.helpers.showSnackBarMessage
import com.wsl.login.payments.Payments
import com.wsl.login.payments.viewmodel.WSPaymentViewModel
import kotlinx.android.synthetic.main.fragment_payments.view.*
import mx.openpay.android.OperationCallBack
import mx.openpay.android.OperationResult
import mx.openpay.android.exceptions.OpenpayServiceException
import mx.openpay.android.exceptions.ServiceUnavailableException
import mx.openpay.android.model.Card
import mx.openpay.android.model.Token
import mx.openpay.android.validation.CardValidator

class OpenPayAddCardFragment : DialogFragment() {

    private lateinit var vista: View
    private var deviceIDFragment: DeviceIdFragment? = null
    private lateinit var progressDialogFragment: ProgressDialogFragment
    private lateinit var viewModel: WSPaymentViewModel
//    private lateinit var cardRepository: CardRepository

    companion object {
        const val TAG = "addCardFragment"
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

        this.progressDialogFragment = ProgressDialogFragment().newInstance( R.string.progress_message )

        val fm = this.fragmentManager
        deviceIDFragment = (fm!!.findFragmentByTag("DeviceCollector") as DeviceIdFragment?)

        if ( deviceIDFragment == null ){

            deviceIDFragment = DeviceIdFragment()
            fm.beginTransaction().add(this.deviceIDFragment!!, "DeviceCollector").commit()

        }

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        vista = inflater.inflate(R.layout.fragment_payments, container, false)

        this.viewModel = ( activity!! as Payments ).viewModel

        vista.findViewById<Button>( R.id.btnGuardar ).setOnClickListener {

            saveCard()

        }

        return vista
    }

    private fun saveCard(){ this.addToken() }

    private fun getDeviceId(): String = this.deviceIDFragment!!.getDevicedId()

    private fun addToken(){

        val deviceID = getDeviceId()

        val openPay =  OpenPayuCredentials().getOpenPay()
        val card = Card()
        var isValid = true


        //HOLDER_NAME
        val holderNameEt = vista.findViewById<com.google.android.material.textfield.TextInputEditText>( R.id.holder_name_text )
        val holderName = holderNameEt.text.toString()
        card.holderName = holderName
        if ( !CardValidator.validateHolderName( holderName ) ){

            holderNameEt.error = getString( R.string.invalid_holder_name)
            vista.findViewById<com.google.android.material.textfield.TextInputLayout>( R.id.holder_name ).requestFocus()
            return

        }

        //CARD_NUMBER
        val cardNumberEt = vista.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.extiTextCardNumber)
        val cardNumber = cardNumberEt.text.toString()
        card.cardNumber(cardNumber)
        if (!CardValidator.validateNumber(cardNumber)) {
            cardNumberEt.error = this.getString(R.string.invalid_card_number)
            vista.findViewById<com.google.android.material.textfield.TextInputLayout>( R.id.passwordLayout ).requestFocus()
            return
        }

        //CVV2
        val cvv2Et = vista.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.editTextcvv2)
        val cvv = cvv2Et.text.toString()
        card.cvv2(cvv)
        if (!CardValidator.validateCVV(cvv, cardNumber)) {
            cvv2Et.error = this.getString(R.string.invalid_cvv)
            vista.findViewById<com.google.android.material.textfield.TextInputLayout>( R.id.cvv2 ).requestFocus()
            return
        }

        //YEAR
        val year = this.getInteger(vista.findViewById<androidx.appcompat.widget.AppCompatSpinner>( R.id.year_spinner ).selectedItem.toString() )

        //MONTH
        val month = this.getInteger( vista.findViewById<androidx.appcompat.widget.AppCompatSpinner>( R.id.month_spinner ).selectedItem.toString() )

        if ( !CardValidator.validateExpiryDate( month, year ) ){

            confirmationSnackBar( vista, this.getString( R.string.invalid_expire_date ) )
            return

        }

        if ( vista.editTextEmail!!.text.toString() == "" ){

            vista.emailLayout!!.error = "*Campo obligatorio"
            return

        }

        card.expirationMonth(month)
        card.expirationYear(year)

        this.progressDialogFragment.show( requireActivity().supportFragmentManager, "progress")
        openPay.createToken( card, object: OperationCallBack<Token> {
            override fun onSuccess(op: OperationResult<Token>?) {

                viewModel.registerCard( token_id = op?.result!!.id, device_session_id = deviceID ){ listCards->

                    this@OpenPayAddCardFragment.progressDialogFragment.dismiss()
                    this@OpenPayAddCardFragment.clearData()

                    if ( listCards == null ){
                        return@registerCard
                    }

                    viewModel.saveCards( listCards )
                    this@OpenPayAddCardFragment.dismiss()

                }

            }

            override fun onCommunicationError(error: ServiceUnavailableException?) {

                error!!.printStackTrace()
                this@OpenPayAddCardFragment.progressDialogFragment.dismiss()

//                ConfirmationMessage( context!!, this@OpenPayAddCardFragment.getString( R.string.error ), this@OpenPayAddCardFragment.getString( R.string.communication_error ) )

            }

            @SuppressLint("StringFormatInvalid")
            override fun onError(error: OpenpayServiceException?) {

                error!!.printStackTrace()
                this@OpenPayAddCardFragment.progressDialogFragment.dismiss()
                val desc: Int
                val msg: String?
                when (error.getErrorCode()) {
                    3001 -> {
                        desc = R.string.declined
                        msg = this@OpenPayAddCardFragment.getString(desc)
                    }
                    3002 -> {
                        desc = R.string.expired
                        msg = this@OpenPayAddCardFragment.getString(desc)
                    }
                    3003 -> {
                        desc = R.string.insufficient_funds
                        msg = this@OpenPayAddCardFragment.getString(desc)
                    }
                    3004 -> {
                        desc = R.string.stolen_card
                        msg = this@OpenPayAddCardFragment.getString(desc)
                    }
                    3005 -> {
                        desc = R.string.suspected_fraud
                        msg = this@OpenPayAddCardFragment.getString(desc)
                    }

                    2002 -> {
                        desc = R.string.already_exists
                        msg = this@OpenPayAddCardFragment.getString(desc)
                    }
                    else -> {
//                        desc = R.string.error_creating_card
                        msg = error.getDescription()
                    }
                }

                vista.showSnackBarMessage( getString( R.string.error, msg ) )

            }

        })



    }

    private fun clearData() {
        (vista.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.holder_name) ).editText?.setText("")
        (vista.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.passwordLayout) ).editText?.setText("")
        (vista.findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.cvv2) ).editText?.setText("")
        (vista.findViewById<View>(R.id.year_spinner) as Spinner).setSelection(0)
        (vista.findViewById<View>(R.id.month_spinner) as Spinner).setSelection(0)

    }

    private fun getInteger(number: String): Int {
        return try {
            Integer.valueOf(number)
        } catch (nfe: NumberFormatException) {
            0
        }

    }

}

@SuppressLint("ResourceAsColor")
fun confirmationSnackBar(root_layout: View, message: String ){

    val snackBar = Snackbar.make( root_layout, message, Snackbar.LENGTH_INDEFINITE )

    snackBar.setAction("Aceptar") {
        snackBar.dismiss()
    }
    snackBar.setActionTextColor( R.color.colorWhite )

    snackBar.show()


}
