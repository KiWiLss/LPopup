/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: DefaultDialog
 * Author:   Administrator
 * Date:     2020/8/11 14:22
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.dialog.ldialog

import android.content.Context
import android.os.Bundle
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.dialog.LDialog

/**
 *@FileName: DefaultDialog
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/11
 * @desc   : {DESCRIPTION}
 */
class DefaultDialog(context: Context) : LDialog(context) {
    override fun initInterface(savedInstanceState: Bundle?) {

    }

    override fun initContentView(): Int = R.layout.pw_center
}