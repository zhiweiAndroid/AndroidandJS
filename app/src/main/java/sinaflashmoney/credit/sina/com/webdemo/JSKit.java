package sinaflashmoney.credit.sina.com.webdemo;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/1 0001.
 */

public class JSKit {
    private MainActivity ma;

    public JSKit(MainActivity context) {
        this.ma = context;
    }
    /**
     * 与js交互时用到的方法，在js里直接调用的
     */
    @JavascriptInterface
    public void showMsg(String msg) {
        Toast.makeText(ma, msg, Toast.LENGTH_SHORT).show();
    }

}
