package com.ericampire.mobile.alertsms.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ericampire.mobile.alertsms.R
import com.ericampire.mobile.alertsms.databinding.FragmentEditContactBinding
import com.ericampire.mobile.alertsms.model.Contact
import com.ericampire.mobile.alertsms.viewmodel.ContactViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_edit_contact.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class EditContactFragment : BottomSheetDialogFragment(), View.OnClickListener {


    private val contactViewModel by viewModel<ContactViewModel>()
    private val actionArgs by lazy {
        EditContactFragmentArgs.fromBundle(arguments!!).action
    }

    private val contactArgs by lazy {
        EditContactFragmentArgs.fromBundle(arguments!!).contact
    }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, state: Bundle?): View? {
        val binding = FragmentEditContactBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        binding.button.text = actionArgs
        binding.button.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(view: View) {
        val name = edName.text.toString()
        val number = edNumero.text.toString()

        when {
            name.isBlank()   -> textInputLayoutName.error = getString(R.string.txt_invalid_name)
            number.isBlank() -> textInputLayoutNumber.error = getString(R.string.txt_invalid_number)
            !number.startsWith("+") -> edNumero.error = getString(R.string.txt_invalid_code)

            else -> {
                val contact = Contact(UUID.randomUUID().toString(), number, name)

                if (actionArgs == getString(R.string.txt_modifier)) {
                    contact.uid = contactArgs?.uid ?: return
                    contactViewModel.edit(contact)
                } else {
                    contactViewModel.add(contact)
                }

                dismiss()
            }
        }
    }
}
