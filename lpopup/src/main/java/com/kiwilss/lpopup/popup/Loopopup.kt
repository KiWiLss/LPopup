/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: LpopupOO2
 * Author:   kiwilss
 * Date:     2020/8/6 21:45
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
import kotlinx.android.synthetic.main.pw_oo.view.*

/**
 *@FileName: LpopupOO2
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/6
 * @desc   : {DESCRIPTION}
 */
class Loopopup private constructor(builder: Builder) :
    BasePopup(builder.activity, builder.layoutId) {
    var title: String? = null
    var titleSize: Int = 0
    var titleColor: Int = 0
    var titleIsBold: Boolean? = null
    var outerBg: Int = 0
    var btnText: String? = null
    var btnSize: Int = 0
    var btnColor: Int = 0
    var btnBg: Int = 0
    var clickCallBack: LoCallback? = null

    init {
        title = builder.title
        titleSize = builder.titleSize
        titleColor = builder.titleColor
        titleIsBold = builder.titleIsBold
        outerBg = builder.outerBg
        btnText = builder.btnText
        btnSize = builder.btnSize
        btnColor = builder.btnColor
        btnBg = builder.btnBg
        clickCallBack = builder.clickCallBack
    }

    //对外提供获取内部控件的方法
    //override fun getView(viewId: Int): View? = contentView?.findViewById(viewId)

    class Builder(val activity: Activity, val layoutId: Int = R.layout.pw_oo) {
        var title: String? = null
        var titleSize: Int = 0
        var titleColor: Int = 0
        var titleIsBold: Boolean? = null
        var outerBg: Int = 0
        var btnText: String? = null
        var btnSize: Int = 0
        var btnColor: Int = 0
        var btnBg: Int = 0
        var clickCallBack: LoCallback? = null
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

        fun clickCallBack(clickCallBack: LoCallback): Builder {
            this.clickCallBack = clickCallBack
            return this
        }

        fun build() = Loopopup(this)

    }

    override fun setInterface() {
        contentView?.let {
            title?.run {
                it.tv_pw_oo_title?.text = this
            }
            if (titleSize != 0) {
                it.tv_pw_oo_title?.setTextSize(TypedValue.COMPLEX_UNIT_PX,titleSize.toFloat())
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
                it.tv_pw_oo_sure?.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnSize.toFloat())
            }
            if (btnColor != 0) {
                it.tv_pw_oo_sure?.setTextColor(btnColor)
            }
            if (btnBg != 0) {
                it.tv_pw_oo_sure?.setBackgroundResource(btnBg)
            }
            clickCallBack?.run {
                it.tv_pw_oo_sure?.setOnClickListener {
                    click(this@Loopopup)
                }
            }
        }
    }
}