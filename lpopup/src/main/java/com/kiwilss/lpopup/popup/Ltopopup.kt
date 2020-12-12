/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Ltopopup
 * Author:   kiwilss
 * Date:     2020/8/6 23:40
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.popup

import android.app.Activity
import android.graphics.Typeface
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.callback.LoCallback
import kotlinx.android.synthetic.main.pw_to.view.*

/**
 *@FileName: Ltopopup
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/6
 * @desc   : {DESCRIPTION}
 */
class Ltopopup private constructor(builder: Builder) :
    BasePopup(builder.activity, builder.layoutId){

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
    var callback: LoCallback? = null

    init {
        title = builder.title
        titleSize = builder.titleSize
        titleColor = builder.titleColor
        titleIsBold = builder.titleIsBold
        subtitle = builder.subtitle
        subtitleSize = builder.subtitleSize
        subtitleColor = builder.subtitleColor
        outerBg = builder.outerBg
        btnText = builder.btnText
        btnSize = builder.btnSize
        btnColor = builder.btnColor
        btnBg = builder.btnBg
        callback = builder.callback
    }

    class Builder(val activity: Activity, val layoutId: Int = R.layout.pw_to) {
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
        var callback: LoCallback? = null
        fun title(title: String): Builder {
            this.title = title
            return this
        }

        fun titleSize(titleSize: Int): Builder {
            this.titleSize = activity.resources.getDimensionPixelSize(titleSize)
            return this
        }

        fun titleColor(titleColor: Int): Builder {
            this.titleColor = ContextCompat.getColor(activity, titleColor)
            return this
        }

        fun titleIsBold(titleIsBold: Boolean): Builder {
            this.titleIsBold = titleIsBold
            return this
        }

        fun subtitle(subtitle: String): Builder {
            this.subtitle = subtitle
            return this
        }

        fun subtitleSize(subtitleSize: Int): Builder {
            this.subtitleSize = activity.resources.getDimensionPixelSize(subtitleSize)
            return this
        }

        fun subtitleColor(subtitleColor: Int): Builder {
            this.subtitleColor = ContextCompat.getColor(activity, subtitleColor)
            return this
        }

        fun outerBg(outerBg: Int): Builder {
            this.outerBg = outerBg
            return this
        }

        fun btnText(btnText: String): Builder {
            this.btnText = btnText
            return this
        }

        fun btnSize(btnSize: Int): Builder {
            this.btnSize = activity.resources.getDimensionPixelSize(btnSize)
            return this
        }

        fun btnColor(btnColor: Int): Builder {
            this.btnColor = ContextCompat.getColor(activity, btnColor)
            return this
        }

        fun btnBg(btnBg: Int): Builder {
            this.btnBg = btnBg
            return this
        }

        fun callback(callback: LoCallback): Builder {
            this.callback = callback
            return this
        }

        fun build() = Ltopopup(this)

    }

    override fun setInterface() {
        contentView?.let {
            title?.run {
                it.tv_pw_to_title?.text = this
            }
            if (titleSize != 0) {
                it.tv_pw_to_title?.setTextSize(TypedValue.COMPLEX_UNIT_PX,titleSize.toFloat())
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
                it.tv_pw_to_subtitle?.setTextSize(TypedValue.COMPLEX_UNIT_PX,subtitleSize.toFloat())
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
                it.tv_pw_to_sure?.setTextSize(TypedValue.COMPLEX_UNIT_PX,btnSize.toFloat())
            }
            if (btnColor != 0) {
                it.tv_pw_to_sure?.setTextColor(btnColor)
            }
            if (btnBg != 0) {
                it.tv_pw_to_sure?.setBackgroundResource(btnBg)
            }
            callback?.run {
                it.tv_pw_to_sure?.setOnClickListener {
                    click(this@Ltopopup)
                }
            }


        }
    }

}