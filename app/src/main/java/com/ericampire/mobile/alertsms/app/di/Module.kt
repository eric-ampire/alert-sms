package com.ericampire.mobile.alertsms.app.di

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<SharedPreferences> {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }
}