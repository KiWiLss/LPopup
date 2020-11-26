/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: EasyPopupDemo
 * Author:   kiwilss
 * Date:     2020/8/9 22:24
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.common.pp

import android.app.Activity
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.easy.EasyPopup
import kotlinx.android.synthetic.main.pw_center.view.*

/**
 *@FileName: EasyPopupDemo
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class EasyPopupDemo(activity: Activity,layoutId: Int = R.layout.pw_center): EasyPopup(activity,layoutId) {
    /**
     * 初始化时设置,会在各种设置方法前调用
     */
    override fun initInterface() {

    }

    override fun showBeforeOperator() {
        contentView?.run {
            //这里可以做获取数据,设置数据的操作,点击事件,以及对话框显示前的各种设置都可以在这里
            contentView?.run {
                tv_pw_onetitle_title.text = "你好"
            }
        }
    }
}