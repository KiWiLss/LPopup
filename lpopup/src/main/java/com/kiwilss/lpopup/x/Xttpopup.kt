/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Lttpopup
 * Author:   kiwilss
 * Date:     2020/8/7 21:51
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.x

import android.app.Activity
import android.graphics.Typeface
import android.util.TypedValue
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.callback.LtCallback2
import com.kiwilss.lpopup.easy.EasyPopup
import kotlinx.android.synthetic.main.pw_tt.view.*

/**
 *@FileName: Lttpopup
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/7
 * @desc   : {通用两个标题,两个按钮}
 */
class Xttpopup private constructor(builder: Builder) :
    EasyPopup(builder.activity, builder.layoutId) {
    var title: String? = null
    var titleSize: Int = 0
    var titleColor: Int = 0
    var titleIsBold: Boolean? = null
    var subtitle: String? = null
    var subtitleSize: Int = 0
    var subtitleColor: Int = 0
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

    class Builder(val activity: Activity, val layoutId: Int = R.layout.pw_tt) {
        private var lttpopup: Xttpopup =
            Xttpopup(this)
        fun title(title: String): Builder {
            lttpopup.title = title
            return this
        }

        fun titleSize(titleSize: Int): Builder {
            lttpopup.titleSize = activity.resources.getDimensionPixelSize(titleSize)
            return this
        }

        fun titleColor(titleColor: Int): Builder {
            lttpopup.titleColor = ContextCompat.getColor(activity, titleColor)
            return this
        }

        fun titleIsBold(titleIsBold: Boolean): Builder {
            lttpopup.titleIsBold = titleIsBold
            return this
        }

        fun subtitle(subtitle: String): Builder {
            lttpopup.subtitle = subtitle
            return this
        }

        fun subtitleSize(subtitleSize: Int): Builder {
            lttpopup.subtitleSize = activity.resources.getDimensionPixelSize(subtitleSize)
            return this
        }

        fun subtitleColor(subtitleColor: Int): Builder {
            lttpopup.subtitleColor = ContextCompat.getColor(activity, subtitleColor)
            return this
        }

        fun outerBg(outerBg: Int): Builder {
            lttpopup.outerBg = outerBg
            return this
        }

        fun leftText(leftText: String): Builder {
            lttpopup.leftText = leftText
            return this
        }

        fun leftSize(leftSize: Int): Builder {
            lttpopup.leftSize = activity.resources.getDimensionPixelSize(leftSize)
            return this
        }

        fun leftColor(leftColor: Int): Builder {
            lttpopup.leftColor = ContextCompat.getColor(activity, leftColor)
            return this
        }

        fun leftBg(leftBg: Int): Builder {
            lttpopup.leftBg = leftBg
            return this
        }

        fun rightText(rightText: String): Builder {
            lttpopup.rightText = rightText
            return this
        }

        fun rightSize(rightSize: Int): Builder {
            lttpopup.rightSize = activity.resources.getDimensionPixelSize(rightSize)
            return this
        }

        fun rightColor(rightColor: Int): Builder {
            lttpopup.rightColor = ContextCompat.getColor(activity, rightColor)
            return this
        }

        fun rightBg(@DrawableRes rightBg: Int): Builder {
            lttpopup.rightBg = rightBg
            return this
        }

        fun callback(callback: LtCallback2): Builder {
            lttpopup.callback = callback
            return this
        }

        fun build(): Xttpopup = lttpopup
    }

    override fun setInterface() {
        contentView?.let {
            title?.run {
                it.tv_pw_tt_title?.text = this
            }
            if (titleSize != 0) {
                it.tv_pw_tt_title?.setTextSize(TypedValue.COMPLEX_UNIT_PX,titleSize.toFloat())
            }
            if (titleColor != 0) {
                it.tv_pw_tt_title?.setTextColor(titleColor)
            }
            titleIsBold?.run {
                if (this) {
                    it.tv_pw_tt_title?.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                }
            }
            subtitle?.run {
                it.tv_pw_tt_subtitle?.text = this
            }
            if (subtitleSize != 0) {
                it.tv_pw_tt_subtitle?.setTextSize(TypedValue.COMPLEX_UNIT_PX,subtitleSize.toFloat())
            }
            if (subtitleColor != 0) {
                it.tv_pw_tt_subtitle?.setTextColor(subtitleColor)
            }
            if (outerBg != 0) {
                it.ll_pw_tt_outer?.setBackgroundResource(outerBg)
            }
            leftText?.run {
                it.tv_pw_tt_cancel?.text = this
            }
            if (leftSize != 0) {
                it.tv_pw_tt_cancel?.setTextSize(TypedValue.COMPLEX_UNIT_PX,leftSize.toFloat())
            }
            if (leftColor != 0) {
                it.tv_pw_tt_cancel?.setTextColor(leftColor)
            }
            if (leftBg != 0) {
                it.tv_pw_tt_cancel?.setBackgroundResource(leftBg)
            }
            rightText?.run {
                it.tv_pw_tt_sure?.text = this
            }
            if (rightSize != 0) {
                it.tv_pw_tt_sure?.setTextSize(TypedValue.COMPLEX_UNIT_PX,rightSize.toFloat())
            }
            if (rightColor != 0) {
                it.tv_pw_tt_sure?.setTextColor(rightColor)
            }
            if (rightBg != 0) {
                it.tv_pw_tt_sure?.setBackgroundResource(rightBg)
            }
            callback?.run {
                it.tv_pw_tt_cancel?.setOnClickListener {
                    left(this@Xttpopup)
                }
                it.tv_pw_tt_sure.setOnClickListener {
                    right(this@Xttpopup)
                }
            }


        }
    }
}