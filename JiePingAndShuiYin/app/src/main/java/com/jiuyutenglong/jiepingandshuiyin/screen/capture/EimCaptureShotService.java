package com.jiuyutenglong.jiepingandshuiyin.screen.capture;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.comtop.eim.sdk.captureshot.PictureFileObserver;

/**
 * Copyright (C), 1999-2019, 深圳市康拓普信息技术有限公司
 * FileName: EimCaptureShotService
 * Author: WangYaoZhong
 * Date: 2019-09-09 17:23
 * Description: 监听用户截屏的服务
 */
public class EimCaptureShotService extends Service {
    /**
     * 图片监听器
     */
    private PictureFileObserver mPictureFileObserver;

    @Override
    public void onCreate() {
        super.onCreate();
        mPictureFileObserver = new PictureFileObserver(this);
        mPictureFileObserver.registerObserver();
        mPictureFileObserver.setWatermarkTxt("这是水印，机密资料，严禁外泄");
        mPictureFileObserver.setWatermarkColor(Color.RED, 0);
        mPictureFileObserver.setMode(PictureFileObserver.MODE_ADD_WATERMARK);

        startObserver();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 开始监听
     */
    public void startObserver() {
        if (mPictureFileObserver != null) {
            mPictureFileObserver.startObserver();
        }
    }

    /**
     * 暂停监听
     */
    public void stopObserver() {
        if (mPictureFileObserver != null) {
            mPictureFileObserver.stopObserver();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPictureFileObserver != null) {
            mPictureFileObserver.unregisterObserver();
            mPictureFileObserver = null;
        }

        stopObserver();
    }
}
