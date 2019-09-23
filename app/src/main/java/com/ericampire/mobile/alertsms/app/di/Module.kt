package com.ericampire.mobile.alertsms.app.di

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.nexmo.client.NexmoClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val nexmoModule = module {
    val apiKey = "485b13ba"
    val apiSecret = "J71LcIZwTATHySOi"

    val client = NexmoClient.builder()
        .apiKey(apiKey)
        .apiSecret(apiSecret)
        .build()


    single<NexmoClient> { client }
}

val appModule = module {
    single<SharedPreferences> {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }
}