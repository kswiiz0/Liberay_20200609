package com.phis.liberay_20200609

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()
    }

    override fun setValues() {

    }

    override fun setupEvents() {

        profileIV.setOnClickListener({
            val myIntent = Intent(mContext,LargePhotoActivity::class.java)
            startActivity(myIntent)

        })

    }

}
