package com.wsl.payments.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Card")
data class ECard(

    @PrimaryKey(autoGenerate = false)
    val id: 				String,
    val type: 			String? = "",
    val brand: 			String? = "",
    val address: 			String? = "",
    val card_number: 		String? = "",
    val holder_name: 		String? = "",
    val expiration_year: 	String? = "",
    val expiration_month:	String? = "",
    val allows_charges: 	String? = "",
    val allows_payouts: 	String? = "",
    val creation_date: 	String? = "",
    val bank_name: 		String? = "",
    val customer_id: 		String? = "",
    val bank_code: 		String? = ""



)