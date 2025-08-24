package com.kite.music;

// 该类负责处理通用功能相关

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class JavaUtil{
    private WebView webview;
    private Activity activity;
    private Context context;

    public JavaUtil(WebView webview, Activity activity, Context context){
        this.webview = webview;
        this.activity = activity;
        this.context = context;
    }

    // 测试
    @JavascriptInterface
    public boolean test(){
        return true;
    }
}
