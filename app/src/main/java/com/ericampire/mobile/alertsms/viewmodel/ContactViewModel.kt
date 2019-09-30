package com.ericampire.mobile.alertsms.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ericampire.mobile.alertsms.model.Contact

class ContactViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Contact>>()
    val data: LiveData<List<Contact>>
        get() = _data

    fun delete(item: Contact) {
        val oldData = data.value?.toMutableList() ?: mutableListOf()
        oldData.remove(item)

        _data.value = oldData
    }

    fun edit(item: Contact) {

    }

    fun add(item: Contact) {
        val oldData = data.value?.toMutableList() ?: mutableListOf()
        oldData.add(item)

        _data.value = oldData
    }
}
