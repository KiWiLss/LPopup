package com.kiwilss.lpopup.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.SparseArray
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

/**
 * @author : Lss Administrator
 * @FileName: XDialog
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {不用继承,直接使用的Dialog简单封装}
 */
class XDialog(
    builder: Builder
) : Dialog(builder.context) {
    private val views = SparseArray<View?>()
    private val mWidth: Int
    private val mHeight: Int
    private val mGravity: Int
    private val mAnimationStyle: Int //默认没有动画效果

    private val layoutResId: Int
    private val mContentView: View



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(mContentView)
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

    fun setText(viewId: Int, text: String?): XDialog {
        if (!TextUtils.isEmpty(text)) {
            val tv = getView<TextView>(viewId)
            if (tv != null) {
                tv.text = text
            }
        }
        return this
    }

    fun setOnClick(viewId: Int, listener: View.OnClickListener?): XDialog {
        val view = getView<View>(viewId)
        view?.setOnClickListener(listener)
        return this
    }

    fun setImageRes(@IdRes viewId: Int, @DrawableRes res: Int): XDialog {
        val view = getView<ImageView>(viewId)
        view?.setImageResource(res)
        return this
    }

     fun <T : View?> getView(@IdRes viewId: Int): T? {
        var view = views[viewId]
        if (view == null) {
            view = mContentView.findViewById(viewId)
            views.put(viewId, view)
        }
        return view as T?
    }

    class Builder(val context: Context, val layoutResId: Int) {
        var width = ViewGroup.LayoutParams.MATCH_PARENT
         var height = ViewGroup.LayoutParams.WRAP_CONTENT
         var gravity = Gravity.CENTER
         var animationStyle = 0

        fun width(width: Int): Builder {
            this.width = width
            return this
        }

        fun height(height: Int): Builder {
            this.height = height
            return this
        }

        fun gravity(gravity: Int): Builder {
            this.gravity = gravity
            return this
        }

        fun animationStyle(animationStyle: Int): Builder {
            this.animationStyle = animationStyle
            return this
        }

        fun build(): XDialog {
            Log.e("MMM", ": build" )
            Log.e("MMM", ": build -- ${ (context == null) }")
            return XDialog( this)
        }

    }

    init {
        mWidth = builder.width
        mHeight = builder.height
        mGravity = builder.gravity
        mAnimationStyle = builder.animationStyle
        layoutResId = builder.layoutResId
        Log.e("MMM", ": init ${ (builder.context == null) }")

        mContentView = LayoutInflater.from(builder.context).inflate(layoutResId, null)
        setContentView(mContentView)
    }
}