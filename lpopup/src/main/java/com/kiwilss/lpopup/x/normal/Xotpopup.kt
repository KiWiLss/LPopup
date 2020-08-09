/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Xotpopup
 * Author:   kiwilss
 * Date:     2020/8/9 11:06
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.x.normal

import android.app.Activity
import android.graphics.Typeface
import android.util.TypedValue
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.callback.LtCallback2
import com.kiwilss.lpopup.easy.EasyPopup
import kotlinx.android.synthetic.main.pw_ot.view.*

/**
 *@FileName: Xotpopup
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class Xotpopup(builder: Builder) : EasyPopup(builder.activity, builder.layoutId) {
    var title: String? = null
    var titleSize: Int = 0
    var titleColor: Int = 0
    var titleIsBold: Boolean? = null
    var outerBg: Int = 0
    var leftText: String? = null
    var leftSize: Int = 0
    var leftColor: Int = 0
    var leftBg: Int = 0
    var rightText: String? = null
    var rightSize: Int = 0
    var rightColor: Int = 0
    var rightBg: Int = 0
    var callback: LtCallback2? = null

    class Builder(val activity: Activity, val layoutId: Int = R.layout.pw_ot) {
        private val popup = Xotpopup(this)

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

        fun leftText(leftText: String): Builder {
            popup.leftText = leftText
            return this
        }

        fun leftSize(leftSize: Int): Builder {
            popup.leftSize = activity.resources.getDimensionPixelSize(leftSize)
            return this
        }

        fun leftColor(leftColor: Int): Builder {
            popup.leftColor = ContextCompat.getColor(activity, leftColor)
            return this
        }

        fun leftBg(leftBg: Int): Builder {
            popup.leftBg = leftBg
            return this
        }

        fun rightText(rightText: String): Builder {
            popup.rightText = rightText
            return this
        }

        fun rightSize(rightSize: Int): Builder {
            popup.rightSize = activity.resources.getDimensionPixelSize(rightSize)
            return this
        }

        fun rightColor(rightColor: Int): Builder {
            popup.rightColor = ContextCompat.getColor(activity, rightColor)
            return this
        }

        fun rightBg(@DrawableRes rightBg: Int): Builder {
            popup.rightBg = rightBg
            return this
        }

        fun callback(callback: LtCallback2): Builder {
            popup.callback = callback
            return this
        }

        fun build(): Xotpopup = popup

    }

    override fun setInterface() {
        contentView?.let {
            title?.run {
                it.tv_pw_ot_title?.text = this
            }
            if (titleSize != 0) {
                it.tv_pw_ot_title?.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize.toFloat())
            }
            if (titleColor != 0) {
                it.tv_pw_ot_title?.setTextColor(titleColor)
            }
            titleIsBold?.run {
                if (this) {
                    it.tv_pw_ot_title?.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                }
            }
            if (outerBg != 0) {
                it.ll_pw_ot_outer?.setBackgroundResource(outerBg)
            }
            leftText?.run {
                it.tv_pw_ot_cancel?.text = this
            }
            if (leftSize != 0) {
                it.tv_pw_ot_cancel?.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftSize.toFloat())
            }
            if (leftColor != 0) {
                it.tv_pw_ot_cancel?.setTextColor(leftColor)
            }
            if (leftBg != 0) {
                it.tv_pw_ot_cancel?.setBackgroundResource(leftBg)
            }
            rightText?.run {
                it.tv_pw_ot_sure?.text = this
            }
            if (rightSize != 0) {
                it.tv_pw_ot_sure?.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightSize.toFloat())
            }
            if (rightColor != 0) {
                it.tv_pw_ot_sure?.setTextColor(rightColor)
            }
            if (rightBg != 0) {
                it.tv_pw_ot_sure?.setBackgroundResource(rightBg)
            }
            callback?.run {
                it.tv_pw_ot_cancel?.setOnClickListener {
                    left(this@Xotpopup)
                }
                it.tv_pw_ot_sure.setOnClickListener {
                    right(this@Xotpopup)
                }
            }
        }
    }
}