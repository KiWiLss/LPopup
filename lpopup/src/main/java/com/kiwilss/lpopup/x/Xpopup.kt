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
import android.content.Context
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ContentView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import com.kiwilss.lpopup.dialog.XDialog
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
class Xpopup private constructor(val builder: Builder): EasyPopup(builder.activity,builder.layoutId) {
    var isMask = true

    /**
     * 初始化时设置
     */
    override fun initInterface() {
        mContext = builder.activity
    }

    var isCancelable = true
     var alpha = 0.5f
    private var mContext: Context? = null

    override fun showBeforeOperator() {
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
    fun setTextColor(viewId: Int, color: Int): Xpopup {
        val tv = getView(viewId)
        if (tv != null && mContext != null) {
            if (tv is TextView){
                val color1 = ContextCompat.getColor(mContext!!, color)
                tv.setTextColor(color1)
            }
        }
        return this
    }

    fun setTextSize(viewId: Int, dimension: Int): Xpopup {
        val tv = getView(viewId)
        if (tv != null  && mContext != null) {
            val dimensionPixelSize: Int = mContext!!.resources.getDimensionPixelSize(dimension)
            if (tv is TextView){
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, dimensionPixelSize.toFloat())
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