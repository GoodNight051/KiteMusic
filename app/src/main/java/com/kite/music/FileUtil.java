package com.kite.music;

// 该类负责处理文件相关

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class FileUtil {
    private WebView webview;
    private Activity activity;
    private Context context;

    public FileUtil(WebView webview, Activity activity, Context context){
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
