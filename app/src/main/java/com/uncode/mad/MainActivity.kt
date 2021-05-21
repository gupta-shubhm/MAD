package com.uncode.mad

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.uncode.mad.databinding.ActivityMainBinding
import com.uncode.mad.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val binding get() = mainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.openDialogButton.setOnClickListener { showLogoutDialog() }
    }


    private fun showLogoutDialog() {
        var status = false
        val messageBoxView =
            LayoutInflater.from(this).inflate(R.layout.dialog_layout, null)
        val dialog = MaterialAlertDialogBuilder(this).setView(messageBoxView)
        val dialogLayoutBinding = DialogLayoutBinding.bind(messageBoxView)

        val alertDialog = dialog.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(false)
            show()
        }

        val checkBox: CheckBox = messageBoxView.findViewById(R.id.signout_pref)
        checkBox.setOnCheckedChangeListener { compoundButton, _ ->
            status = (compoundButton.isChecked)
            compoundButton.text =
                (if (compoundButton.isChecked) "You will be logged out completely." else "You won't be logged out completely.")
        }

        dialogLayoutBinding.cancelActionButton.setOnClickListener {
            alertDialog.dismiss()
        }

        dialogLayoutBinding.confirmActionButton.setOnClickListener {

//****EDIT YOUR RESPONSES HERE*****/////

/*            if (status) {
                val snackBar = Snackbar.make(
                    it,
                    "Bingo! You're successfully logged out and all preferences are erased",
                    Snackbar.LENGTH_LONG
                )
                snackBar.show()

            } else
            {
                val snackBar = Snackbar.make(
                    it,
                    "Bingo! You're successfully logged out and preferences are saved",
                    Snackbar.LENGTH_LONG
                )
                snackBar.show()
            }*/

            alertDialog.dismiss()
        }
    }
}