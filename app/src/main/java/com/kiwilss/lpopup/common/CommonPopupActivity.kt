/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: CommonPopupActivity
 * Author:   kiwilss
 * Date:     2020/8/5 23:09
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.lpopup.common

import android.graphics.Typeface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lpopup.BasePopup
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.callback.LoCallback
import com.kiwilss.lpopup.callback.LtCallback

import com.kiwilss.lpopup.popup.LPopupOO
import com.kiwilss.lpopup.popup.Loopopup
import com.kiwilss.lpopup.popup.Lotpopup
import kotlinx.android.synthetic.main.activity_common.*


/**
 *@FileName: CommonPopupActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {DESCRIPTION}
 */
class CommonPopupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)
        //简单的一个标题,一个按钮对话框使用示例
        btn_common_oo.setOnClickListener {
            val popup = LPopupOO(activity = this, callback = object : LPopupOO.ClickCallBack() {
                override fun click(lPopupOO: LPopupOO) {
                    lPopupOO.dismiss()
                }

            })
            popup.setTitle("这是一个简单的测试")
            //(popup.getView(R.id.tv_pw_oo_title) as TextView ).text = "再次修改"
            popup.showCenter()
        }

        //简单的一个标题,一个按钮对话框封装后使用示例
        btn_common_oo2?.setOnClickListener {
            Loopopup.Builder(this)
                .title("builder 模式")
                .titleColor(R.color.colorAccent)
                .titleIsBold(true)//设置加粗
                .outerBg(R.drawable.bg_white_fillet_20)
                .clickCallBack(object : LoCallback {
                    override fun click(loopopup: BasePopup?) {
                        loopopup?.dismiss()
                        Toast.makeText(this@CommonPopupActivity, "hello", Toast.LENGTH_SHORT).show()
                    }
                })
                .build()
                .showCenter()
        }
        btn_common_ot.setOnClickListener {
            Lotpopup.Builder(this)
                .rightBg(R.drawable.bg_test_right)//设置按钮背景,圆角要和整个背景圆角大小相同
                .callback(object : LtCallback() {
                    //默认设置了左侧取消按钮,如需要可重写方法,示例如下
                    override fun right(loopopup: BasePopup?) {
                        loopopup?.dismiss()
                        Toast.makeText(this@CommonPopupActivity, "right", Toast.LENGTH_SHORT).show()
                    }

                    override fun left(loopopup: BasePopup?) {
                        super.left(loopopup)
                        Toast.makeText(this@CommonPopupActivity, "left", Toast.LENGTH_SHORT).show()
                    }
                })
                .build()
                .showCenter()
        }
    }
}