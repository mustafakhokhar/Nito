package com.axian.nito;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class FullView extends AppCompatActivity {


    WebView webView;
    private InterstitialAd mInterstitialAd;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        InterstitialAd();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        Intent intent= getIntent();
        String url = intent.getStringExtra("url");

        webView=(WebView) findViewById ( R.id.webview );
        WebSettings webSettings=webView.getSettings ();
        webSettings.setJavaScriptEnabled ( true );


        webView.loadUrl ( url );









    }

    void InterstitialAd()
    {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
