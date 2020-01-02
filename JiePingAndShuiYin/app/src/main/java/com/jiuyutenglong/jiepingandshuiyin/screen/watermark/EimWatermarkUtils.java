package com.jiuyutenglong.jiepingandshuiyin.screen.watermark;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.comtop.eim.sdk.watermark.WatermarkUtils;
import com.comtop.eim.sdk.watermark.WatermarkView;

/**
 * Copyright (C), 1999-2019, 深圳市康拓普信息技术有限公司
 * FileName: EimWatermarkUtils
 * Author: WangYaoZhong
 * Date: 2019-09-09 17:31
 * Description: 水印工具类
 */
public class EimWatermarkUtils {

    public static void registerWatermark(Application application,final String defMark){
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                WatermarkView wv = WatermarkUtils.addWatermarkView(activity);
                if (wv != null) {
                    wv.setWatermarkText(defMark);
                    wv.setWatermarkTextColor(Color.RED);
                    wv.setColorAlpha(10);
                }

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }
}
