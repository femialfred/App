package com.example.femialfred.agileapp;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by admin on 3/15/2018.
 */

public class Tab5Events extends Fragment {

    WebView webView;

    public String fileName = "index.html";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab5events_layout, container, false);
        // init webView
        final WebView webView = (WebView) rootView.findViewById(R.id.eventWeb);
        // displaying content in WebView from html file that stored in assets folder
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.loadUrl("file:///android_asset/" + fileName);

        webView.setWebViewClient(new WebViewClient(){

            public void onPageFinished(WebView view, String url) {
                injectJavascript();
            }

        });

        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                // Column Count is just the number of 'screens' of text. Add one for partial 'screens'
                int columnCount = (int) (Math.floor(view.getHeight() / view.getWidth())+1);

                // Must be expressed as a percentage. If not set then the WebView will not stretch to give the desired effect.
                int columnWidth = columnCount * 100;
                String js = "var d = document.getElementsByTagName('body')[0];" + "d.style.WebkitColumnCount=" + columnCount + ";" + "d.style.WebkitColumnWidth='" + columnWidth + "%';";

                webView.loadUrl("javascript:(function(){" + js + "})()");
            }
        });


        return rootView;
    }

    public void injectJavascript() {
        String js = "javascript:function initialize() { " +
                "var d = document.getElementsByTagName('body')[0];" +
                "var ourH = window.innerHeight; " +
                "var ourW = window.innerWidth; " +
                "var fullH = d.offsetHeight; " +
                "var pageCount = Math.floor(fullH/ourH)+1;" +
                "var currentPage = 0; " +
                "var newW = pageCount*ourW; " +
                "d.style.height = ourH+'px';" +
                "d.style.width = newW+'px';" +
                "d.style.webkitColumnGap = '2px'; " +
                "d.style.margin = 0; " +
                "d.style.webkitColumnCount = pageCount;" +
                "}";
        webView.loadUrl(js);
        webView.loadUrl("javascript:initialize()");
    }
}
