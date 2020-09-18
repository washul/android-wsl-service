package com.wsl.payments.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "User")
data class EUser(

    @PrimaryKey( autoGenerate = false )
    @SerializedName("uuid_user")    var uuid:           String,
    @SerializedName("customer_id")  var customer_id:    String? = null,
    @SerializedName("name")         var name:           String? = null,
    @SerializedName("last_name")    var last_name:      String? = null,
    @SerializedName("username")     var username:       String? = null,
    @SerializedName("email")        var email:          String? = null,
    @SerializedName("country")      var country:        String? = null,
    @SerializedName("state")        var state:          String? = null,
    @SerializedName("city")         var city:           String? = null,
    @SerializedName("postal_code")  var postal_code:    String? = null,
    @SerializedName("country_code") var country_code:   String? = null,
    @SerializedName("phone")        var phone:          String? = null,
    @SerializedName("address")      var address:        String? = null,
    @SerializedName("latitude")     var latitude:       String? = null,
    @SerializedName("longitude")    var longitude:      String? = null,
    @SerializedName("sex")          var sex:            String? = null,
    @SerializedName("usr_type")     var typeOfUser:     String? = null,
    @SerializedName("tokendevice")  var tokendevice:    String? = null,
    @SerializedName("password")     var password:       String? = null //this is used only on login form, we never use this data

)