package ngdc.rajshahi.reunion.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.Objects;

import ngdc.rajshahi.reunion.R;
import ngdc.rajshahi.reunion.databinding.ActivityWebView1Binding;

public class WebView_1 extends AppCompatActivity {
    ActivityWebView1Binding binding;
    Bundle extras;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding=ActivityWebView1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        extras = getIntent().getExtras();

        if (extras != null) {
            String url = extras.getString(getResources().getString(R.string.send_url));
            String title = extras.getString(getResources().getString(R.string.send_title));
            this.setTitle(title);

            binding.webviewId.getSettings().setDomStorageEnabled(true);
            binding.webviewId.getSettings().setJavaScriptEnabled(true);
            binding.webviewId.setWebChromeClient(new WebChromeClient());
            binding.webviewId.setWebViewClient(new WebView_1.WebViewClient());
            binding.webviewId.loadUrl(url);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
//            goToBackPage();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
//        goToBackPage();
        super.onBackPressed();
    }

//    public void goToBackPage(){
//        extras = getIntent().getExtras();
//        if (extras != null) {
//            String whereFrom = extras.getString(getResources().getString(R.string.where_from));
//            if (whereFrom.equals(getResources().getString(R.string.from_LoginPage))){
//                startActivity(new Intent(getApplicationContext(), LoginPage.class));
//            }
//            if (whereFrom.equals(getResources().getString(R.string.from_HomePage))){
//                startActivity(new Intent(getApplicationContext(), HomePage.class));
//            }
//            if (whereFrom.equals(getResources().getString(R.string.from_UserSelectionForRegistration))){
//                startActivity(new Intent(getApplicationContext(), UserSelectionForRegistration.class));
//            }
//        }
//    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            binding.progressBar.setVisibility(View.GONE);

//            String baseAddress= getResources().getString(R.string.webView_baseURL);
//            if (url.equals(baseAddress) || url.equals(agentLogIn)){
//                SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.store_user_information), Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.clear();
//                editor.apply();
//                startActivity(new Intent(OnlyWebView.this,LoginPage.class));
//            }
        }
    }
}