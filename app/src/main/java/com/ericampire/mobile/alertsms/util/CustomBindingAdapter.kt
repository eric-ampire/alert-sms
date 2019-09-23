package com.ericampire.mobile.alertsms.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("setAdapter")
fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
    setHasFixedSize(true)
    setAdapter(adapter)
}