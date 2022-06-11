package com.wsl.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.domain.domain.login.models.User
import kotlin.reflect.full.memberProperties


@Entity(tableName = "User")
data class EUser constructor(

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

)

fun User.toEUser() = with (::EUser) {
    val propertiesByName = User::class.memberProperties.associateBy { it.name }
    callBy(args = parameters.associateWith { parameter ->
        when(parameter.name){
            else -> propertiesByName[parameter.name]?.get(this@toEUser)
        }
    })
}

fun EUser.setUndefinedAsNull() {
    if(this.google_uid.equals("undefined")){this.google_uid = null}
    if(this.customer_id.equals("undefined")){this.customer_id = null}
    if(this.name.equals("undefined")){this.name = null}
    if(this.last_name.equals("undefined")){this.last_name = null}
    if(this.username.equals("undefined")){this.username = null}
    if(this.email.equals("undefined")){this.email = null}
    if(this.country.equals("undefined")){this.country = null}
    if(this.state.equals("undefined")){this.state = null}
    if(this.city.equals("undefined")){this.city = null}
    if(this.postal_code.equals("undefined")){this.postal_code = null}
    if(this.country_code.equals("undefined")){this.country_code = null}
    if(this.phone.equals("undefined")){this.phone = null}
    if(this.address.equals("undefined")){this.address = null}
    if(this.latitude.equals("undefined")){this.latitude = null}
    if(this.longitude.equals("undefined")){this.longitude = null}
    if(this.sex.equals("undefined")){this.sex = null}
    if(this.typeOfUser.equals("undefined")){this.typeOfUser = null}
    if(this.tokendevice.equals("undefined")){this.tokendevice = null}
    if(this.image_uri.equals("undefined")){this.image_uri = null}
    if(this.password.equals("undefined")){this.password = null}
}