package com.ericampire.mobile.alertsms.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Contact(
    val uid: String,
    val number: String,
    val name: String
) : Parcelable