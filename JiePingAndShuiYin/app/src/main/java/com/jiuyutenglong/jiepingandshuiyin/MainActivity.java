package com.jiuyutenglong.jiepingandshuiyin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.comtop.eim.sdk.captureshot.CaptureShotUtils;
import com.comtop.eim.sdk.watermark.WatermarkUtils;
import com.comtop.eim.sdk.watermark.WatermarkView;
import com.jiuyutenglong.jiepingandshuiyin.screen.capture.EimCaptureShotUtils;
import com.jiuyutenglong.jiepingandshuiyin.screen.watermark.EimWatermarkUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.txt_jieping).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //防截屏
                EimCaptureShotUtils.openCaptureShot(MainActivity.this.getApplication());

                //防截屏
                CaptureShotUtils.forbiddenCaptureShot(MainActivity.this);
                Toast.makeText(MainActivity.this, "开启成功", Toast.LENGTH_SHORT).show();

            }
        });
        findViewById(R.id.txt_shuiyin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //水印工具
                //水印工具
                EimWatermarkUtils.registerWatermark(getApplication(),"移动应用平台");
                //水印工具
                WatermarkView wv = WatermarkUtils.addWatermarkView(MainActivity.this);
                if (wv != null) {
                    wv.setWatermarkText("移动应用平台");
                    wv.setWatermarkTextColor(Color.RED);
                    wv.setColorAlpha(10);
                    Toast.makeText(MainActivity.this, "开启成功", Toast.LENGTH_SHORT).show();

                }
            }
        });

        findViewById(R.id.txt_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FristActivity.class);
                startActivity(intent);

            }
        });
    }
}
