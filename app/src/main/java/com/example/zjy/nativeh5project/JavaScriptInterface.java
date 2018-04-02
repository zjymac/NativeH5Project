package com.example.zjy.nativeh5project;

import android.os.Handler;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * 描述：
 * 作者：zjy on 2017/12/6 17:13
 */

public class JavaScriptInterface {
    private CallBackListener callBackListener;
    private Handler handler = new Handler();

    public JavaScriptInterface(CallBackListener callBackListener) {
        this.callBackListener = callBackListener;
    }

    @JavascriptInterface
    public void clickOnAndroid() {
        Log.d("TAG", "current Thread's name:" + Thread.currentThread().getName());
        handler.post(new Runnable() {
            @Override
            public void run() {
                callBackListener.callBack();
            }
        });
    }

    public interface CallBackListener {
        void callBack();
    }
}
