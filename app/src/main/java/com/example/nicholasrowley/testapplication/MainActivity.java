package com.example.nicholasrowley.testapplication;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView myWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //second implementation

        myWebview = (WebView) findViewById(R.id.webView);
        myWebview.setWebViewClient(new CustomWebViewClient());

        myWebview.getSettings().setLoadsImagesAutomatically(true);
        myWebview.getSettings().setJavaScriptEnabled(true);
        myWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myWebview.loadUrl("https://player.vimeo.com/video/179155110?player_id=player&title=0&byline=0&portrait=0&autoplay=1&api=1");


        /*myWebview  = new WebView(this);

        myWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        myWebview.setWebViewClient(new CustomWebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        if (savedInstanceState == null)
        {
            myWebview.loadUrl("https://player.vimeo.com/video/179155110?player_id=player&title=0&byline=0&portrait=0&autoplay=1&api=1");
        }
        setContentView(myWebview);*/
    }

    public void onClickButtonTest( View v )
    {
        /*
        myWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        myWebview.loadUrl("https://player.vimeo.com/video/179155110?player_id=player&title=0&byline=0&portrait=0&autoplay=1&api=1");
        */
        /*TextView myTextView = (TextView) findViewById(R.id.textView2);
        myTextView.setText("Clicked!");*/

        switch (v.getId()) {
            case R.id.buttonTest:
                myWebview.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        myWebview.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        myWebview.restoreState(savedInstanceState);
    }


}
