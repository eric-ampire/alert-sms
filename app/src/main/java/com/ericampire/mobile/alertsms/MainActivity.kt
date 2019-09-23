package com.ericampire.mobile.alertsms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.ericampire.mobile.alertsms.databinding.ActivityMainBinding
import com.nexmo.client.NexmoClient
import com.nexmo.client.sms.MessageStatus
import com.nexmo.client.sms.messages.TextMessage
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }

    fun launchAlert(view: View) {

    }
}
