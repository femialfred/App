package com.example.femialfred.agileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AgiPedia2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agi_pedia2);
        final WebView webView = (WebView)findViewById(R.id.wbView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl("javascript:(function(){" +
                        "var head = document.getElementsByTagName('header')[0].style.display=*none*;" +
                        "})()");
            }
        });
       webView.loadUrl("https://hocvienagile.com/agipedia/tong-quan-ve-scrum/");
    }

}
