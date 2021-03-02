package com.kiwilss.lpopup.utils

import android.content.Context
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow

/**
 *@FileName: ScreenUtils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/12
 * @desc   : {DESCRIPTION}
 */
object ScreenUtils {
    fun setScreenAlpha(context: Context, pp: PopupWindow, dimAmount: Float) {
        val decorView: View? = getDecorView(pp)
        decorView?.let {
            val p = decorView.layoutParams as WindowManager.LayoutParams
            p.flags = p.flags or WindowManager.LayoutParams.FLAG_DIM_BEHIND
            p.dimAmount = dimAmount
            //modifyWindowLayoutParams(p)
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
                .updateViewLayout(decorView, p)
        }
    }

    private fun getDecorView(pp: PopupWindow): View? {
        var decorView: View? = null
        try {
            decorView = if (pp.background == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    pp.contentView.parent as View
                } else {
                    pp.contentView
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    pp.contentView.parent.parent as View
                } else {
                    pp.contentView.parent as View
                }
            }
        } catch (ignore: Exception) {
        }
        return decorView
    }
}