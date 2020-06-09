package com.phis.liberay_20200609

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    val mContext = this

    abstract fun setValues()
    abstract fun setupEvents()

}