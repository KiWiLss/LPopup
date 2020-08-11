/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: OneDialog
 * Author:   Administrator
 * Date:     2020/8/11 14:24
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.dialog.ldialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.dialog.LDialog

/**
 *@FileName: OneDialog
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/11
 * @desc   : {DESCRIPTION}
 */
class OneDialog(context: Context) : LDialog(context) {
    override fun initInterface(savedInstanceState: Bundle?) {
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT) //设置宽度
            .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT) //设置高度
            .setGravity(Gravity.BOTTOM) //设置显示位置
            //.setImageRes()//设置图标
            .setAnimationStyle(R.style.PushInBottom)//设置动画
            .setText(R.id.tv_pw_choice_head_camera, "测试LDialog") //设置控件文字
                .setOnClick(R.id.tv_pw_choice_head_cancel, View.OnClickListener { //设置点击
                    dismiss()
                })
        context
         val tvCancel = getView<TextView>(R.id.tv_pw_choice_head_cancel)// 获取控件

        //setCancelable(false)//单独设置 false ,dialog弹出后，点击屏幕或物理返回键，dialog不消失
        //setCanceledOnTouchOutside(false)// 单独设置 false ,dialog弹出后，点击屏幕dialog不消失,物理返回键消失


        setOnDismissListener { //对话框消失监听
            Log.e("MMM", ": onDismiss");
        }
    }

    override fun initContentView(): Int = R.layout.pw_choice_head
}