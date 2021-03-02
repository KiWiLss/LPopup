/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: PopupActivity
 * Author:   kiwilss
 * Date:     2020/8/5 21:09
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.popup

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.Utils
import com.kiwilss.lpopup.common.pp.ListPopupDemo
import com.kiwilss.lpopup.x.normal.Xttpopup
import kotlinx.android.synthetic.main.activity_popup.*
import kotlinx.android.synthetic.main.pw_center.view.*

/**
 *@FileName: PopupActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {DESCRIPTION}
 */
class PopupActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        btn_popup_center.setOnClickListener {
            showSimplePw(Gravity.CENTER)
        }
        btn_popup_bottom.setOnClickListener {
            showSimplePw(Gravity.BOTTOM)
        }
        btn_popup_top.setOnClickListener {
            showSimplePw(Gravity.TOP)
        }
        btn_popup_shaw.setOnClickListener {
            showShawSimplePw()
        }
        btn_popup_menu.setOnClickListener {
            showMenu()
        }
        btn_popup_menu2.setOnClickListener {
            val contentView = layoutInflater.inflate(R.layout.pw_menu2, null)
            val popup = PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true)
            //对整个 popupwindow 设置背景
            popup.showAsDropDown(btn_popup_menu2)
        }
        //设置阴影效果对比
        btn_popup_shwa1.setOnClickListener {
            Loopopup.Builder(this)
                .build()
                .showCenter()
        }
        btn_popup_shwa2.setOnClickListener {
           Xttpopup.Builder(this)
               .build()
               .showCenter()
        }
        btn_popup_shwa3.setOnClickListener {
            showDimPw()
        }
        btnPopupTest.setOnClickListener {
            ListPopupDemo(this)
                .setTest()
                .showCenter()
        }
    }

    private fun showDimPw() {
        val contentView = layoutInflater.inflate(R.layout.pw_center, null)
        val popup = PopupWindow(contentView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT, true)
        popup.showAtLocation(this.window.decorView,Gravity.CENTER,0,0)
        popup.animationStyle = R.style.AnimFadeCenter
        //设置阴影效果,必须要在 show 以后才有效果
        Utils.setScreenAlpha(this,popup,0.5f)
    }

    private fun showMenu() {
        val contentView = layoutInflater.inflate(R.layout.pw_menu, null)
        val popup = PopupWindow(contentView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT, true)
        //对整个 popupwindow 设置背景
        popup.showAsDropDown(btn_popup_menu)
    }

    private fun showShawSimplePw() {
        //设置阴影
        Utils.setScreenAlpha(this,0.5f)
        val contentView = layoutInflater.inflate(R.layout.pw_center, null)
        val popup = PopupWindow()
        popup.contentView = contentView
        popup.width = ViewGroup.LayoutParams.MATCH_PARENT
        popup.height =  ViewGroup.LayoutParams.WRAP_CONTENT
        //设置点击空白区域消失的方法
        popup. isOutsideTouchable = true
        popup.isFocusable = true
        popup.setBackgroundDrawable(ColorDrawable())

        popup.showAtLocation(this.window.decorView,Gravity.CENTER,0,0)

        contentView.tv_pw_onetitle_cancel.setOnClickListener {
            popup.dismiss()
        }
        popup.setOnDismissListener {
            //去掉阴影
            Utils.setScreenAlpha(this,1f)
        }
    }

    private fun showSimplePw(center: Int) {
        //默认整个对话框窗体没有阴影
        //这种初始化的方法,默认点击外部区域对话框可以消失(有的手机上无效)
        val contentView = layoutInflater.inflate(R.layout.pw_center, null)
        val popup = PopupWindow(contentView,ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT)
        popup.showAtLocation(this.window.decorView,center,0,0)
        contentView.tv_pw_onetitle_cancel.setOnClickListener {
            popup.dismiss()
        }
    }
}