package com.goyals.smartdubai.view.utils

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ErrorDialog : DialogFragment() {
  companion object {
    fun newInstance(errorMessage: String) = ErrorDialog().apply {
      arguments = Bundle().apply {
        putString("message", errorMessage)
      }
    }
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    return activity?.let {
      val builder = AlertDialog.Builder(it)
      builder.setMessage(arguments?.getString("message", ""))
        .setPositiveButton("Ok") { _, _ ->
          dismiss()
        }
      builder.create()
    } ?: throw IllegalStateException("Activity cannot be null")
  }
}
