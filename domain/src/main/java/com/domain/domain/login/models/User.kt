package com.domain.domain.login.models

data class User constructor(
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
    var password:       String? = null

)