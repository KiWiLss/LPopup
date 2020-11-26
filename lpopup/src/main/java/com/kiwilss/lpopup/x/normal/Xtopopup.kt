/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Xtopopup
 * Author:   kiwilss
 * Date:     2020/8/9 11:31
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
import kotlinx.android.synthetic.main.pw_to.view.*

/**
 *@FileName: Xtopopup
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class Xtopopup(builder: Builder) : EasyPopup(builder.activity, builder.layoutId) {
    var title: String? = null
    var titleSize: Int = 0
    var titleColor: Int = 0
    var titleIsBold: Boolean? = null
    var subtitle: String? = null
    var subtitleSize: Int = 0
    var subtitleColor: Int = 0
    var outerBg: Int = 0
    var btnText: String? = null
    var btnSize: Int = 0
    var btnColor: Int = 0
    var btnBg: Int = 0
    var callback: LoCallback2? = null

    class Builder(val activity: Activity, val layoutId: Int = R.layout.pw_to) {
        private val popup = Xtopopup(this)
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

        fun subtitle(subtitle: String): Builder {
            popup.subtitle = subtitle
            return this
        }

        fun subtitleSize(subtitleSize: Int): Builder {
            popup.subtitleSize = activity.resources.getDimensionPixelSize(subtitleSize)
            return this
        }

        fun subtitleColor(subtitleColor: Int): Builder {
            popup.subtitleColor = ContextCompat.getColor(activity, subtitleColor)
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

        fun build(): Xtopopup = popup

    }

    /**
     * 初始化时设置,会在各种设置方法前调用
     */
    override fun initInterface() {

    }

    override fun showBeforeOperator() {
        contentView?.let {
            title?.run {
                it.tv_pw_to_title?.text = this
            }
            if (titleSize != 0) {
                it.tv_pw_to_title?.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize.toFloat())
            }
            if (titleColor != 0) {
                it.tv_pw_to_title?.setTextColor(titleColor)
            }
            titleIsBold?.run {
                if (this) {
                    it.tv_pw_to_title?.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                }
            }
            subtitle?.run {
                it.tv_pw_to_subtitle?.text = this
            }
            if (subtitleSize != 0) {
                it.tv_pw_to_subtitle?.setTextSize(
                    TypedValue.COMPLEX_UNIT_PX,
                    subtitleSize.toFloat()
                )
            }
            if (subtitleColor != 0) {
                it.tv_pw_to_subtitle?.setTextColor(subtitleColor)
            }
            if (outerBg != 0) {
                it.ll_pw_to_outer?.setBackgroundResource(outerBg)
            }
            btnText?.run {
                it.tv_pw_to_sure?.text = this
            }
            if (btnSize != 0) {
                it.tv_pw_to_sure?.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnSize.toFloat())
            }
            if (btnColor != 0) {
                it.tv_pw_to_sure?.setTextColor(btnColor)
            }
            if (btnBg != 0) {
                it.tv_pw_to_sure?.setBackgroundResource(btnBg)
            }
            callback?.run {
                it.tv_pw_to_sure.setOnClickListener {
                    click(this@Xtopopup)
                }
            }
        }
    }

}