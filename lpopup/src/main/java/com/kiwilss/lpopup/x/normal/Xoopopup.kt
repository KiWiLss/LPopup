/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Xoopopup
 * Author:   kiwilss
 * Date:     2020/8/9 10:47
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.x.normal

import android.app.Activity
import android.graphics.Typeface
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.callback.LoCallback2
import com.kiwilss.lpopup.easy.EasyPopup
import kotlinx.android.synthetic.main.pw_oo.view.*

/**
 *@FileName: Xoopopup
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class Xoopopup(builder: Builder): EasyPopup(builder.activity,builder.layoutId) {
    var title: String? = null
    var titleSize: Int = 0
    var titleColor: Int = 0
    var titleIsBold: Boolean? = null
    var outerBg: Int = 0
    var btnText: String? = null
    var btnSize: Int = 0
    var btnColor: Int = 0
    var btnBg: Int = 0
    var callback: LoCallback2? = null

    class Builder(val activity: Activity, val layoutId: Int = R.layout.pw_oo) {
        private val popup = Xoopopup(this)
        fun title(title: String): Builder {
            popup.title = title
            return this
        }

        fun titleSize(titleSize: Int): Builder {
            popup.titleSize = activity.resources.getDimensionPixelSize(titleSize)
            return this
        }

        fun titleColor(titleColor: Int): Builder {
            popup.titleColor = ContextCompat.getColor(activity, titleColor)
            return this
        }

        fun titleIsBold(titleIsBold: Boolean): Builder {
            popup.titleIsBold = titleIsBold
            return this
        }

        fun outerBg(outerBg: Int): Builder {
            popup.outerBg = outerBg
            return this
        }

        fun btnText(btnText: String): Builder {
            popup.btnText = btnText
            return this
        }

        fun btnSize(btnSize: Int): Builder {
            popup.btnSize = activity.resources.getDimensionPixelSize(btnSize)
            return this
        }

        fun btnColor(btnColor: Int): Builder {
            popup.btnColor = ContextCompat.getColor(activity, btnColor)
            return this
        }

        fun btnBg(btnBg: Int): Builder {
            popup.btnBg = btnBg
            return this
        }

        fun callback(callback: LoCallback2): Builder {
            popup.callback = callback
            return this
        }

        fun build(): Xoopopup = popup

    }

    override fun setInterface() {
        contentView?.let {
            title?.run {
                it.tv_pw_oo_title?.text = this
            }
            if (titleSize != 0) {
                it.tv_pw_oo_title?.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize.toFloat())
            }
            if (titleColor != 0) {
                it.tv_pw_oo_title?.setTextColor(titleColor)
            }
            titleIsBold?.run {
                if (this) {
                    it.tv_pw_oo_title?.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                }
            }
            if (outerBg != 0) {
                it.ll_pw_oo_outer?.setBackgroundResource(outerBg)
            }
            btnText?.run {
                it.tv_pw_oo_sure?.text = this
            }
            if (btnSize != 0) {
                it.tv_pw_oo_sure?.setTextSize(TypedValue.COMPLEX_UNIT_PX,btnSize.toFloat())
            }
            if (btnColor != 0) {
                it.tv_pw_oo_sure?.setTextColor(btnColor)
            }
            if (btnBg != 0) {
                it.tv_pw_oo_sure?.setBackgroundResource(btnBg)
            }

        }
    }
}