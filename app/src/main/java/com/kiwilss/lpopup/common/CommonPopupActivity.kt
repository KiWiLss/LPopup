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

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lpopup.R

import com.kiwilss.lpopup.popup.LPopupOO
import kotlinx.android.synthetic.main.activity_common.*

/**
 *@FileName: CommonPopupActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/5
 * @desc   : {DESCRIPTION}
 */
class CommonPopupActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)
        btn_common_oo.setOnClickListener {
            val popup = LPopupOO(activity = this,callback = object :LPopupOO.ClickCallBack(){
                override fun click(lPopupOO: LPopupOO) {
                    lPopupOO.dismiss()
                }

            })
            popup.setTitle("这是一个简单的测试")
            popup.showCenter()
        }

    }
}