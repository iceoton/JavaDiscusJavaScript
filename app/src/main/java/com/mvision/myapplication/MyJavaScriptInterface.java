package com.mvision.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by iceoton on 6/10/2016 AD.
 */
public class MyJavaScriptInterface {
    Context mContext;

    MyJavaScriptInterface(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void openAndroidDialog() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(mContext);
        myDialog.setTitle("DANGER!");
        myDialog.setMessage("You can do what you want!");
        myDialog.setPositiveButton("ON", null);
        myDialog.show();
    }

    /*
     * The following methods have no @JavascriptInterface
     * It cannot be accessed
     */
    public void showToast2(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /*
     * The following methods not public
     * It cannot be accessed
     */
    @JavascriptInterface
    private void openAndroidDialog2() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(mContext);
        myDialog.setTitle("DANGER!");
        myDialog.setMessage("You can do what you want!");
        myDialog.setPositiveButton("ON", null);
        myDialog.show();
    }


}
