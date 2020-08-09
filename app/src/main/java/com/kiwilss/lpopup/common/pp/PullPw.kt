/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: PullPw
 * Author:   kiwilss
 * Date:     2020/8/9 17:21
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.common.pp

import android.app.Activity
import android.util.Log
import android.view.ViewGroup
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.easy.EasyPopup
import kotlinx.android.synthetic.main.pw_pull.view.*

/**
 *@FileName: PullPw
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class PullPw(activity: Activity, layoutId: Int = R.layout.pw_pull): EasyPopup(activity,layoutId) {
    override fun setInterface() {
        //设置宽高,默认是只使用,要修改成下面这样
        width = ViewGroup.LayoutParams.MATCH_PARENT
        height = ViewGroup.LayoutParams.MATCH_PARENT
        contentView?.run {
            ll_pw_pull_outer.setOnClickListener {
                dismiss()
            }
            ll_pw_pull_outer2.setOnClickListener {
                dismiss()
            }
        }

    }
}