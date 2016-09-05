package com.example.nicholasrowley.testapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.android.AndroidAuthSession;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout container;
    private DropboxAPI dropboxApi;
    private boolean isUserLoggedIn;
    private Button loginBtn;
    private Button uploadFileBtn;
    private Button listFileBtn;

    private final static String DROPBOX_FILE_DIR = "/DropboxDemo/";
    private final static String DROPBOX_NAME = "dropbox_prefs";
    private final static String ACCESS_KEY = "skgr4u9wd8t0mwf";
    private final static String ACCESS_SECRET = "qr9z6y648czvexp";
    private final static AccessType ACCESS_TYPE = AccessType.DROPBOX;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.dbConnect);
        loginBtn.setOnClickListener(this);
        uploadFileBtn = (Button) findViewById(R.id.dbUploadFileBtn);
        uploadFileBtn.setOnClickListener(this);
        listFileBtn = (Button) findViewById(R.id.dbListFilesBtn);
        listFileBtn.setOnClickListener(this);

        loggedIn(false);

        AppKeyPair appKeyPair = new AppKeyPair(ACCESS_KEY, ACCESS_SECRET);
        AndroidAuthSession session;

        SharedPreferences prefs = getSharedPreferences(DROPBOX_NAME, 0);
        String key = prefs.getString(ACCESS_KEY, null);
        String secret = prefs.getString(ACCESS_SECRET, null);

        if(key != null && secret != null) {
            AccessTokenPair token = new AccessTokenPair(key, secret);
            session = new AndroidAuthSession(appKeyPair, ACCESS_TYPE, token);
        } else {
            session = new AndroidAuthSession(appKeyPair, ACCESS_TYPE);
        }

        dropboxApi = new DropboxAPI(session);
    }

    @Override
    protected void onResume() {
        super.onResume();

        AndroidAuthSession session = dropboxApi.getSession();
        if(session.authenticationSuccessful())
    }
}
