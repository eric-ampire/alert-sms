package com.ericampire.mobile.alertsms.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    var uid: String,
    val number: String,
    val name: String
) : Parcelable