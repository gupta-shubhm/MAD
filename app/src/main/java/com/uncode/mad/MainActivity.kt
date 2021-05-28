package com.uncode.mad

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uncode.mad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val binding get() = activityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val objects = MADMaterialAlertDialog(this)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.opendiag.setOnClickListener {
            objects.run {
                setPositiveButtonTextAndIcon("Confirm", R.drawable.healing)
                setNegativeButtonTextAndIcon("Negative", R.drawable.health)
                setNeutralButtonTextAndIcon("Neutral", R.drawable.healing)
                setNeutralButtonVisibility(false)
                setCheckBoxVisibility(false, "Checked", "Unchecked")
                setAnimationVisibilityAndAnimation(false, R.raw.logout)
                setTitleText("Logout")
                setSubtitleText("Are you sure you want to log out? We are going to miss your so, please log back in for rich content.")
                show(this@MainActivity)
                positiveButtonObject().setOnClickListener {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            SampleActivity::class.java
                        )
                    )
                }
                negativeButtonObject().setOnClickListener { showAlert("Negative Button") }
                neutralButtonObject().setOnClickListener { showAlert("Neutral Button") }
            }

        }
    }

}

private fun Context.showAlert(s: String) {
    Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
}


