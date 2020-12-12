/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: OOCallback
 * Author:   kiwilss
 * Date:     2020/8/6 22:25
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lpopup.callback

import com.kiwilss.lpopup.easy.EasyPopup

/**
 *@FileName: OOCallback
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/6
 * @desc   : {DESCRIPTION}
 */
abstract class LtCallback2 {
    open fun left(loopopup: EasyPopup?){
        loopopup?.dismiss()
    }

    abstract fun right(loopopup: EasyPopup?)
}