package com.wsl.login.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject


@Entity(tableName = "User")
data class EUser @Inject constructor(

    @PrimaryKey( autoGenerate = false )
    var uuid_user:      String,
    var google_uid:     String? = null,
    var customer_id:    String? = null,
    var name:           String? = null,
    var last_name:      String? = null,
    var username:       String? = null,
    var email:          String? = null,
    var country:        String? = null,
    var state:          String? = null,
    var city:           String? = null,
    var postal_code:    String? = null,
    var country_code:   String? = null,
    var phone:          String? = null,
    var address:        String? = null,
    var latitude:       String? = null,
    var longitude:      String? = null,
    var sex:            String? = null,
    var typeOfUser:     String? = null,
    var tokendevice:    String? = null,
    var image_uri:      String? = null,
    var password:       String? = null //this is used only on login form, we never use this data

) {
    fun setUndefinedFieldAsNull(): EUser {
        if(google_uid == "undefined") google_uid = null
        if(customer_id == "undefined") customer_id = null
        if(name == "undefined") name = null
        if(last_name == "undefined") last_name = null
        if(username == "undefined") username = null
        if(email == "undefined") email = null
        if(country == "undefined") country = null
        if(state == "undefined") state = null
        if(city == "undefined") city = null
        if(postal_code == "undefined") postal_code = null
        if(country_code == "undefined") country_code = null
        if(phone == "undefined") phone = null
        if(address == "undefined") address = null
        if(latitude == "undefined") latitude = null
        if(longitude == "undefined") longitude = null
        if(sex == "undefined") sex = null
        if(typeOfUser == "undefined") typeOfUser = null
        if(tokendevice == "undefined") tokendevice = null
        if(image_uri == "undefined") image_uri = null
        if(password == "undefined") password = null

        return this
    }
}