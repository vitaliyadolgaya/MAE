package com.example.cab.activities.map

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

interface OnPositiveButtonCallBack{
    fun onPositiveButton()
}

class EnableLocationDialog(private val listener: OnPositiveButtonCallBack) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = MaterialAlertDialogBuilder(it)
            builder.setMessage("Turn on the GPS to work correctly")
                .setPositiveButton("enable") { dialog, id ->
                    dialog.dismiss()
                    listener.onPositiveButton()

                }
                .setNegativeButton("cancel") { dialog, id ->
                    dialog.dismiss()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}