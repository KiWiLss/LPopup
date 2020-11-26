/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ChoiceHeadPw
 * Author:   kiwilss
 * Date:     2020/8/9 16:24
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.common.pp

import android.app.Activity
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.easy.EasyPopup
import kotlinx.android.synthetic.main.pw_choice_head.view.*

/**
 *@FileName: ChoiceHeadPw
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class ChoiceHeadPw(activity: Activity,layoutId: Int = R.layout.pw_choice_head): EasyPopup(activity,layoutId) {
    /**
     * 初始化时设置,会在各种设置方法前调用
     */
    override fun initInterface() {
        contentView?.run {

            tv_pw_choice_head_cancel.setOnClickListener {
                dismiss()
            }
            tv_pw_choice_head_camera.text = "选择相机"

        }
    }

    override fun showBeforeOperator() {

    }
}