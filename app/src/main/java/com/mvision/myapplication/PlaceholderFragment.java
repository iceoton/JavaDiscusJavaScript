package com.mvision.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by iceoton on 6/10/2016 AD.
 */
public class PlaceholderFragment extends Fragment {
    WebView myBrowser;
    EditText Msg;
    Button btnSendMsg;

    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance() {
        PlaceholderFragment fragment = new PlaceholderFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container,
                false);
        //
        myBrowser = (WebView) rootView.findViewById(R.id.mybrowser);

        final MyJavaScriptInterface myJavaScriptInterface = new MyJavaScriptInterface(getActivity());
        myBrowser.addJavascriptInterface(myJavaScriptInterface, "AndroidFunction");
        myBrowser.getSettings().setJavaScriptEnabled(true);
        myBrowser.loadUrl("file:///android_asset/mypage.html");

        Msg = (EditText) rootView.findViewById(R.id.msg);
        btnSendMsg = (Button) rootView.findViewById(R.id.sendmsg);
        btnSendMsg.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String msgToSend = Msg.getText().toString();
                myBrowser.loadUrl("javascript:callFromActivity(\"" + msgToSend + "\")");

            }
        });

        //
        return rootView;
    }
}
