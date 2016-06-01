package com.example.hirokikirigaya.alchoholcolculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by mds014005 on 2016/06/01.
 */
public class WebViewContents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //表示する画面の指定
        setContentView(R.layout.activity_webcontents);

        //URLの文字列を受け取る
        Intent getIntent = getIntent();
        String strUrl = getIntent.getStringExtra("URL");

        //WebViewのインスタンス取得
        WebView webView = (WebView)findViewById(R.id.WebView);

        //標準のブラウザを使用しない
        webView.setWebViewClient(new WebViewClient());

        //JavaScriptを有効にする
        webView.getSettings().setJavaScriptEnabled(true);

        //Googleのページを表示する
        webView.loadUrl(strUrl);

    }
}
