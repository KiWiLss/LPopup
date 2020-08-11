/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: SetDialogFg
 * Author:   Administrator
 * Date:     2020/8/11 16:52
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.dialog.ldialogfg

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.dialog.LDialogFg
import kotlinx.android.synthetic.main.pw_choice_head.*

/**
 *@FileName: SetDialogFg
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/11
 * @desc   : {DESCRIPTION}
 */
class SetDialogFg: LDialogFg() {
    override fun initInterface() {
        setGravity(Gravity.BOTTOM)//设置位置
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT)//设置宽度
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)//设置高度
        setmAnimationStyle(R.style.PushInBottom)//设置动画
//        setText()//设置文字
//        setImageRes()//设置图标
        //设置点击
//        setOnClick(R.id.tv_pw_choice_head_cancel,View.OnClickListener {
//            dismiss()
//        })
        //也可以这样设置
        tv_pw_choice_head_cancel.setOnClickListener {
            dismiss()
        }
        isCancelable = false//设置点击外部是否消失(设置为false后,点击外部和返回键均不会消失)
    }

    override fun initLayoutId(): Int = R.layout.pw_choice_head
}