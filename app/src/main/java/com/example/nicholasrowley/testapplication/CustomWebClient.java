package com.example.nicholasrowley.testapplication;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by nick- on 29/08/2016.
 */
class CustomWebViewClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        if (url != null && !url.startsWith("https://player.vimeo.com/video/") && url.startsWith("https://")) {
            view.getContext().startActivity(
                    new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            return true;
        } else {
            return false;
        }


    }
}
