package com.ericampire.mobile.alertsms.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.ericampire.mobile.alertsms.databinding.ItemContactBinding
import com.ericampire.mobile.alertsms.model.Contact

class ContactAdapter(val listener: Listener) :
    ListAdapter<Contact, ContactAdapter.ContactViewHolder>(Companion) {

    private val colorGenerator = ColorGenerator.MATERIAL

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater, parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = getItem(position)

        val drawable = getDrawableImage(currentContact)

        holder.binding.run {
            contact = currentContact
            imageView2.setImageDrawable(drawable)
            imageButton.setOnClickListener { listener.onContextClick(currentContact) }
            executePendingBindings()
        }
    }

    private fun getDrawableImage(currentContact: Contact): TextDrawable? {
        val text = currentContact.name.first().toString()
        return TextDrawable.builder()
            .beginConfig()
            .bold()
            .toUpperCase()
            .endConfig()
            .buildRound(text, colorGenerator.getColor(currentContact))
    }

    interface Listener {
        fun onContextClick(item: Contact)
    }

    class ContactViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return newItem.uid == oldItem.uid
        }
    }
}