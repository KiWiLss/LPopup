/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: DialogTest
 * Author:   Administrator
 * Date:     2020/8/11 14:18
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.dialog

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.dialog.ldialog.DefaultDialog
import com.kiwilss.lpopup.dialog.ldialog.OneDialog
import com.kiwilss.lpopup.dialog.ldialogfg.DefaultDialogFg
import com.kiwilss.lpopup.dialog.ldialogfg.SetDialogFg
import kotlinx.android.synthetic.main.activity_dialog_test.*

/**
 *@FileName: DialogTest
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/11
 * @desc   : {DESCRIPTION}
 */
class DialogTestActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_test)
        //LDialog使用示例
        btn_dialog_default.setOnClickListener {
            val dialog = DefaultDialog(this)
            dialog.show()
        }
        btn_dialog_set.setOnClickListener {
            OneDialog(this)
                .show()
        }
        //XDialog使用示例
        btn_dialog_default2.setOnClickListener {
            //什么都不设置,默认居中显示,无动画效果
            XDialog.Builder(this,R.layout.pw_center)
                .build()
                .show()
        }
        btn_dialog_set2.setOnClickListener {
            val dialog = XDialog.Builder(this,R.layout.pw_choice_head)
                .width(ViewGroup.LayoutParams.MATCH_PARENT)//设置宽度
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)//设置高度
                .animationStyle(R.style.PushInBottom)//设置动画
                .gravity(Gravity.BOTTOM)//设置位置
                .build()
            dialog.setText(R.id.tv_pw_choice_head_camera,"不想拍照")//设置文字
                //.setImageRes()//设置图标
                .setOnClick(R.id.tv_pw_choice_head_cancel,View.OnClickListener { //设置点击
                    dialog.dismiss()
                })
                .show()
            //可以通过getView获取控件
            //dialog.getView<TextView>(R.id.tv_pw_choice_head_cancel)//
        }
        //LDialogFg使用示例
        btn_dialog_lfg.setOnClickListener {
            DefaultDialogFg().show(supportFragmentManager,"")
        }
        btn_dialog_lfgset.setOnClickListener {
            SetDialogFg()
                .show(supportFragmentManager,"")
        }
    }
}