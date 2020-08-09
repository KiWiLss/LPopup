/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: BasePopupDemo
 * Author:   kiwilss
 * Date:     2020/8/9 22:19
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.common.pp

import android.app.Activity
import com.kiwilss.lpopup.BasePopup
import com.kiwilss.lpopup.R
import kotlinx.android.synthetic.main.pw_center.view.*

/**
 *@FileName: BasePopupDemo
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class BasePopupDemo(activity: Activity,layoutId: Int = R.layout.pw_center): BasePopup(activity,layoutId) {
    override fun setInterface() {
        //这里可以做获取数据,设置数据的操作,点击事件,以及对话框显示前的各种设置都可以在这里
        contentView?.run {
            tv_pw_onetitle_title.text = "你好"
        }

    }
}