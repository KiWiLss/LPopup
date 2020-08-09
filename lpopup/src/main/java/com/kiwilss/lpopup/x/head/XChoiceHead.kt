/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: XChoiceHead
 * Author:   kiwilss
 * Date:     2020/8/9 16:05
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.x.head

import android.app.Activity
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.easy.EasyPopup
import kotlinx.android.synthetic.main.pw_choice_headx.view.*

/**
 *@FileName: XChoiceHead
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class XChoiceHead(activity: Activity,val callback: Callback,layoutId: Int = R.layout.pw_choice_headx): EasyPopup(activity,layoutId) {
    override fun setInterface() {

        contentView?.run {
            tv_pw_choice_header_cancel?.setOnClickListener {
                dismiss()
            }
            tv_pw_choice_header_take?.setOnClickListener {
                callback.camera(this@XChoiceHead)
            }
            tv_pw_choice_header_album?.setOnClickListener {
                callback.album(this@XChoiceHead)
            }
        }

    }
    interface Callback{
        fun camera(xChoiceHead: XChoiceHead)
        fun album(xChoiceHead: XChoiceHead)
    }
}