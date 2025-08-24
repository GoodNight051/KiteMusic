package com.kite.music;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webview;
    private Activity activity;
    private Context context;

    // 应用核心被创建时
    @Override
    protected void onCreate(Bundle savedInstanceState){

        // 初始化基本项
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        context = getApplicationContext();
        webview = findViewById(R.id.webview);
        PermissUtil PU = new PermissUtil(this.webview,this.activity,this.context);
        FileUtil FU = new FileUtil(this.webview,this.activity,this.context);
        JavaUtil JU = new JavaUtil(this.webview,this.activity,this.context);
        NetUtil NU = new NetUtil(this.webview,this.activity,this.context);
        ViewUtil VU = new ViewUtil(this.webview,this.activity,this.context);

        // 对应用进行初始化
        if(PU.getAndroidVersion() < 8){
            //证明是不受支持的版本
            this.activity.finish();
            Process.killProcess(Process.myPid());
        };

        // 配置webview
        WebSettings settings = webview.getSettings();
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
                String url = request.getUrl().toString();
                view.loadUrl(url);
                return true;
            }
        });
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setLoadsImagesAutomatically(true);

        // java接口接入
        webview.addJavascriptInterface(JU,"JavaUtil");
        webview.addJavascriptInterface(FU,"FileUtil");
        webview.addJavascriptInterface(NU,"NetUtil");
        webview.addJavascriptInterface(PU,"PermissUtil");
        webview.addJavascriptInterface(VU,"ViewUtil");

        // 加载网页
        webview.loadUrl("file:///android_asset/index.html");
    }

    // 应用活动被卸载时
    @Override
    public void onDestroy(){
        super.onDestroy();
        webview.destroy();
    }
}
