package recipe.coking.kitchen.myrecipeapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;

import recipe.coking.kitchen.myrecipeapp.Manager.ApiManager;
import recipe.coking.kitchen.myrecipeapp.Models.Recipe;
import recipe.coking.kitchen.myrecipeapp.Views.ActionBarView;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class WebViewActivity extends AppCompatActivity implements ActionBarView.onClickBackListener {

    private WebView mWebView;
    private ActionBarView actionBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView  = (WebView) findViewById(R.id.web_view);
        actionBarView = (ActionBarView) findViewById(R.id.web_action_bar);
        actionBarView.setText(getIntent().getStringExtra("RecipeName"));
        actionBarView.setmListener(this);


        final Activity activity = this;
        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                activity.setProgress(progress * 1000);
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });

        mWebView.loadUrl(getIntent().getStringExtra("Url"));

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onClickBak() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }



}
