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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lpopup.BasePopup
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.callback.LoCallback
import com.kiwilss.lpopup.callback.LtCallback
import com.kiwilss.lpopup.callback.LtCallback2
import com.kiwilss.lpopup.easy.EasyPopup

import com.kiwilss.lpopup.popup.Loopopup
import com.kiwilss.lpopup.popup.Lotpopup
import com.kiwilss.lpopup.popup.Ltopopup
import com.kiwilss.lpopup.popup.Lttpopup
import com.kiwilss.lpopup.x.Xttpopup
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

        //简单的一个标题,一个按钮对话框封装后使用示例
        btn_common_oo2?.setOnClickListener {
            val pp = Lttpopup.Builder(this)
                .title("任意标题")
                .titleColor(R.color.colorAccent)
                .titleSize(R.dimen.s15)
                .titleIsBold(true)
                .subtitle("随意内容")
                .subtitleColor(R.color.blue0076)
                .subtitleSize(R.dimen.s15)
                .leftText("残忍")
                .leftSize(R.dimen.s15)
                .leftColor(R.color.colorPrimary)
                .rightText("立即就去")
                .rightSize(R.dimen.s15)
                .rightColor(R.color.white)
                .rightBg(R.drawable.bg_test_right)
                .callback(object :LtCallback(){
                    override fun right(loopopup: BasePopup?) {

                    }

                })
                .build()
                    //pp.animationStyle = R.style.AnimFadeCenter
                pp.showCenter()
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
        btn_common_to.setOnClickListener {
            Ltopopup.Builder(this)
                .callback(object :LoCallback{
                    override fun click(loopopup: BasePopup?) {
                        loopopup?.dismiss()
                    }

                })
                .build()
                .showCenter()
        }
        //easypopup 封装使用
        btn_common_xtt.setOnClickListener {
            Xttpopup.Builder(this)//这里第二个参数可以传你自己的布局(想控件生效,只要对应的控件 id一样就行)
                .title("标题加粗")//设置标题
                .titleSize(R.dimen.s18)//设置标题字体大小
                .titleIsBold(true)//设置标题是否加粗
                .titleColor(R.color.colorAccent)//设置标题颜色
                .outerBg(R.drawable.bg_white_fillet_20)//设置整个对话框背景
                .subtitle("二个标题,二个按钮")//设置副标题,内容
                .subtitleSize(R.dimen.s15)//设置副标题内容字体大小
                .subtitleColor(R.color.blue0076)//设置副标题字体颜色
                .leftText("残忍离开")//设置左侧标题
                .leftSize(R.dimen.s12)//设置左侧字体大小
                .leftColor(R.color.grayf5f5)//设置左侧字体颜色
                //.leftBg(R.drawable.bg_test_right)//设置左侧背景,最好背景左下角圆角和背景圆角一致
                .rightText("点开看看")//设置右侧文字
                .rightSize(R.dimen.s12)//设置右侧字体大小
                .rightColor(R.color.colorAccent)//右侧文字颜色
                .rightBg(R.drawable.bg_test_right)//设置右侧背景
                .callback(object : LtCallback2(){//可以选择是否需要取消点击
                    override fun right(loopopup: EasyPopup?) {//右侧按钮点击
                        loopopup?.dismiss()
                    }

                    override fun left(loopopup: EasyPopup?) {//左侧按钮点击
                        super.left(loopopup)//这个方法注释可以取消 dimiss
                    }
                })
                .build()
                .setIsMask(true)//设置是否有阴影
                .showCenter()
        }
    }
}