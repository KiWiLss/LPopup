# LPopup
常用对话框整理
PopupWindow 使用详解，常用对话框整理,如果觉得不错的话,欢迎给个 star **
## 一,引入

![](https://www.jitpack.io/v/KiWiLss/LPopup.svg)

Add it in your root build.gradle at the end of repositories:
```
allprojects {  repositories { ...
maven { url 'https://www.jitpack.io' }
} }

**Step 2.** Add the dependency

dependencies {
 implementation 'com.github.KiWiLss:LPopup:last'
}
```

  [使用详解](https://www.yuque.com/bibly/clwnn5/ea71od)

  # 安卓对话框相关及简单封装使用

  <a name="LIX4a"></a>
  ## 一、前言
  在正常使用 PopupWindow 时不是很难，只需要几行代码就能实现一个对话框，但是有很多方法都是重复的，PopupWindow 本身会有一些局限性，需要处理。在使用 PopupWindows 时，默认是没有阴影背景的，需要自己处理。仅仅使用 PopupWindow 就可以满足项目中大部分的对话框需求。但是 Dialog 也有它的优势，所以可以看具体情况选择合适的对话框。封装后，调用起来更加方便，同时对于一些高频对话框可以做成通用的，以后就不需要再重复去写，随时调用更加方便。
  <a name="I37dH"></a>
  ## 二、引入<br />
  ![](https://cdn.nlark.com/yuque/0/2020/svg/1624725/1596989031992-38dd1265-94f7-4f85-80f5-6f505a7dc641.svg#align=left&display=inline&height=20&margin=%5Bobject%20Object%5D&originHeight=20&originWidth=91&size=0&status=done&style=none&width=91)<br />Add it in your root build.gradle at the end of repositories:
  ```
  allprojects {
  		repositories {
  			...
  			maven { url 'https://www.jitpack.io' }
  		}
  	}
  ```
  **Step 2.** Add the dependency
  ```
  dependencies {
  	        implementation 'com.github.KiWiLss:LPopup:1.0.0'
  	}
  ```
  <a name="p0Xqn"></a>
  ## 三、BasePopup简单使用
  > BasePopup 是封装的基本对话框，其他对话框可以直接继承 BasePopup 使用，这样使用起来更简单方便。阴影动画效果也很好，[PopupWindow 使用总结](https://www.yuque.com/bibly/clwnn5/ngl64m)，这篇文章有对阴影实现方式的分析总结。阴影的实现缺点是部分机型状态栏不能覆盖阴影，整体来说效果还是挺好的。

  <a name="WN28w"></a>
  #### 1. 简单使用示例

  - 效果图：![iShot2020-08-0922.46.35.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596984452445-8f60591a-683c-43a9-9cd2-d84456bf4ef8.gif#align=left&display=inline&height=1274&margin=%5Bobject%20Object%5D&name=iShot2020-08-0922.46.35.gif&originHeight=1274&originWidth=710&size=8333883&status=done&style=none&width=710)

  <br />对话框代码：<br />这里做对话框具体的实现，也可以设置各种想要的效果。
  ```kotlin
  class BasePopupDemo(activity: Activity,layoutId: Int = R.layout.pw_center): BasePopup(activity,layoutId) {
      override fun setInterface() {
          //这里可以做获取数据,设置数据的操作,点击事件,以及对话框显示前的各种设置都可以在这里
          contentView?.run {
              tv_pw_onetitle_title.text = "你好"
          }

      }
  }
  ```
  简单布局：
  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout
      xmlns:android="http://schemas.android.com/apk/res/android"
      android:orientation="vertical" android:layout_width="match_parent"
      android:layout_height="match_parent"
      >


      <LinearLayout
          android:id="@+id/ll_pw_onetitle_outer"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layout_marginHorizontal="40dp"
          android:orientation="vertical"
          android:layout_gravity="center"
          android:background="@drawable/bg_white_fillet_10">

          <!--标题-->
          <TextView
              android:id="@+id/tv_pw_onetitle_title"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="提示"
              android:textSize="18sp"
              android:textColor="#80000000"
              android:layout_gravity="center_horizontal"
              android:gravity="center"
              android:padding="25dp"
              android:layout_marginLeft="15dp"
              android:layout_marginRight="15dp"/>

          <View
              android:layout_width="match_parent"
              android:layout_height="0.5dp"
              android:background="#90000000"
              />
          <LinearLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              >
              <TextView
                  android:id="@+id/tv_pw_onetitle_cancel"
                  android:layout_width="0dp"
                  android:layout_height="wrap_content"
                  android:layout_weight="1"
                  android:text="取消"
                  android:textSize="15sp"
                  android:textColor="#80000000"
                  android:gravity="center"
                  android:padding="15dp"
                  />

              <View
                  android:layout_width="0.5dp"
                  android:layout_height="match_parent"
                  android:background="#90000000"/>
              <TextView
                  android:id="@+id/tv_pw_onetitle_sure"
                  android:layout_width="0dp"
                  android:layout_height="wrap_content"
                  android:layout_weight="1"
                  android:text="确定"
                  android:textSize="15sp"
                  android:textColor="#80000000"
                  android:gravity="center"
                  android:padding="15dp"
                  />
          </LinearLayout>


      </LinearLayout>

  </LinearLayout>
  ```
  调用，里面有各种方法的详细注解：
  ```kotlin
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
  ```
  <a name="0Pnk6"></a>
  #### 2.内置封装对话框使用示例，基本都是偏向 Ios 风格
  效果图：<br />![iShot2020-08-0922.53.18.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596984870168-5243261c-8d46-4688-80e1-4e49316a4d8f.gif#align=left&display=inline&height=480&margin=%5Bobject%20Object%5D&name=iShot2020-08-0922.53.18.gif&originHeight=480&originWidth=278&size=4463533&status=done&style=none&width=278)

  - 2.1 一个标题，一个按钮对话框，代码中有详细的注释
  ```kotlin
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
  ```

  - 2.2 一个标题，两个按钮样式
  ```kotlin
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
  ```

  - 2.3 两个标题（副标题，可以作为内容），一个按钮
  ```kotlin
   Ltopopup.Builder(this)
                  .callback(object : LoCallback {
                      override fun click(loopopup: BasePopup?) {
                          loopopup?.dismiss()
                      }

                  })
                  .build()
                  .showCenter()
  ```

  - 2.4 两个标题（副标题，可以作为内容），两个按钮
  ```kotlin
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
  ```
  <a name="hrxfc"></a>
  ## 三、EasyPopup 使用
  > EasyPopup 这个对话框，动画效果很好，不会出现阴影无法覆盖的状态栏情况，同时对于位置的控制更好，可以更好的用在菜单型对话框上面。推荐使用这个。

  <a name="QqVq9"></a>
  #### 3.1 简单使用示例
  效果图：![iShot2020-08-0923.08.42.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596985762252-27d224c0-dfd4-44a0-bb7c-7e22ffb1c8dc.gif#align=left&display=inline&height=1274&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.08.42.gif&originHeight=1274&originWidth=714&size=7854433&status=done&style=none&width=714)<br />
  <br />自定义对话框继承 EasyPopu：
  ```kotlin
  class EasyPopupDemo(activity: Activity,layoutId: Int = R.layout.pw_center): EasyPopup(activity,layoutId) {
      override fun setInterface() {
          contentView?.run {
              //这里可以做获取数据,设置数据的操作,点击事件,以及对话框显示前的各种设置都可以在这里
              contentView?.run {
                  tv_pw_onetitle_title.text = "你好"
              }
          }
      }
  }
  ```
  自定义布局：
  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout
      xmlns:android="http://schemas.android.com/apk/res/android"
      android:orientation="vertical" android:layout_width="match_parent"
      android:layout_height="match_parent"
      >


      <LinearLayout
          android:id="@+id/ll_pw_onetitle_outer"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layout_marginHorizontal="40dp"
          android:orientation="vertical"
          android:layout_gravity="center"
          android:background="@drawable/bg_white_fillet_10">

          <!--标题-->
          <TextView
              android:id="@+id/tv_pw_onetitle_title"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="提示"
              android:textSize="18sp"
              android:textColor="#80000000"
              android:layout_gravity="center_horizontal"
              android:gravity="center"
              android:padding="25dp"
              android:layout_marginLeft="15dp"
              android:layout_marginRight="15dp"/>

          <View
              android:layout_width="match_parent"
              android:layout_height="0.5dp"
              android:background="#90000000"
              />
          <LinearLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              >
              <TextView
                  android:id="@+id/tv_pw_onetitle_cancel"
                  android:layout_width="0dp"
                  android:layout_height="wrap_content"
                  android:layout_weight="1"
                  android:text="取消"
                  android:textSize="15sp"
                  android:textColor="#80000000"
                  android:gravity="center"
                  android:padding="15dp"
                  />

              <View
                  android:layout_width="0.5dp"
                  android:layout_height="match_parent"
                  android:background="#90000000"/>
              <TextView
                  android:id="@+id/tv_pw_onetitle_sure"
                  android:layout_width="0dp"
                  android:layout_height="wrap_content"
                  android:layout_weight="1"
                  android:text="确定"
                  android:textSize="15sp"
                  android:textColor="#80000000"
                  android:gravity="center"
                  android:padding="15dp"
                  />
          </LinearLayout>


      </LinearLayout>

  </LinearLayout>
  ```
  调用：
  ```kotlin
  //EasyPopup 使用示例
          btn_common_easy.setOnClickListener {
              EasyPopupDemo(this)
                  .setIsMask()//设置是否有阴影
                  .setIsTouchOutsideDimiss()//设置点击外部是否消失
                  .setAnimStyle()//设置动画
                  .showCenter()
          }
  ```
  <br />
  <br />
  <a name="zDXOr"></a>
  #### 3.2 底部弹出对话框效果
  ![iShot2020-08-0923.12.36.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596985995248-320f932d-ba94-4d57-8b3e-8ee41f8039a0.gif#align=left&display=inline&height=1262&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.12.36.gif&originHeight=1262&originWidth=724&size=8658022&status=done&style=none&width=724)<br />对话框代码：
  ```kotlin
  class ChoiceHeadPw(activity: Activity,layoutId: Int = R.layout.pw_choice_head): EasyPopup(activity,layoutId) {
      override fun setInterface() {
          //这里可以初始化界面,设置数据等,设置对话框宽高,动画等都可以
          contentView?.run {

              tv_pw_choice_head_cancel.setOnClickListener {
                  dismiss()
              }
              tv_pw_choice_head_camera.text = "选择相机"

          }
      }
  }
  ```
  自定义布局：
  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <RelativeLayout
      xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
      android:layout_height="match_parent">

      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:orientation="vertical"
          android:background="@drawable/bg_white_top_round_10">

          <TextView
              android:id="@+id/tv_pw_choice_head_camera"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="@string/take_camera"
              android:layout_gravity="center"
              android:layout_margin="@dimen/m10"/>

          <View
              style="@style/View_line"/>
          <TextView
              android:id="@+id/tv_pw_choice_head_album"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="@string/my_album"
              android:layout_gravity="center"
              android:layout_margin="@dimen/m10"/>
          <View
              style="@style/View_line"/>
          <TextView
              android:id="@+id/tv_pw_choice_head_cancel"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="@string/cancel"
              android:layout_gravity="center"
              android:layout_margin="@dimen/m10"/>
      </LinearLayout>



  </RelativeLayout>
  ```
  调用:
  ```kotlin
      //自定义对话框示例,随意一个对话框
          btn_common_head2.setOnClickListener {
              ChoiceHeadPw(this)
                  .showBottom()
          }
  ```
  <a name="cfCD3"></a>
  #### 3.3 内置常用对话框
  > //easypopup 封装使用,每个弹出在中间都加了渐变动画,底部有向上弹出动画,顶部下拉动画,可以自定义动画

  - 1. 一个标题，一个按钮

  ![iShot2020-08-0923.18.37.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596986350531-6c317ee0-ee09-4f9e-8808-2bfcd31efe8d.gif#align=left&display=inline&height=1256&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.18.37.gif&originHeight=1256&originWidth=710&size=7536831&status=done&style=none&width=710)<br />对话框使用示例：
  ```kotlin
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
  ```

  - 2. 一个标题，两个按钮

  ![iShot2020-08-0923.19.21.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596986402200-a7ee56fc-47c2-471b-8459-094f5daaa88b.gif#align=left&display=inline&height=1252&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.19.21.gif&originHeight=1252&originWidth=728&size=7561833&status=done&style=none&width=728)<br />使用示例：
  ```kotlin
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
  ```

  - 3. 两个标题（副标题，可以当内容），一个按钮

  ![iShot2020-08-0923.20.07.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596986436321-2a28aed4-bd3f-4f3d-bd4b-0c38d1d7d7a4.gif#align=left&display=inline&height=1266&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.20.07.gif&originHeight=1266&originWidth=710&size=5661206&status=done&style=none&width=710)<br />使用示例：
  ```kotlin
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
  ```

  - 4. 两个标题（副标题，可以当内容），两个按钮

  ![iShot2020-08-0923.20.48.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596986467242-c16119ed-ef99-4c2f-8eb1-032516714423.gif#align=left&display=inline&height=1278&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.20.48.gif&originHeight=1278&originWidth=722&size=7238111&status=done&style=none&width=722)<br />使用示例：
  ```kotlin
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
  ```

  - 5. 选择拍照和打开相册对话框

  ![iShot2020-08-0923.25.23.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596986750319-d6001a72-c14c-4117-8a36-8d84661354fc.gif#align=left&display=inline&height=1254&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.25.23.gif&originHeight=1254&originWidth=714&size=4757982&status=done&style=none&width=714)<br />使用示例：
  ```kotlin
    val xChoiceHead = XChoiceHead(this, object : XChoiceHead.Callback {
                  override fun camera(xChoiceHead: XChoiceHead) {

                  }

                  override fun album(xChoiceHead: XChoiceHead) {

                  }

              })
                  //.showBottom()
              //对标题不满意，可以通过这个方法对内容进行修改
  //            val tvCamrea = xChoiceHead.getView(R.id.tv_pw_choice_header_take) as TextView?
  //            tvCamrea?.text = "是否拍照"
              xChoiceHead.showBottom()
  ```
  <a name="F4nEf"></a>
  #### 3.4 菜单形式对话框
  > 这类对话框，原生的 PopupWindow 控制位置不是很好控制，使用原生的，显示在对应的空间下方比较容易实现，但是显示空间的上下左右的位置就有点麻烦了。

  ![iShot2020-08-0923.34.51.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596987314918-b6067f83-648e-48d6-8968-647a7823e2aa.gif#align=left&display=inline&height=1216&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.34.51.gif&originHeight=1216&originWidth=708&size=7441512&status=done&style=none&width=708)<br />对话框代码：
  ```kotlin
  class EasyMenuDemo(activity: Activity,layoutId:Int = R.layout.pw_menu2): EasyPopup(activity,layoutId) {
      override fun setInterface() {

      }
  }
  ```
  简单布局：
  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout
      xmlns:android="http://schemas.android.com/apk/res/android"
      android:orientation="vertical" android:layout_width="match_parent"
      android:layout_height="match_parent"
      >


      <LinearLayout
          android:id="@+id/ll_pw_onetitle_outer"
          android:layout_width="120dp"
          android:layout_height="wrap_content"
          android:orientation="vertical"
          android:layout_gravity="center"
          android:background="@drawable/center_pop_bg">

          <!--标题-->
          <TextView
              android:id="@+id/tv_pw_onetitle_title"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="提示"
              android:textSize="15sp"
              android:textColor="@color/black"
              android:layout_gravity="center_horizontal"
              android:gravity="center"
              android:padding="15dp"
              />

          <View
              android:layout_width="match_parent"
              android:layout_height="0.5dp"
              android:background="@color/blue0076"
              />

              <TextView
                  android:id="@+id/tv_pw_onetitle_cancel"
                  android:layout_width="match_parent"
                  android:layout_height="wrap_content"
                  android:text="取消"
                  android:textSize="15sp"
                  android:textColor="@color/black"
                  android:gravity="center"
                  android:padding="15dp"
                  />

              <View
                  android:layout_width="match_parent"
                  android:layout_height="0.5dp"
                  android:background="@color/blue0076"/>
              <TextView
                  android:id="@+id/tv_pw_onetitle_sure"
                  android:layout_width="match_parent"
                  android:layout_height="wrap_content"
                  android:text="确定"
                  android:textSize="15sp"
                  android:textColor="@color/black"
                  android:gravity="center"
                  android:padding="15dp"
                  />



      </LinearLayout>

  </LinearLayout>
  ```
  调用：
  ```kotlin
   EasyMenuDemo(this)
                  .setIsMask(true)//设置是否有阴影
                  //.setIsTouchOutsideDimiss()//设置点击外部是否消失
                  .setAnimStyle(R.style.PopDownRightMenu)//设置动画
                  .showAsDropDown(btn_common_menu)
  ```
  <a name="N0eS6"></a>
  #### 3.5 控制显示位置
  ![iShot2020-08-0923.37.58.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596987575831-ec83cb1b-f7b4-45ca-abf1-f74e559c332f.gif#align=left&display=inline&height=480&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.37.58.gif&originHeight=480&originWidth=276&size=6059042&status=done&style=none&width=276)<br />任意简单对话框：
  ```kotlin
  class GravityMenu(activity: Activity,layoutId: Int = R.layout.pw_menu2): EasyPopup(activity,layoutId) {
      override fun setInterface() {

      }
  }
  ```
  使用示例：
  ```kotlin
  GravityMenu(this)
                  .showAtAnchorView(btn_common_gravity,VerticalPosition.CENTER,HorizontalPosition.CENTER)
  ```
  调用时，第一个参数是要显示的对话框，相对位置的控件，第二个参数是垂直方向上的位置，第三个参数是水平方向上的位置，后面还有两个参数是相对 x 和 y 方向的数值，一般这几个参数随意组合就可以实现在想要的控件的 中间、上方、下方、左侧、右侧，其他更复杂的位置配合最后两个参数调整。
  <a name="DS86R"></a>
  #### 3.6 下拉对话框
  ![iShot2020-08-0923.52.57.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1596988400945-3f9a7ed7-d199-4113-9b88-7ea85fe1727d.gif#align=left&display=inline&height=480&margin=%5Bobject%20Object%5D&name=iShot2020-08-0923.52.57.gif&originHeight=480&originWidth=274&size=2022843&status=done&style=none&width=274)<br />对话框：
  ```kotlin
  class PullPw(activity: Activity, layoutId: Int = R.layout.pw_pull): EasyPopup(activity,layoutId) {
      override fun setInterface() {
          //设置宽高,默认是只使用,要修改成下面这样
          width = ViewGroup.LayoutParams.MATCH_PARENT
          height = ViewGroup.LayoutParams.MATCH_PARENT
          contentView?.run {
              ll_pw_pull_outer.setOnClickListener {
                  dismiss()
              }
              ll_pw_pull_outer2.setOnClickListener {
                  dismiss()
              }
          }

      }
  }
  ```
  布局：
  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout
      android:id="@+id/ll_pw_pull_outer"
      xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:orientation="vertical"
      android:background="#99000000">


      <LinearLayout
          android:id="@+id/ll_pw_pull_outer2"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:orientation="vertical"
          android:background="@color/white">

          <TextView
              android:layout_width="match_parent"
              android:layout_height="40dp"
              android:text="第一行"
              android:gravity="center"/>

          <TextView
              android:layout_width="match_parent"
              android:layout_height="40dp"
              android:text="第二行"
              android:gravity="center"/>

  <!--        <TextView-->
  <!--            android:layout_width="match_parent"-->
  <!--            android:layout_height="40dp"-->
  <!--            android:text="第三行"-->
  <!--            android:gravity="center"/>-->



      </LinearLayout>
  <!--    <TextView-->
  <!--        android:id="@+id/v_pw_pull_bg"-->
  <!--        android:layout_width="match_parent"-->
  <!--        android:layout_height="match_parent"-->
  <!--        android:background="#99000000"-->
  <!--        />-->


  </LinearLayout>
  ```
  调用：
  ```kotlin
  //下拉对话框
          btn_common_pull.setOnClickListener {
              PullPw(this)
                  .setAnimStyle(R.style.GrowFromTop)//设置动画
                  .setIsMask(false)//设置没有阴影
                  .setIsTouchOutsideDimiss(false)//设置点击外部不能消失
                  .showAsDropDown(btn_common_pull)//显示在这个控件的底部
          }
  ```
  <a name="QJKTM"></a>
  ## 四、Xpopup 简单使用
  > 上面实现对话框需要继承 EasyPopup,如果对话框不是很复杂的话，没有必须去新建一个类。使用 Xpopup，可以不用继承任何类，直接调用就可以实现对话框效果。内置 Xpopup 类，可以直接使用,可以用于对话框，菜单等.

  效果图：<br />![iShot2020-08-1122.26.45.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1597156653773-e3fee116-1020-4819-bd61-6573736eb97c.gif#align=left&display=inline&height=480&margin=%5Bobject%20Object%5D&name=iShot2020-08-1122.26.45.gif&originHeight=480&originWidth=282&size=4126494&status=done&style=none&width=282)<br />对话框实现：
  ```
     val xpopup = Xpopup.Builder(this, R.layout.pw_center)
                  .alpha(0.6f)//设置背景透明度
                  .isMask(true)//设置是否显示阴影
                  .isCancelable(true)//设置点击外部是否消失
                  .build()//获取Xpopup实例
              xpopup.setText(R.id.tv_pw_onetitle_title, "测试")//设置文字
                  .setOnClick(R.id.tv_pw_onetitle_cancel, View.OnClickListener {
                      xpopup.dismiss()
                  })   //设置点击事件
                  .setPopupWidth(ViewGroup.LayoutParams.WRAP_CONTENT)//设置宽度
                  .setPopupHeight(ViewGroup.LayoutParams.WRAP_CONTENT)//设置高度
                  .show()//默认渐变动画,默认显示在中间,可以在这里设置弹出位置和动画
              //.setImageResource()//设置资源图片
              //.showCenter()//弹出在中间,默认渐变动画
              //.showBottom()//底部弹出,默认上推动画
              //.showTop()//顶部弹出,默认下拉动画
  //                .setIsMask(true)//设置是否有阴影
  //                .setIsTouchOutsideDimiss(true)//设置点击外部是否消失
  //                .setBackgroundAlpha(0.5f)//设置阴影渐变度
  //                .setAnimStyle(R.style.AnimFadeCenter)//设置动画效果
              //xpopup.getView(R.id.tv_pw_onetitle_title)//通过这个方法获取对应的控件
  ```
  菜单：
  ```
   Xpopup.Builder(this, R.layout.pw_menu2)
                  .build()
                  .showAsDropDown(btn_common_xpopupMenu)
  ```
  任意位置：
  ```
       Xpopup.Builder(this, R.layout.pw_menu2)
                  .build()
                  .showAtAnchorView(
                      btn_common_xpopupAny,
                      VerticalPosition.BELOW,
                      HorizontalPosition.ALIGN_RIGHT
                  )
  ```
  <a name="igRea"></a>
  ## 五、LDialog 简单使用
  > 这个类是对常见的 Dialog 的简单封装，适用于各种居中和底部对话框，需要继承这个类使用。同时可以设置外部点击不能消失，还可以设置点击返回键不能消失。

  使用效果图：![iShot2020-08-1122.42.01.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1597156967650-0716786c-b604-4a5e-a914-a67bcb4aa75c.gif#align=left&display=inline&height=1124&margin=%5Bobject%20Object%5D&name=iShot2020-08-1122.42.01.gif&originHeight=1124&originWidth=712&size=9176238&status=done&style=none&width=712)

  - 默认样式，什么参数都不设置

  Dialog 类：
  ```
  class DefaultDialog(context: Context) : LDialog(context) {
      override fun initInterface(savedInstanceState: Bundle?) {

      }

      override fun initContentView(): Int = R.layout.pw_center
  }
  ```
  显示：
  ```
         val dialog = DefaultDialog(this)
              dialog.show()
  ```

  - 设置各类参数

  Dialog 类，详细参数都在下面的注释中：
  ```
  class OneDialog(context: Context) : LDialog(context) {
      override fun initInterface(savedInstanceState: Bundle?) {
              setWidth(ViewGroup.LayoutParams.MATCH_PARENT) //设置宽度
              .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT) //设置高度
              .setGravity(Gravity.BOTTOM) //设置显示位置
              //.setImageRes()//设置图标
              .setAnimationStyle(R.style.PushInBottom)//设置动画
              .setText(R.id.tv_pw_choice_head_camera, "测试LDialog") //设置控件文字
                  .setOnClick(R.id.tv_pw_choice_head_cancel, View.OnClickListener { //设置点击
                      dismiss()
                  })
          context
           val tvCancel = getView<TextView>(R.id.tv_pw_choice_head_cancel)// 获取控件

          //setCancelable(false)//单独设置 false ,dialog弹出后，点击屏幕或物理返回键，dialog不消失
          //setCanceledOnTouchOutside(false)// 单独设置 false ,dialog弹出后，点击屏幕dialog不消失,物理返回键消失


          setOnDismissListener { //对话框消失监听
              Log.e("MMM", ": onDismiss");
          }
      }

      override fun initContentView(): Int = R.layout.pw_choice_head
  }
  ```
  显示：
  ```
    OneDialog(this)
                  .show()
  ```
  <a name="NL8Z1"></a>
  ## 六、XDialog 简单使用
  > 这个类和 LDialog类似，只是这个类使用时不需要继承，直接使用就行。使用于展示比较简单的，交互比较少的对话框。

  效果图：<br />![iShot2020-08-1122.50.48.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1597157504513-5489d39d-e354-4f64-b260-8353ae1df92e.gif#align=left&display=inline&height=1044&margin=%5Bobject%20Object%5D&name=iShot2020-08-1122.50.48.gif&originHeight=1044&originWidth=624&size=2334534&status=done&style=none&width=624)<br />默认简单使用：
  ```
     //什么都不设置,默认居中显示,无动画效果
              XDialog.Builder(this,R.layout.pw_center)
                  .build()
                  .show()
  ```
  设置参数：
  ```
  val dialog = XDialog.Builder(this,R.layout.pw_choice_head)
                  .width(ViewGroup.LayoutParams.MATCH_PARENT)//设置宽度
                  .height(ViewGroup.LayoutParams.WRAP_CONTENT)//设置高度
                  .animationStyle(R.style.PushInBottom)//设置动画
                  .gravity(Gravity.BOTTOM)//设置位置
                  .build()
              dialog.setText(R.id.tv_pw_choice_head_camera,"不想拍照")//设置文字
                  //.setImageRes()//设置图标
                  .setOnClick(R.id.tv_pw_choice_head_cancel,View.OnClickListener { //设置点击
                      dialog.dismiss()
                  })
                  .show()
              //可以通过getView获取控件
              //dialog.getView<TextView>(R.id.tv_pw_choice_head_cancel)//
  ```
  <a name="hlEpQ"></a>
  ## 七、LDialogFg 简单使用
  > 这个是对普通的 DialogFragment 的简单封装，相对于 Dialog 和 PopupWindow，DialogFragment 的优势是生命周期和 Fragment 一样，并且在 Activity横竖屏切换时不会新建。

  效果图：<br />![iShot2020-08-1122.53.07.gif](https://cdn.nlark.com/yuque/0/2020/gif/1624725/1597157653651-c658b476-27a9-4570-b426-f97b902e86be.gif#align=left&display=inline&height=990&margin=%5Bobject%20Object%5D&name=iShot2020-08-1122.53.07.gif&originHeight=990&originWidth=616&size=3209800&status=done&style=none&width=616)<br />默认样式：
  ```
  class DefaultDialogFg: LDialogFg() {
      override fun initInterface() {

      }

      override fun initLayoutId(): Int = R.layout.pw_center
  }
  ```
  ```
   //LDialogFg使用示例
          btn_dialog_lfg.setOnClickListener {
              DefaultDialogFg().show(supportFragmentManager,"")
          }
  ```
  设置参数：
  ```
  class SetDialogFg: LDialogFg() {
      override fun initInterface() {
          setGravity(Gravity.BOTTOM)//设置位置
          setWidth(ViewGroup.LayoutParams.MATCH_PARENT)//设置宽度
          setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)//设置高度
          setmAnimationStyle(R.style.PushInBottom)//设置动画
  //        setText()//设置文字
  //        setImageRes()//设置图标
          //设置点击
  //        setOnClick(R.id.tv_pw_choice_head_cancel,View.OnClickListener {
  //            dismiss()
  //        })
          //也可以这样设置
          tv_pw_choice_head_cancel.setOnClickListener {
              dismiss()
          }
          isCancelable = false//设置点击外部是否消失(设置为false后,点击外部和返回键均不会消失)
      }

      override fun initLayoutId(): Int = R.layout.pw_choice_head
  }
  ```
  ```
  btn_dialog_lfgset.setOnClickListener {
              SetDialogFg()
                  .show(supportFragmentManager,"")
          }
  ```
  <a name="y9LZi"></a>
  ## 八、地址
  [LPopup](https://github.com/KiWiLss/LPopup)<br />参考：<br />[EasyPopup（已停止维护）](https://github.com/zyyoona7/EasyPopup)<br />[Android基于DialogFragment封装一个通用的Dialog-阿里云开发者社区](https://developer.aliyun.com/article/645531)<br />[让你的Dialog变得更简洁一点吧 - 掘金](https://juejin.im/post/6844903617061715982)<br />[变种 Builder 模式：优雅的对象构建方式_张拭心的博客 shixinzhang-CSDN博客_](https://blog.csdn.net/u011240877/article/details/53248917)<br />[弹出PopupWindow后让背景变暗的方法](https://blog.nex3z.com/2016/12/04/%E5%BC%B9%E5%87%BApopupwindow%E5%90%8E%E8%AE%A9%E8%83%8C%E6%99%AF%E5%8F%98%E6%9A%97%E7%9A%84%E6%96%B9%E6%B3%95/)<br />[【Android】在任意位置弹出PopupWindow](https://www.jianshu.com/p/6c32889e6377)<br />[Gavin-ZYX/SmartPopupWindow](https://github.com/Gavin-ZYX/SmartPopupWindow)


