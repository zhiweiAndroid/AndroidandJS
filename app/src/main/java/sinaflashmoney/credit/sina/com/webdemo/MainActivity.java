package sinaflashmoney.credit.sina.com.webdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView wView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        wView = (WebView) findViewById(R.id.wv);
        Button btnShowInfo = (Button) findViewById(R.id.btn_showmsg);
        //实例化js对象
        //设置参数
        wView.getSettings().setBuiltInZoomControls(false);
        //内容的渲染需要webviewChromClient去实现，设置webviewChromClient基类，解决js中alert不弹出的问题和其他内容渲染问题
        wView.setWebChromeClient(new WebChromeClient());
        wView.getSettings().setJavaScriptEnabled(true);
        //把js绑定到全局的myjs上，myjs的作用域是全局的，初始化后可随处使用
        wView.addJavascriptInterface(new JSKit(this), "myjs");

        wView.loadUrl("file:///android_asset/Button.html");

        btnShowInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        //调用 HTML 中的javaScript 函数
                        wView.loadUrl("javascript:showMsg()");
                    }
                });
            }
        });
    }


}

