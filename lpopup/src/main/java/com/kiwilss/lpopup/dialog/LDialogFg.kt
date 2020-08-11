package com.kiwilss.lpopup.dialog

import android.os.Bundle
import android.text.TextUtils
import android.util.SparseArray
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.fragment.app.DialogFragment
import com.kiwilss.lpopup.R

/**
 * @author : Lss Administrator
 * @FileName: BaseDialogFragment
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {需要去继承的DialogFragment简单封装}
 */
abstract class LDialogFg : DialogFragment() {
    private var views: SparseArray<View?>? = null
    var mContentView: View? = null
    private var mWidth = WindowManager.LayoutParams.MATCH_PARENT
    private var mHeight = WindowManager.LayoutParams.WRAP_CONTENT
    private var mGravity = Gravity.CENTER
    private var mAnimationStyle = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        views = SparseArray()
        if (mContentView == null) {
            mContentView = inflater.inflate(initLayoutId(), container, false)
        }
        return mContentView
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initInterface()
    }

    fun setWidth(width: Int) {
        mWidth = width
    }

    fun setHeight(height: Int) {
        mHeight = height
    }

    fun setGravity(gravity: Int) {
        mGravity = gravity
    }

    fun setmAnimationStyle(animationStyle: Int) {
        mAnimationStyle = animationStyle
    }

    override fun onStart() {
        val dialog = dialog ?: return
        val window = dialog.window ?: return
        window.setBackgroundDrawableResource(R.color.transparent)
        val attributes = window.attributes
        attributes.width = mWidth
        attributes.height = mHeight
        attributes.gravity = mGravity
        attributes.windowAnimations = mAnimationStyle
        window.attributes = attributes
        super.onStart()
    }

    protected abstract fun initInterface()
    protected abstract fun initLayoutId(): Int
    fun setText(viewId: Int, text: String?) {
        if (!TextUtils.isEmpty(text)) {
            val tv = getView<TextView>(viewId)
            if (tv != null) {
                tv.text = text
            }
        }
    }

    fun setOnClick(viewId: Int, listener: View.OnClickListener?) {
        val view = getView<View>(viewId)
        view?.setOnClickListener(listener)
    }

    fun setImageRes(@IdRes viewId: Int, @DrawableRes res: Int) {
        val view = getView<ImageView>(viewId)
        view?.setImageResource(res)
    }

    fun <T : View?> getView(@IdRes viewId: Int): T? {
        var view = views!![viewId]
        if (view == null) {
            view = mContentView!!.findViewById(viewId)
            views!!.put(viewId, view)
        }
        return view as T?
    }
}