package com.ericampire.mobile.alertsms.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.ericampire.mobile.alertsms.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Activation of koin
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule))
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}