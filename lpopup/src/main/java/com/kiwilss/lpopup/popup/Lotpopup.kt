/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Lotpopup
 * Author:   kiwilss
 * Date:     2020/8/6 23:03
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.popup

import android.app.Activity
import android.graphics.Typeface
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.kiwilss.lpopup.BasePopup
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.callback.LtCallback
import kotlinx.android.synthetic.main.pw_oo.view.*
import kotlinx.android.synthetic.main.pw_ot.view.*

/**
 *@FileName: Lotpopup
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/6
 * @desc   : {DESCRIPTION}
 */
class Lotpopup private constructor(builder: Builder): BasePopup(builder.activity,builder.layoutId){
    var title: String? = null
    var titleSize: Int = 0
    var titleColor: Int = 0
    var titleIsBold: Boolean? = null
    var outerBg: Int = 0
    var leftText: String? = null
    var leftSize : Int = 0
    var leftColor : Int = 0
    var leftBg: Int = 0
    var rightText: String? = null
    var rightSize : Int = 0
    var rightColor : Int = 0
    var rightBg: Int = 0
    var callback: LtCallback? = null

    init {
        title = builder.title
        titleSize = builder.titleSize
        titleColor = builder.titleColor
        titleIsBold = builder.titleIsBold
        outerBg = builder.outerBg
        leftText = builder.leftText
        leftSize = builder.leftSize
        leftColor = builder.leftColor
        leftBg = builder.leftBg
        rightText = builder.rightText
        rightSize = builder.rightSize
        rightColor = builder.rightColor
        rightBg = builder.rightBg
        callback = builder.callback
    }



    class Builder(val activity: Activity, val layoutId:Int = R.layout.pw_ot){
        var title: String? = null
        var titleSize: Int = 0
        var titleColor: Int = 0
        var titleIsBold: Boolean? = null
        var outerBg: Int = 0
        var leftText: String? = null
        var leftSize : Int = 0
        var leftColor : Int = 0
        var leftBg: Int = 0
        var rightText: String? = null
        var rightSize : Int = 0
        var rightColor : Int = 0
        var rightBg: Int = 0
        var callback: LtCallback? = null
        fun title(title: String) : Builder {
            this.title = title
            return this
        }
        fun titleSize(titleSize: Int) : Builder {
            this.titleSize = activity.resources.getDimensionPixelSize(titleSize)
            return this
        }
        fun titleColor(titleColor: Int): Builder {
            this.titleColor = ContextCompat.getColor(activity,titleColor)
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
        fun leftText(leftText: String) : Builder {
            this.leftText = leftText
            return this
        }
        fun leftSize(leftSize: Int) : Builder {
            this.leftSize = activity.resources.getDimensionPixelSize(leftSize)
            return this
        }
        fun leftColor(leftColor: Int): Builder {
            this.leftColor = ContextCompat.getColor(activity,leftColor)
            return this
        }
        fun leftBg(leftBg: Int): Builder {
            this.leftBg = leftBg
            return this
        }
        fun rightText(rightText: String) : Builder {
            this.rightText = rightText
            return this
        }
        fun rightSize(rightSize: Int) : Builder {
            this.rightSize = activity.resources.getDimensionPixelSize(rightSize)
            return this
        }
        fun rightColor(rightColor: Int): Builder {
            this.rightColor = ContextCompat.getColor(activity,rightColor)
            return this
        }
        fun rightBg(@DrawableRes rightBg: Int): Builder {
            this.rightBg = rightBg
            return this
        }
        fun callback(callback: LtCallback): Builder {
            this.callback = callback
            return this
        }
        fun build() = Lotpopup(this)
    }

    override fun setInterface() {
        contentView?.let {
            title?.run {
                it.tv_pw_ot_title?.text = this
            }
            if (titleSize != 0) {
                it.tv_pw_ot_title?.textSize = titleSize.toFloat()
            }
            if (titleColor != 0) {
                it.tv_pw_ot_title?.setTextColor(titleColor)
            }
            if (outerBg != 0) {
                it.ll_pw_ot_outer?.setBackgroundResource(outerBg)
            }
            leftText?.run {
                it.tv_pw_ot_cancel?.text = this
            }
            if (leftSize != 0) {
                it.tv_pw_ot_cancel?.textSize = leftSize.toFloat()
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
                it.tv_pw_ot_sure?.textSize = rightSize.toFloat()
            }
            if (rightColor != 0) {
                it.tv_pw_ot_sure?.setTextColor(rightColor)
            }
            if (rightBg != 0) {
                it.tv_pw_ot_sure?.setBackgroundResource(rightBg)
            }

            callback?.run {
                it.tv_pw_ot_cancel?.setOnClickListener {
                   left(this@Lotpopup)
                }
                it.tv_pw_ot_sure.setOnClickListener {
                    right(this@Lotpopup)
                }
            }
            titleIsBold?.run {
                if (this) {
                    it.tv_pw_oo_title?.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
                }
            }
        }
    }


}