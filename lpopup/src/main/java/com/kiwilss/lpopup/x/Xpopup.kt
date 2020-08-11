/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Xpopup
 * Author:   Administrator
 * Date:     2020/8/11 9:03
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.x

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ContentView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.kiwilss.lpopup.easy.EasyPopup
import com.kiwilss.lpopup.easy.HorizontalPosition
import com.kiwilss.lpopup.easy.VerticalPosition

/**
 *@FileName: Xpopup
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/11
 * @desc   : {DESCRIPTION}
 */
class Xpopup private constructor(builder: Builder): EasyPopup(builder.activity,builder.layoutId) {
    var isMask = true
    var isCancelable = true
     var alpha = 0.5f
    override fun setInterface() {
        //设置初始参数
        setIsMask(isMask)
        setIsTouchOutsideDimiss(isCancelable)
        setBackgroundAlpha(alpha)
    }
    fun setText(@IdRes viewId: Int, text: String) : Xpopup{
        val view = getView(viewId)
        if (view != null){
            if (view is TextView) {
                view.text = text
            }
        }
        return this
    }
    fun setOnClick(@IdRes viewId: Int,listener: View.OnClickListener): Xpopup{
        getView(viewId)?.setOnClickListener(listener)
        return this
    }
    fun setImageResource(@IdRes viewId: Int, @DrawableRes resourceId: Int): Xpopup{
        val view = getView(viewId)
        if (view is ImageView){
            view.setImageResource(resourceId)
        }
        return this
    }
    class Builder(val activity: Activity,val layoutId: Int){
        private val xpopup = Xpopup(this)
        fun isMask(isMask: Boolean): Builder{
            xpopup.isMask = isMask
            return this
        }
        fun isCancelable(isCancelable: Boolean): Builder{
            xpopup.isCancelable = isCancelable
            return this
        }
        fun alpha(alpha: Float): Builder{
            xpopup.alpha = alpha
            return this
        }
        fun build() = xpopup
    }
}