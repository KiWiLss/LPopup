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
     //var gravity = Gravity.CENTER
//     var popupWidth = ViewGroup.LayoutParams.MATCH_PARENT
//     var popupHeight = ViewGroup.LayoutParams.WRAP_CONTENT
//     var horizontalGravity = HorizontalPosition.CENTER
//     var verticalGravity = VerticalPosition.CENTER
    override fun setInterface() {
        //设置初始参数
        setIsMask(isMask)
        setIsTouchOutsideDimiss(isCancelable)
        setBackgroundAlpha(alpha)
    }
    fun setText(viewId: Int, text: String) : Xpopup{
        contentView?.findViewById<TextView>(viewId)?.run {
            this.text = text ?: ""
        }
        return this
    }
    fun setOnClick(viewId: Int,listener: View.OnClickListener): Xpopup{
        contentView?.findViewById<View>(viewId)?.setOnClickListener(listener)
        return this
    }
    fun setImageResource(viewId: Int, resourceId: Int): Xpopup{
        contentView?.findViewById<ImageView>(viewId)?.setImageResource(resourceId)
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
//        fun gravity(gravity: Int): Builder{
//            xpopup.gravity = gravity
//            return this
//        }
//        fun popupWidth(popupWidth: Int): Builder{
//            xpopup.popupWidth = popupWidth
//            return this
//        }
//        fun popupHeight(popupHeight: Int): Builder{
//            xpopup.popupHeight = popupHeight
//            return this
//        }
//        fun horizontalGravity(horizontalGravity: Int): Builder{
//            xpopup.horizontalGravity = horizontalGravity
//            return this
//        }
//        fun verticalGravity(verticalGravity: Int): Builder{
//            xpopup.verticalGravity = verticalGravity
//            return this
//        }
        fun build() = xpopup
    }
}