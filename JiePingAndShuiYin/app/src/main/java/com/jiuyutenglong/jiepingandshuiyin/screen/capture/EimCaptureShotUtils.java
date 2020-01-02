package com.jiuyutenglong.jiepingandshuiyin.screen.capture;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.comtop.eim.sdk.captureshot.CaptureShotUtils;

/**
 * Copyright (C), 1999-2019, 深圳市康拓普信息技术有限公司
 * FileName: EimCaptureShotUtils
 * Author: WangYaoZhong
 * Date: 2019-09-09 17:21
 * Description: 防截屏工具类
 */
public class EimCaptureShotUtils {
    /**
     * 开启防止截屏
     * @param application
     */
    public static void openCaptureShot(Application application){
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                // 防截屏
                CaptureShotUtils.forbiddenCaptureShot(activity);
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

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
