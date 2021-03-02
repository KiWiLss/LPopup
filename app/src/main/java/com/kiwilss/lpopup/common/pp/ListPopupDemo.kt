package com.kiwilss.lpopup.common.pp

import android.app.Activity
import android.util.Log
import android.widget.TextView
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.easy.EasyPopup

/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/03/02
 *  desc   :
 */
class ListPopupDemo(activity: Activity, layoutId: Int = R.layout.pw_list): EasyPopup(activity,layoutId) {

    //执行顺序从上往下

     var tvTitle: TextView? = null
    override fun initInterface() {
        Log.e("MMM", ": initInterface" )
        tvTitle = getViewAny<TextView>(R.id.tvPwListTitle)
        tvTitle?.text = "测试标题"
    }

    init {
        Log.e("MMM", ": init" )
    }

    fun setTest(): ListPopupDemo{
        Log.e("MMM", ": setTest" )
        tvTitle?.text = "修改标题"
        return this
    }

    override fun showBeforeOperator() {
        Log.e("MMM", ": showBeforeOperator" )
    }


}