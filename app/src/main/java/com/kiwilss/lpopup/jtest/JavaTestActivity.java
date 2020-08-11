package com.kiwilss.lpopup.jtest;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kiwilss.lpopup.R;
import com.kiwilss.lpopup.easy.HorizontalPosition;
import com.kiwilss.lpopup.easy.VerticalPosition;
import com.kiwilss.lpopup.x.Xpopup;

/**
 * @author : Lss Administrator
 * @FileName: JavaTestActivity
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/11
 * @desc : {DESCRIPTION}
 */
public class JavaTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javatest);

        findViewById(R.id.btn_java_xpopup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Xpopup.Builder(JavaTestActivity.this,R.layout.pw_center)
                        .build()
                        .showCenter();

            }
        });

         final View btnMenu = findViewById(R.id.btn_java_xpopupMenu);
               btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Xpopup.Builder(JavaTestActivity.this,R.layout.pw_menu)
                        .build()
                        .showAsDropDown(btnMenu);

            }
        });
         final View btnAny = findViewById(R.id.btn_java_xpopupAny);
                btnAny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Xpopup.Builder(JavaTestActivity.this,R.layout.pw_menu2)
                        .build()
                        .showAtAnchorView(btnAny, VerticalPosition.BELOW, HorizontalPosition.CENTER);

            }
        });

    }
}

