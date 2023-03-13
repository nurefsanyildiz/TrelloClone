package com.example.projemanag.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.projemanag.R
import com.example.projemanag.firebase.FirestoreClass
import kotlinx.android.synthetic.main.activity_my_opening.*

class MyOpeningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_opening)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val typeface: Typeface = Typeface.createFromAsset(assets, "carbon bl.ttf")
        tv_app_name.typeface = typeface
        Handler().postDelayed({
            var currentUserID = FirestoreClass().getCurrentUserId()
            if (currentUserID.isNotEmpty()) {
                startActivity(Intent(this@MyOpeningActivity, MainActivity::class.java))
            }else{
                startActivity(Intent(this@MyOpeningActivity, IntroActivity::class.java))
            }
            finish()
        }, 2500)
    }
}