package com.kiwilss.lpopup.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.util.SparseArray
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

/**
 * @author : Lss Administrator
 * @FileName: LDialog
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {需要继承去使用的Dialog简单封装}
 */
abstract class LDialog(
    context: Context,
    themeResId: Int = 0
) : Dialog(context, themeResId) {

    private val views: SparseArray<View?> = SparseArray()

    private var mWidth = ViewGroup.LayoutParams.MATCH_PARENT
    private var mHeight = ViewGroup.LayoutParams.WRAP_CONTENT
    private var mGravity = Gravity.CENTER
    private var mAnimationStyle = 0 //默认没有动画效果
    fun setWidth(width: Int): LDialog {
        mWidth = width
        return this
    }

    fun setHeight(height: Int): LDialog {
        mHeight = height
        return this
    }

    fun setGravity(gravity: Int): LDialog {
        mGravity = gravity
        return this
    }

    fun setAnimationStyle(animationStyle: Int): LDialog {
        mAnimationStyle = animationStyle
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置布局
        setContentView(initContentView())
        initInterface(savedInstanceState)
        //设置宽高
        window?.run {
            if (mAnimationStyle != 0) {
               setWindowAnimations(mAnimationStyle)
            }
            setBackgroundDrawable(ColorDrawable(Color.parseColor("#00000000")))
            val lp = attributes
            lp.width = mWidth
            lp.height = mHeight
            lp.gravity = mGravity
            attributes = lp
        }
    }

    /**
     * 初始设置界面
     *
     * @param savedInstanceState
     */
    protected abstract fun initInterface(savedInstanceState: Bundle?)

    /**
     * 获取布局
     */
    protected abstract fun initContentView(): Int

    fun setText(viewId: Int, text: String?): LDialog {
        val tv = getView<TextView>(viewId)
        tv?.let {
            text?.run {
                it.text = this
            }
        }
        return this
    }

    fun setOnClick(viewId: Int, listener: View.OnClickListener?): LDialog {
        val view = getView<View>(viewId)
        view?.setOnClickListener(listener)
        return this
    }

    fun setImageRes(@IdRes viewId: Int, @DrawableRes res: Int): LDialog {
        val view = getView<ImageView>(viewId)
        view?.setImageResource(res)
        return this
    }

    fun <T : View?> getView(@IdRes viewId: Int): T? {
        var view = views[viewId]
        if (view == null) {
            view = findViewById(viewId)
            views.put(viewId, view)
        }
        return view as T?
    }

}