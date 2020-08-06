/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: PopupOO
 * Author:   kiwilss
 * Date:     2020/8/5 22:56
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.popup

import android.app.Activity
import android.text.TextUtils
import android.view.View
import com.kiwilss.lpopup.BasePopup
import com.kiwilss.lpopup.R
import kotlinx.android.synthetic.main.pw_oo.view.*

/**
 *@FileName: PopupOO
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {常见的一个标题,一个按钮对话框}
 */
class LPopupOO(activity: Activity, layoutId:Int = R.layout.pw_oo, private val callback: ClickCallBack)
    : BasePopup(activity,layoutId) {

    //设置标题
    lateinit var mTitle: String

    fun setTitle(title: String){
        mTitle = title
    }

    fun getView(id: Int): View = contentView.findViewById(id)


    override fun setInterface() {
        contentView?.tv_pw_oo_title?.run {
            if (!TextUtils.isEmpty(mTitle)) {
                text = mTitle
            }
        }
        //contentView.tv_pw_oo_title.setTextSize()
        contentView.tv_pw_oo_sure.setOnClickListener {
            callback.click(this)
        }
    }



    abstract class ClickCallBack{
        abstract fun click(lPopupOO: LPopupOO)
    }

}

