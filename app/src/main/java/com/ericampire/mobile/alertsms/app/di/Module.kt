package com.ericampire.mobile.alertsms.app.di

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.ericampire.mobile.alertsms.viewmodel.ContactViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<SharedPreferences> {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }
}

val viewModelModule = module {
    viewModel { ContactViewModel() }
}