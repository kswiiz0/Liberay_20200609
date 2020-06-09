package com.phis.liberay_20200609

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()
    }

    override fun setValues() {

        Glide.with(mContext)
            .load("http://img.insight.co.kr/static/2019/11/05/700/6dxow23eff21tzf0t6z3.jpg")
            .into(profileIV);


    }

    override fun setupEvents() {


        profileIV.setOnClickListener({

            val myIntent = Intent(mContext, LargePhotoActivity::class.java)
            startActivity(myIntent)

        })

        btnCall.setOnClickListener {
            val pl: PermissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                    Toast.makeText(this@MainActivity, "Permission Granted", Toast.LENGTH_SHORT).show()
                    val myUri = Uri.parse("tel:${txtPhoneNumber.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: List<String>) {
                    Toast.makeText(
                        this@MainActivity,
                        "Permission Denied\n$deniedPermissions",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            TedPermission.with(mContext).setPermissionListener(pl)
                .setDeniedMessage("권한을 거부하면 통화를 할수 없습니다. [설정] > [권한]에서 권한 설정을 해주세요.")
                .setPermissions(android.Manifest.permission.CALL_PHONE).check()


        }


    }

}
