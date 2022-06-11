package com.wsl.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** OpenPay plan to create a subscription */
@Entity(tableName = "Plan")
data class EPlan(

    @PrimaryKey(autoGenerate = false)
    val planID: String,

    val name: String,
    val amount: String,
    val creation_date: String,
    val repeat_every: String,
    val repeat_unit: String,
    val retry_times: String,
    val status: String,
    val status_after_retry: String,
    val trial_days: String,
    val currency: String

)

data class PlanResponse(

    @SerializedName("planList") @Expose val planList: List<EPlan>?,
    @SerializedName("message") @Expose val message: String?

)