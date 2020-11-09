package com.wsl.login.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SubscriptionResponse(

    @SerializedName("message") @Expose val message: String,
    @SerializedName("subscription") @Expose val subscription: ESubscription?,
    @SerializedName("plan") @Expose val plan: EPlan?

)

@Entity(tableName = "Subscription")
data class ESubscription(

    @PrimaryKey(autoGenerate = false)
    val id: String,

    val cancel_at_period_end: Boolean?,
    val charge_date: String?,
    val creation_date: String?,
    val current_period_number: String?,
    val period_end_date: String?,
    val trial_end_date: String?,
    val plan_id: String?,
    val customer_id: String?

)
