/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: Utils
 * Author:   kiwilss
 * Date:     2020/7/5 18:53
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.view.WindowManager



/**
 *@FileName: Utils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/5
 * @desc   : {DESCRIPTION}
 */
object Utils {

    /**
     * 根据手机分辨率从dp转成px
     *
     * @param context
     * @param dpValue
     * @return
     */
    fun dip2px(context: Context, dpValue: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    fun backgroundAlpha(context: Activity,bgAlpha: Float) {
        val lp: WindowManager.LayoutParams = context.window.attributes
        lp.alpha = bgAlpha //0.0-1.0
        context.window.attributes = lp
    }

}