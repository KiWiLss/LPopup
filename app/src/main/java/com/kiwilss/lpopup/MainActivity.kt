package com.kiwilss.lpopup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiwilss.lpopup.common.CommonPopupActivity
import com.kiwilss.lpopup.dialog.DialogTestActivity
import com.kiwilss.lpopup.jtest.JavaTestActivity
import com.kiwilss.lpopup.popup.PopupActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_main_popup.setOnClickListener {
            startActivity(Intent(this,PopupActivity::class.java))
        }
        btn_main_popup2.setOnClickListener {
            startActivity(Intent(this,CommonPopupActivity::class.java))
        }
        btn_main_popup3.setOnClickListener {
            startActivity(Intent(this,JavaTestActivity::class.java))
        }
        btn_main_popup4.setOnClickListener {
            startActivity(Intent(this,DialogTestActivity::class.java))
        }
    }
}