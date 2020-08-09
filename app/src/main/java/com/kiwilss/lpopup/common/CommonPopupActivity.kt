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
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lpopup.BasePopup
import com.kiwilss.lpopup.R
import com.kiwilss.lpopup.callback.LoCallback
import com.kiwilss.lpopup.callback.LoCallback2
import com.kiwilss.lpopup.callback.LtCallback
import com.kiwilss.lpopup.callback.LtCallback2
import com.kiwilss.lpopup.common.pp.*
import com.kiwilss.lpopup.easy.EasyPopup
import com.kiwilss.lpopup.easy.HorizontalPosition
import com.kiwilss.lpopup.easy.VerticalPosition

import com.kiwilss.lpopup.popup.Loopopup
import com.kiwilss.lpopup.popup.Lotpopup
import com.kiwilss.lpopup.popup.Ltopopup
import com.kiwilss.lpopup.popup.Lttpopup
import com.kiwilss.lpopup.x.head.XChoiceHead
import com.kiwilss.lpopup.x.normal.Xoopopup
import com.kiwilss.lpopup.x.normal.Xotpopup
import com.kiwilss.lpopup.x.normal.Xtopopup
import com.kiwilss.lpopup.x.normal.Xttpopup
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
                .title("builder 模式")//设置标题
                .titleColor(R.color.colorAccent)//标题颜色
                .titleIsBold(true)//设置加粗
                .outerBg(R.drawable.bg_white_fillet_20)//对话框背景
//                .btnText()//按钮文字
//                .btnSize()//按钮文字大小
//                .btnColor()//按钮文字颜色
//                .btnBg()//按钮背景
                .clickCallBack(object : LoCallback {
                    override fun click(loopopup: BasePopup?) {
                        loopopup?.dismiss()
                        Toast.makeText(this@CommonPopupActivity, "hello", Toast.LENGTH_SHORT).show()
                    }
                })
                .build()
                .showCenter()
        }

        //简单的2个标题,2个按钮对话框封装后使用示例
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
                .callback(object : LtCallback() {
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
                .callback(object : LoCallback {
                    override fun click(loopopup: BasePopup?) {
                        loopopup?.dismiss()
                    }

                })
                .build()
                .showCenter()
        }
        //easypopup 封装使用,每个弹出在中间都加了渐变动画,底部有向上弹出动画,顶部下拉动画,可以自定义动画
        btn_common_xoo.setOnClickListener {
            Xoopopup.Builder(this)
                .title("这是一个标题")//设置标题
                .titleColor(R.color.colorPrimary)//设置标题字体颜色
                .titleIsBold(true)//设置标题加粗
                .titleSize(R.dimen.s15)//设置标题字体大小
                //.outerBg()//设置整个对话框背景
                .btnText("随意点击")//按钮的文字
                .btnSize(R.dimen.s15)//按钮字体大小
                .btnColor(R.color.colorAccent)//按钮字体颜色
                //.btnBg()//按钮的背景,最好和对话框背景圆角一致
                .callback(object : LoCallback2 {
                    //设置按钮点击
                    override fun click(loopopup: EasyPopup?) {
                        loopopup?.dismiss()
                    }

                })
                .build()
                .showCenter()
        }
        btn_common_xot.setOnClickListener {
            Xotpopup.Builder(this)
                .title("标题党")//设置标题
                .titleColor(R.color.colorAccent)//标题颜色
                .titleSize(R.dimen.s12)//标题大小
                .titleIsBold(false)//标题是否加粗
                //.outerBg()//背景
                .leftText("关闭")//左侧按钮文字
                .leftColor(R.color.colorAccent)//左侧文字颜色
                .leftSize(R.dimen.s15)//左侧文字大小
                //.leftBg()//左侧背景
                .rightText("是")//右侧文字
                //.rightBg()//右侧背景
                .rightColor(R.color.blue0076)//右侧文字颜色
                .rightSize(R.dimen.s13)//右侧文字大小
                .callback(object : LtCallback2() {
                    //点击回调
                    override fun right(loopopup: EasyPopup?) {

                    }

                })
                .build()
                .showCenter()
        }
        btn_common_xto.setOnClickListener {
            Xtopopup.Builder(this)
                .title("title")//设置标题
//                .titleColor()//设置标题颜色
//                .titleSize()//设置标题大小
//                .titleIsBold()//设置标题是否加粗
//                .subtitleColor()//设置内容颜色
//                .subtitle()//设置内容文本
//                .subtitleSize()//设置内容字体大小
//                .outerBg()//设置背景
//                .btnText()//设置点击文本
//                .btnBg()//设置点击背景
//                .btnColor()//设置点击文字颜色
//                .btnSize()//设置点击文字大小
                .callback(object : LoCallback2 {
                    //点击
                    override fun click(loopopup: EasyPopup?) {

                    }

                }).build()//获取 popupwindow 实例,后面可以调用 popupwindow 的方法
                .showCenter()
        }

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
                .callback(object : LtCallback2() {
                    //可以选择是否需要取消点击
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
        //选择头像对话框,封装使用示例
        btn_common_head.setOnClickListener {
            val xChoiceHead = XChoiceHead(this, object : XChoiceHead.Callback {
                override fun camera(xChoiceHead: XChoiceHead) {

                }

                override fun album(xChoiceHead: XChoiceHead) {

                }

            })
                //.showBottom()
            //可以通过这个方法对内容进行修改
//            val tvCamrea = xChoiceHead.getView(R.id.tv_pw_choice_header_take) as TextView?
//            tvCamrea?.text = "是否拍照"
            xChoiceHead.showBottom()
        }
        //自定义对话框示例,随意一个对话框
        btn_common_head2.setOnClickListener {
            ChoiceHeadPw(this)
                .showBottom()
        }
        //精准控制对话框显示的位置,原生 PopupWindow 位置不好控制,默认在下方
        //这种类型弹出默认没有动画效果,可以直接根据弹出位置选择合适的动画
        btn_common_gravity.setOnClickListener {//居中下方显示
            GravityMenu(this)
                .setIsMask(false)//设置是否需要阴影,默认有阴影
                //.setAnimStyle(R.style.AnimFadeCenter)//设置动画效果
                //.setIsTouchOutsideDimiss()//设置点击外部是否消失,默认可以消失
                .showAtAnchorView(btn_common_gravity,VerticalPosition.BELOW,HorizontalPosition.CENTER)
        }
        btn_common_center.setOnClickListener {
            GravityMenu(this)
                .showAtAnchorView(btn_common_gravity,VerticalPosition.CENTER,HorizontalPosition.CENTER)
        }
        btn_common_bottom.setOnClickListener {
            GravityMenu(this)
                .setIsMask(false)//设置是否需要阴影,默认有阴影
                .showAtAnchorView(btn_common_gravity,VerticalPosition.BELOW,HorizontalPosition.CENTER)
        }
        btn_common_above.setOnClickListener {
            GravityMenu(this)
                .setIsMask(false)//设置是否需要阴影,默认有阴影
                .showAtAnchorView(btn_common_gravity,VerticalPosition.ABOVE,HorizontalPosition.CENTER)
        }
        btn_common_left.setOnClickListener {
            GravityMenu(this)
                .setIsMask(false)//设置是否需要阴影,默认有阴影
                .showAtAnchorView(btn_common_gravity,VerticalPosition.CENTER,HorizontalPosition.LEFT)
        }
        btn_common_right.setOnClickListener {
            GravityMenu(this)
                .setIsMask(false)//设置是否需要阴影,默认有阴影
                .showAtAnchorView(btn_common_gravity,VerticalPosition.BELOW,HorizontalPosition.RIGHT)
        }
        //下拉对话框
        btn_common_pull.setOnClickListener {
            PullPw(this)
                .setAnimStyle(R.style.GrowFromTop)//设置动画
                .setIsMask(false)//设置没有阴影
                .setIsTouchOutsideDimiss(false)//设置点击外部不能消失
                .showAsDropDown(btn_common_pull)//显示在这个控件的底部
        }
        //basepopup 使用示例
        btn_common_base.setOnClickListener {
            BasePopupDemo(this)
//                .setIsMask()//设置是否有阴影
//                .setIsClickDismiss()//设置点击外部是否消失
//                .setPopupWidth()//设置对话框宽度
//                .setPopupHeight()//设置对话框高度
//                .setAnimationStyle2()//设置对话框展示动画
                .showCenter()
        }
        //EasyPopup 使用示例
        btn_common_easy.setOnClickListener {
            EasyPopupDemo(this)
//                .setIsMask()//设置是否有阴影
//                .setIsTouchOutsideDimiss()//设置点击外部是否消失
//                .setAnimStyle()//设置动画
                .showCenter()
        }
        //EasyPopup 菜单样式示例,
        btn_common_menu.setOnClickListener {
            EasyMenuDemo(this)
                .setIsMask(false)//设置是否有阴影
                //.setIsTouchOutsideDimiss()//设置点击外部是否消失
                .setAnimStyle(R.style.PopDownRightMenu)//设置动画
                .showAsDropDown(btn_common_menu)
        }
    }
}