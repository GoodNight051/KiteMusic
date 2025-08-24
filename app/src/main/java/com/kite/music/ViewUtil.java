package com.kite.music;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class ViewUtil {
    private WebView webview;
    private Activity activity;
    private Context context;

    public ViewUtil(WebView webview, Activity activity, Context context){
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
