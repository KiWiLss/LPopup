/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: EasyPopup
 * Author:   Administrator
 * Date:     2020/8/7 16:40
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.easy


import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.util.SparseArray
import android.view.*
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.PopupWindow
import androidx.annotation.IdRes
import androidx.core.util.isEmpty
import androidx.core.util.isNotEmpty
import androidx.core.widget.PopupWindowCompat
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.utils.ScreenUtils
import java.lang.ref.WeakReference
import java.util.*


/**
 *@FileName: EasyPopup
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/7
 * @desc   : {专门针对对话框}
 */
abstract class EasyPopup(private val activity: Activity, layout: Int) : PopupWindow(activity) {

    //宽高
    private var mWidth2 =0
    private var mHeight2 = 0
    private var mWidth = ViewGroup.LayoutParams.MATCH_PARENT
    private var mHeight = ViewGroup.LayoutParams.WRAP_CONTENT
    private var mAlpha = 0.5f //背景灰度  0-1  1表示全透明
    private var isMask = true//是否显示阴影,默认显示
    private var isAddGlable = false
    private var isTouchOutsideDismiss = true //点击外部消失,默认消失
    private var mAnimationStyle = -1//设置动画,默认没有动画

    private var isOnlyGetWH = true
    private var mAnchorView: View? = null

    @VerticalPosition
    private var mVerticalGravity = VerticalPosition.BELOW

    @HorizontalPosition
    private var mHorizontalGravity = HorizontalPosition.LEFT
    private var mOffsetX = 0
    private var mOffsetY = 0
    lateinit var mViews: SparseArray<WeakReference<View>?>

    init {
        mViews = SparseArray()
        initType()
        contentView = activity.layoutInflater.inflate(layout, null)
        height = mHeight
        width = mWidth
        touchOutsideDismiss()
        initInterface()
    }

    /**
     * 初始化时设置,会在各种设置方法前调用
    */
    abstract fun initInterface()

    @SuppressLint("ClickableViewAccessibility")
    private fun touchOutsideDismiss() {
        setIsTouchOutsideDimiss(true)
    }

    fun setPopupWidth(width: Int): EasyPopup{
        this.mWidth2 = width
        return this
    }
    fun setPopupHeight(height: Int): EasyPopup{
        this.mHeight2 = height
        return this
    }
    /**设置是否精准测量
     */
    fun isAddGlable(isGable: Boolean) : EasyPopup{
        this.isAddGlable = isGable
        return this
    }

    /**
     * 设置是否显示阴影
     */
    fun setIsMask(isMask: Boolean): EasyPopup {
        this.isMask = isMask
        return this
    }
    /**
     * 设置动画效果
    */
    fun setAnimStyle(animStyle: Int): EasyPopup{
        mAnimationStyle = animStyle
        return this
    }

    fun setBackgroundAlpha(alpha: Float): EasyPopup{
        this.mAlpha = alpha
        return this
    }
    /**
     * 设置点击外部是否消失
     */
    @SuppressLint("ClickableViewAccessibility")
    fun setIsTouchOutsideDimiss(isTouchOutsideDimiss: Boolean) : EasyPopup{
        if (!isTouchOutsideDimiss) {
            isFocusable = false
            isOutsideTouchable = false
            isTouchable = true
            //setBackgroundDrawable(ColorDrawable())
            contentView.isFocusable = true
            contentView.isFocusableInTouchMode = true
            contentView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dismiss()
                    return@OnKeyListener true
                }
                false
            })
            //在Android 6.0以上 ，只能通过拦截事件来解决
//            setTouchInterceptor(OnTouchListener { v, event ->
//                val x = event.x.toInt()
//                val y = event.y.toInt()
//                if (event.action == MotionEvent.ACTION_DOWN
//                    && (x < 0 || x >= mWidth || y < 0 || y >= mHeight)
//                ) {
//                    //outside
//                    return@OnTouchListener true
//                } else if (event.action == MotionEvent.ACTION_OUTSIDE) {
//                    //outside
//                    return@OnTouchListener true
//                }
//                false
//            })
        } else {
            isFocusable = true
            isOutsideTouchable = true
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        return this
    }

    private fun removeGlobalLayoutListener() {
        if (contentView != null) {
            contentView.viewTreeObserver
                .removeOnGlobalLayoutListener(mOnGlobalLayoutListener)
        }
    }

    private fun addGlobalLayoutListener(contentView: View) {
        contentView.viewTreeObserver.addOnGlobalLayoutListener(mOnGlobalLayoutListener)
    }

    //监听器，用于PopupWindow弹出时获取准确的宽高
    private val mOnGlobalLayoutListener = OnGlobalLayoutListener {
        mWidth = contentView.width
        mHeight = contentView.height
        //只获取宽高时，不执行更新操作
        if (isOnlyGetWH) {
            removeGlobalLayoutListener()
            return@OnGlobalLayoutListener
        }
        updateLocation(
            mWidth,
            mHeight,
            mAnchorView!!,
            mVerticalGravity,
            mHorizontalGravity,
            mOffsetX,
            mOffsetY
        )
        removeGlobalLayoutListener()
    }

    private fun updateLocation(
        width: Int, height: Int, anchor: View,
        @VerticalPosition verticalGravity: Int,
        @HorizontalPosition horizontalGravity: Int,
        x: Int, y: Int
    ) {
        var x = x
        var y = y
        x = calculateX(anchor, horizontalGravity, width, x)
        y = calculateY(anchor, verticalGravity, height, y)
        update(anchor, x, y, width, height)
    }

    /**
     * 根据垂直gravity计算y偏移
     */
    private fun calculateY(
        anchor: View,
        verticalGravity: Int,
        measuredH: Int,
        y: Int
    ): Int {
        var y = y
        when (verticalGravity) {
            VerticalPosition.ABOVE -> y -= measuredH + anchor.height
            VerticalPosition.ALIGN_BOTTOM -> y -= measuredH
            VerticalPosition.CENTER -> y -= anchor.height / 2 + measuredH / 2
            VerticalPosition.ALIGN_TOP -> y -= anchor.height
            VerticalPosition.BELOW -> {
            }
        }
        return y
    }

    /**
     * 根据水平gravity计算x偏移
     */
    private fun calculateX(
        anchor: View,
        horizontalGravity: Int,
        measuredW: Int,
        x: Int
    ): Int {
        var x = x
        when (horizontalGravity) {
            HorizontalPosition.LEFT -> x -= measuredW
            HorizontalPosition.ALIGN_RIGHT -> x -= measuredW - anchor.width
            HorizontalPosition.CENTER -> x += anchor.width / 2 - measuredW / 2
            HorizontalPosition.ALIGN_LEFT -> {
            }
            HorizontalPosition.RIGHT -> x += anchor.width
        }
        return x
    }
    /**
     * 默认渐变动画,默认中间弹出
    */
    fun show(gravity: Int = Gravity.CENTER,animStyle: Int = R.style.AnimFadeCenter){
        animationStyle = animStyle
        showAtLocation(activity.window.decorView, gravity, 0, 0)
    }

    fun showCenter() {
        //设置渐入渐出动画
        animationStyle = R.style.AnimFadeCenter
        showAtLocation(activity.window.decorView, Gravity.CENTER, 0, 0)
    }

    fun showBottom() {
        //设置底部弹出动画
        animationStyle = R.style.PushInBottom
        showAtLocation(activity.window.decorView, Gravity.BOTTOM, 0, 0)
    }

    fun showTop() {
        animationStyle = R.style.PushInTop
        showAtLocation(activity.window.decorView, Gravity.TOP, 0, 0)
    }

    override fun showAtLocation(parent: View, gravity: Int, x: Int, y: Int) {
        isOnlyGetWH = true
        mAnchorView = parent
        mOffsetX = x
        mOffsetY = y
        showBeforeSet()
        super.showAtLocation(parent, gravity, x, y)
        showAfterSet()
    }

    private fun showAfterSet() {
        if (isMask) {
            showBackgroundAnimator2()
        }
    }


    /**展示之前的设置
     */
    private fun showBeforeSet() {
        showBeforeOperator()
        if (mAnimationStyle != -1){
            animationStyle = mAnimationStyle
        }
//        if (isMask) {
//            showBackgroundAnimator()
//        }
        if (mWidth2 != 0){
            width = mWidth2
        }
        if (mHeight2 != 0){
            height = mHeight2
        }
        if (isAddGlable) {
            addGlobalLayoutListener(contentView)
        }
        //setInterface()
    }

    private fun showBackgroundAnimator2() {
        ScreenUtils.setScreenAlpha(activity,this,mAlpha)
    }

    /**
     * 设置在某个控件下面方法
     */
    fun showMenu(anchor: View) {
        showAsDropDown(anchor, 0, 0, Gravity.NO_GRAVITY)
    }

    fun showMenu(anchor: View, xoff: Int, yoff: Int) {
        showAsDropDown(anchor, xoff, yoff, Gravity.NO_GRAVITY)
    }

    fun showMenu(anchor: View, xoff: Int, yoff: Int, gravity: Int) {
        showAsDropDown(anchor, xoff, yoff, gravity)
    }

    override fun showAsDropDown(
        anchor: View,
        xoff: Int,
        yoff: Int,
        gravity: Int
    ) {
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        showBeforeSet()
        super.showAsDropDown(anchor, xoff, yoff, gravity)
        showAfterSet()
    }

    /**设置在某个view固定位置上的方法
     */
    open fun showAtAnchorView(
        anchorView: View,
        @VerticalPosition verticalPos: Int,
        @HorizontalPosition horizontalPos: Int
    ) {
        showAtAnchorView(anchorView, verticalPos, horizontalPos, true)
    }

    open fun showAtAnchorView(
        anchorView: View,
        @VerticalPosition verticalPos: Int,
        @HorizontalPosition horizontalPos: Int,
        fitInScreen: Boolean
    ) {
        showAtAnchorView(anchorView, verticalPos, horizontalPos, 0, 0, fitInScreen)
    }

    open fun showAtAnchorView(
        anchorView: View,
        @VerticalPosition verticalPos: Int,
        @HorizontalPosition horizontalPos: Int,
        x: Int,
        y: Int
    ) {
        showAtAnchorView(anchorView, verticalPos, horizontalPos, x, y, true)
    }

    open fun showAtAnchorView(
        anchorView: View,
        @VerticalPosition verticalPos: Int,
        @HorizontalPosition horizontalPos: Int,
        x: Int,
        y: Int,
        fitInScreen: Boolean
    ) {
        var x = x
        var y = y
        isAddGlable = true//需要精确测量,否则对话框显示位置不准
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        mWidth = width
        isOnlyGetWH = false
        mAnchorView = anchorView
        mOffsetX = x
        mOffsetY = y
        mVerticalGravity = verticalPos
        mHorizontalGravity = horizontalPos
        //showBackgroundAnimator()
        val contentView = contentView
        //addGlobalLayoutListener(contentView)
        isClippingEnabled = fitInScreen
        contentView.measure(
            makeDropDownMeasureSpec(width),
            makeDropDownMeasureSpec(height)
        )
        val measuredW = contentView.measuredWidth
        val measuredH = contentView.measuredHeight
        if (!fitInScreen) {
            val anchorLocation = IntArray(2)
            anchorView.getLocationInWindow(anchorLocation)
            x += anchorLocation[0]
            y += anchorLocation[1] + anchorView.height
        }
        y = calculateY(anchorView, verticalPos, measuredH, y)
        x = calculateX(anchorView, horizontalPos, measuredW, x)
        showBeforeSet()
        addGlobalLayoutListener(contentView)
        if (fitInScreen) {
            PopupWindowCompat.showAsDropDown(this, anchorView, x, y, Gravity.NO_GRAVITY)
        } else {
            showAtLocation(anchorView, Gravity.NO_GRAVITY, x, y)
        }
    }

    /**
     * 显示之前对界面处理和设置,会在各种设置方法后调用
    */
    abstract fun showBeforeOperator()


    override fun dismiss() {
        super.dismiss()
//        if (isMask) {
//            //dismissBackgroundAnimator()
//        }
        if (isAddGlable) {
            removeGlobalLayoutListener()
        }
    }

    private fun makeDropDownMeasureSpec(measureSpec: Int): Int {
        return View.MeasureSpec.makeMeasureSpec(
            View.MeasureSpec.getSize(
                measureSpec
            ), getDropDownMeasureSpecMode(measureSpec)
        )
    }

    private fun getDropDownMeasureSpecMode(measureSpec: Int): Int {
        return when (measureSpec) {
            ViewGroup.LayoutParams.WRAP_CONTENT -> View.MeasureSpec.UNSPECIFIED
            else -> View.MeasureSpec.EXACTLY
        }
    }

    @TargetApi(23)
    private fun initType() {
        //  解决华为手机在home建进入后台后，在进入应用，蒙层出现在popupWindow上层的bug。
        //  android4.0及以上版本都有这个hide方法，根据jvm原理，可以直接调用，选择android6.0版本进行编译即可。
        windowLayoutType = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL
    }

    //对外提供获取内部控件的方法
    fun getView2(@IdRes viewId: Int): View? = contentView?.findViewById(viewId)

    fun <T: View>getViewAny(@IdRes idRes: Int): T? {
        //防止多次findViewById
        val viewWeakReference: WeakReference<View>? = mViews.get(idRes)
        var view: View? = null
        view = viewWeakReference?.get()
        if (view == null){
            view = contentView.findViewById(idRes)
        }else{
            mViews.put(idRes, WeakReference(view))
        }
        return view as T?
    }


    fun getView(@IdRes idRes: Int): View? {
        //防止多次findViewById
        val viewWeakReference: WeakReference<View>? = mViews.get(idRes)
        var view: View? = null
         view = viewWeakReference?.get()
        if (view == null){
            view = contentView.findViewById(idRes)
        }else{
            mViews.put(idRes, WeakReference(view))
        }
        return view
    }


    /**
     * 窗口显示，窗口背景透明度渐变动画
     */
    private fun showBackgroundAnimator() {
        val animator = ValueAnimator.ofFloat(1.0f, mAlpha)
        animator.addUpdateListener { animation ->
            val alpha = animation.animatedValue as Float
            setWindowBackgroundAlpha(alpha)
        }
        animator.duration = 360
        animator.start()
    }

    /**
     * 窗口隐藏，窗口背景透明度渐变动画
     */
    private fun dismissBackgroundAnimator() {
        val animator = ValueAnimator.ofFloat(mAlpha, 1.0f)
        animator.addUpdateListener { animation ->
            val alpha = animation.animatedValue as Float
            setWindowBackgroundAlpha(alpha)
        }
        animator.duration = 360
        animator.start()
    }

    /**
     * 控制窗口背景的不透明度
     */
    private fun setWindowBackgroundAlpha(alpha: Float) {
        val window = activity.window
        val layoutParams = window.attributes
        layoutParams.alpha = alpha
        //layoutParams.windowAnimations = R.style.AnimFadeCenter
        window.attributes = layoutParams
    }
}