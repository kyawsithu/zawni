package com.myanmarunicodearea.zawni;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends ActionBarActivity {

    @ViewById
    WebView mWebView;

    //@ViewById
    //EditText mTextUrl;

    Activity mActivity;

    @AfterViews
    void afterView() {
        mActivity = this;
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                mActivity.setTitle("Loading...");
                mActivity.setProgress(progress * 100);
                if (progress == 100)
                    mActivity.setTitle("");
            }
        });
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://www.google.com");
    }
}
