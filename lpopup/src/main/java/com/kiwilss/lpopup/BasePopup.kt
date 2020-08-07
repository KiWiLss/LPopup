/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: BasePopup
 * Author:   Administrator
 * Date:     2020/8/5 17:33
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup

import android.R
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.graphics.PixelFormat
import android.graphics.drawable.ColorDrawable
import android.os.IBinder
import android.view.*
import android.widget.PopupWindow

/**
 *@FileName: BasePopup
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {集成对话框,阴影效果在部分手机上无法覆盖状态栏,当菜单类型使用位置不好控制}
 */
abstract class BasePopup(private val activity: Activity, layout: Int) : PopupWindow(activity) {

    private var isMask = true //背景是否有阴影
    private var wm: WindowManager? = null
    private var maskView: View? = null

    init {
        initType()
        activity.run {
            wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
            contentView = layoutInflater.inflate(layout,null)
//            //设置内容
//            setContent(contentView)
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            //默认设置点击外部区域消失
            setIsClickDismiss(true)
        }
    }
    //对外提供获取内部控件的方法
    fun getView(viewId: Int): View? = contentView?.findViewById(viewId)

    //abstract fun setContent(contentView: View)

    fun setIsMask(isMask: Boolean) : BasePopup{
        this.isMask = isMask
        return this
    }

    fun setPopupWidth(width: Int) : BasePopup{
        setWidth(width)
        return this
    }

    fun setPopupHeight(height: Int) : BasePopup{
        setHeight(height)
        return this
    }
    /**
     * 设置是否点击外部区域消失
     *
     * @param isDismiss
     */
    fun setIsClickDismiss(isDismiss: Boolean): BasePopup {
        if (isDismiss) {
            isOutsideTouchable = true
            isFocusable = true
            setBackgroundDrawable(ColorDrawable())
        } else {
            isOutsideTouchable = false
            isFocusable = false
            isTouchable = true
        }
        return this
    }

    /**
     * 作为对话框显示
     * 显示在界面的底部
     */
    fun showBottom() {
        showAtLocation(
            activity.window.decorView,
            Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL,
            0,
            0
        )
    }

    fun showBottom(activity: Activity?) {
        if (activity != null) {
            showAtLocation(
                activity.window.decorView,
                Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL,
                0,
                0
            )
        }
    }

    fun showCenter() {
        showAtLocation(
            activity.window.decorView,
            Gravity.CENTER or Gravity.CENTER_HORIZONTAL,
            0,
            0
        )
    }

    fun showCenter(activity: Activity?) {
        if (activity != null) {
            showAtLocation(
                activity.window.decorView,
                Gravity.CENTER or Gravity.CENTER_HORIZONTAL,
                0,
                0
            )
        }
    }

    fun showTop() {
        showAtLocation(
            activity.window.decorView,
            Gravity.TOP or Gravity.CENTER_HORIZONTAL,
            0,
            0
        )
    }

    fun showTop(activity: Activity?) {
        if (activity != null) {
            showAtLocation(
                activity.window.decorView,
                Gravity.TOP or Gravity.CENTER_HORIZONTAL,
                0,
                0
            )
        }
    }

    override fun showAtLocation(
        parent: View,
        gravity: Int,
        x: Int,
        y: Int
    ) {
        if (isMask) {
            addMaskView(parent.windowToken)
        }
        setInterface()
        super.showAtLocation(parent, gravity, x, y)
    }

    abstract fun setInterface()

    override fun showAsDropDown(
        anchor: View,
        xoff: Int,
        yoff: Int
    ) {
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        if (isMask) {
            addMaskView(anchor.windowToken)
        }
        setInterface()
        super.showAsDropDown(anchor, xoff, yoff)
    }

    override fun showAsDropDown(anchor: View) {
        showAsDropDown(anchor, 0, 0)
    }

    override fun dismiss() {
        if (isMask) {
            removeMaskView()
        }
        super.dismiss()
    }

    private fun setScreenMaskView(alpha: Float) {
        val attributes = activity.window.attributes
        attributes.alpha = alpha
        activity.window.attributes = attributes
    }

    @TargetApi(23)
    private fun initType() {
        //  解决华为手机在home建进入后台后，在进入应用，蒙层出现在popupWindow上层的bug。
        //  android4.0及以上版本都有这个hide方法，根据jvm原理，可以直接调用，选择android6.0版本进行编译即可。
        windowLayoutType = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL
    }

    private  fun addMaskView(token: IBinder) {
        val p = WindowManager.LayoutParams()
        p.width = WindowManager.LayoutParams.MATCH_PARENT
        p.height = WindowManager.LayoutParams.MATCH_PARENT
        p.format = PixelFormat.TRANSLUCENT
        p.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL
        p.token = token
        p.windowAnimations = R.style.Animation_Toast
        maskView = View(activity)
        maskView!!.setBackgroundColor(0x7f000000)
        //  maskView.setFitsSystemWindows(false);
        // 华为手机在home建进入后台后，在进入应用，蒙层出现在popupWindow上层，导致界面卡死，
        // 这里新增加按bug返回。
        // initType方法已经解决该问题，但是还是留着这个按back返回功能，防止其他手机出现华为手机类似问题。
        maskView!!.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                removeMaskView()
                return@OnKeyListener true
            }
            false
        })
        wm?.addView(maskView, p)
    }

    private  fun removeMaskView() {
        if (maskView != null) {
            wm?.removeViewImmediate(maskView)
            maskView = null
        }
    }
}