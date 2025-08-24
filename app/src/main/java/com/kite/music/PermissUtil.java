package com.kite.music;

// 该类负责处理权限相关

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissUtil {
    private WebView webview;
    private Activity activity;
    private Context context;

    public PermissUtil(WebView webview, Activity activity, Context context){
        this.webview = webview;
        this.activity = activity;
        this.context = context;
    }

    // 是否获取了某项权限
    // @name hasPermission()
    // @param String permission
    // @return boolean
    @JavascriptInterface
    public boolean hasPermission(String permission){
        return ContextCompat.checkSelfPermission(this.context,permission) == PackageManager.PERMISSION_GRANTED;
    }

    // 申请某项权限
    // @name requestPermission()
    // @param String permission
    // @return void
    @JavascriptInterface
    public void requestPermission(String permission){
        if(hasPermission(permission)){
            // 已获取权限则不处理
            return;
        }
        // 动态申请
        ActivityCompat.requestPermissions(this.activity,new String[]{permission},0);
    }

    // 获取当前设备的版本号
    // @name getAndroidVersion()
    // @param void
    // @return int
    private int getVersionFromSdkInt(int sdkInt) {
        // 这是一个简化的映射表，可以根据需要扩展
        if (sdkInt >= Build.VERSION_CODES.R) {
            return 11; // Android 11及以上
        } else if (sdkInt >= Build.VERSION_CODES.Q) {
            return 10; // Android 10
        } else if (sdkInt >= Build.VERSION_CODES.P) {
            return 9;  // Android 9 (Pie)
        } else if (sdkInt >= Build.VERSION_CODES.O) {
            return 8;  // Android 8 (Oreo)
        } else if (sdkInt >= Build.VERSION_CODES.N) {
            return 7;  // Android 7 (Nougat)
        } else if (sdkInt >= Build.VERSION_CODES.M) {
            return 6;  // Android 6 (Marshmallow)
        } else if (sdkInt >= Build.VERSION_CODES.LOLLIPOP) {
            return 5;  // Android 5 (Lollipop)
        }
        return -999; // 未知版本
    }
    @JavascriptInterface
    public int getAndroidVersion() {
        String release = Build.VERSION.RELEASE;
        try {
            // 尝试解析RELEASE字符串中的第一个数字
            if (release != null && release.length() != 0) {
                String[] parts = release.split("\\.");
                return Integer.parseInt(parts[0]);
            }
        } catch (NumberFormatException e) {
            // 如果解析失败，则使用SDK_INT进行映射
            return getVersionFromSdkInt(Build.VERSION.SDK_INT);
        }
        // 否则返回无效
        return -999;
    }

    // 测试
    @JavascriptInterface
    public boolean test(){
        return true;
    }
}
