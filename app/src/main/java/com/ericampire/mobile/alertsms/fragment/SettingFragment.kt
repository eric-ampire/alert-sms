package com.ericampire.mobile.alertsms.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment

import com.ericampire.mobile.alertsms.R
import com.ericampire.mobile.alertsms.adapter.ContactAdapter
import com.ericampire.mobile.alertsms.databinding.FragmentSettingBinding
import com.ericampire.mobile.alertsms.model.Contact
import com.ericampire.mobile.alertsms.viewmodel.ContactViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class SettingFragment : Fragment(), ContactAdapter.Listener {

    private val contactViewModel by viewModel<ContactViewModel>()
    private val navController by lazy { NavHostFragment.findNavController(this) }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, state: Bundle?): View? {
        val contactAdapter = ContactAdapter(this)
        val binding = FragmentSettingBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
            adapter = contactAdapter
        }

        contactViewModel.data.observe(this, Observer {
            it?.let(contactAdapter::submitList)
            Log.e("ericampire", it.toString())
        })

        binding.fabAddContact.setOnClickListener {
            val action = SettingFragmentDirections.actionEditFragment(null, getString(R.string.txt_add))
            navController.navigate(action)
        }

        return binding.root
    }

    override fun onContextClick(item: Contact, view: View) {
        val popupMenu = PopupMenu(requireContext(), view).apply {
            inflate(R.menu.contact_menu)
            setOnMenuItemClickListener {
                return@setOnMenuItemClickListener when (it.itemId) {
                    R.id.menu_item_delete -> {
                        contactViewModel.delete(item)
                        true
                    }

                    R.id.menu_item_edit -> {
                        showEditContactDialog(item)
                        true
                    }
                    else -> false
                }
            }
        }

        popupMenu.show()
    }

    private fun showEditContactDialog(contact: Contact) {
        val action = SettingFragmentDirections.actionEditFragment(contact, getString(R.string.txt_modifier))
        navController.navigate(action)
    }
}
