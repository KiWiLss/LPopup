/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: GravityMenu
 * Author:   kiwilss
 * Date:     2020/8/9 16:52
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.common.pp

import android.app.Activity
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.easy.EasyPopup

/**
 *@FileName: GravityMenu
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/9
 * @desc   : {DESCRIPTION}
 */
class GravityMenu(activity: Activity,layoutId: Int = R.layout.pw_menu2): EasyPopup(activity,layoutId) {
    /**
     * 初始化时设置,会在各种设置方法前调用
     */
    override fun initInterface() {

    }

    /**
     * 显示之前对界面处理和设置,会在各种设置方法后调用
     */
    override fun showBeforeOperator() {

    }


}