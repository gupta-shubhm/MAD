package com.uncode.mad

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.button.MaterialButton
import com.uncode.mad.databinding.MadMaterialalertdialogBinding

class MADMaterialAlertDialog(context: Context) {
    val viewContext = context
    internal val messageBoxView: View =
        LayoutInflater.from(context).inflate(R.layout.mad_materialalertdialog, null)
    val binding = MadMaterialalertdialogBinding.bind(messageBoxView)
    val status = false

//        return mutableListOf(
//            binding.madConfirmActionButton,
//            binding.madCancelActionButton,
//            binding.madNeutralActionButton
//        )

}

fun MADMaterialAlertDialog.setTitleText(text: String) {
    binding.madTitle.text = text
}

fun MADMaterialAlertDialog.setSubtitleText(text: String) {
    binding.madSubtitle.text = text
}

fun MADMaterialAlertDialog.setPositiveButtonTextAndIcon(text: String, icon: Int? = null) {
    binding.madConfirmActionButton.text = text
    if (icon != null) {
        val showIcon = AppCompatResources.getDrawable(viewContext, icon)
        binding.madConfirmActionButton.icon = showIcon
    }
}

fun MADMaterialAlertDialog.setNegativeButtonTextAndIcon(text: String, icon: Int?) {
    binding.madCancelActionButton.text = text
    if (icon != null) {
        val showIcon = AppCompatResources.getDrawable(viewContext, icon)
        binding.madCancelActionButton.icon = showIcon
    }
}

fun MADMaterialAlertDialog.setNeutralButtonTextAndIcon(text: String, icon: Int?) {
    binding.madNeutralActionButton.text = text
    if (icon != null) {
        val showIcon = AppCompatResources.getDrawable(viewContext, icon)
        binding.madNeutralActionButton.icon = showIcon
    }
}

fun MADMaterialAlertDialog.setNeutralButtonVisibility(flag: Boolean) {
    binding.madNeutralActionButton.visibility = if (flag) View.VISIBLE else View.GONE
}

fun MADMaterialAlertDialog.setCheckBoxVisibility(
    flag: Boolean,
    checkboxMsgChecked: String?,
    checkboxMsgUnChecked: String?
) {
    val checkBox: CheckBox = messageBoxView.findViewById(R.id.mad_checkbox)
    if (!flag && binding.madAnimation.visibility == View.INVISIBLE)
        binding.animationLayout.visibility = View.GONE
    else {
        binding.animationLayout.visibility = View.VISIBLE

        binding.madCheckbox.visibility = if (flag) {
            if (!status)
                checkBox.text =
                    if (checkboxMsgUnChecked.isNullOrBlank()) "" else checkboxMsgUnChecked
            checkBox.setOnCheckedChangeListener { compoundButton, _ ->
                (if (compoundButton.isChecked) if (checkboxMsgChecked.isNullOrBlank()) "" else checkboxMsgChecked else if (checkboxMsgUnChecked.isNullOrBlank()) "" else checkboxMsgUnChecked).also {
                    compoundButton.text = it
                }
            }
            View.VISIBLE
        } else View.INVISIBLE
    }
}

fun MADMaterialAlertDialog.setAnimationVisibilityAndAnimation(flag: Boolean, anim: Int?) {
    if (!flag && binding.madCheckbox.visibility == View.INVISIBLE)
        binding.animationLayout.visibility = View.GONE
    else {
        binding.animationLayout.visibility = View.VISIBLE
        binding.madAnimation.visibility = if (flag) {
            binding.madAnimation.apply {
                anim?.let { setAnimation(it) }
                loop(true)
                playAnimation()
            }
            View.VISIBLE
        } else View.INVISIBLE
    }
}

fun MADMaterialAlertDialog.show(context: Context) {
    val dialog: AlertDialog.Builder = AlertDialog.Builder(context).setView(messageBoxView)
    dialog.create().apply {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
        show()
    }
}

fun MADMaterialAlertDialog.checkBoxObject():CheckBox {
    return binding.madCheckbox
}

fun MADMaterialAlertDialog.positiveButtonObject(): MaterialButton {
    return binding.madConfirmActionButton
}

fun MADMaterialAlertDialog.negativeButtonObject(): MaterialButton {
    return binding.madCancelActionButton
}

fun MADMaterialAlertDialog.neutralButtonObject(): MaterialButton {
    return binding.madNeutralActionButton
}
















