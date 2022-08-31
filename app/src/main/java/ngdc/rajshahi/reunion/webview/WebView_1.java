package ngdc.rajshahi.reunion.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.Objects;

import ngdc.rajshahi.reunion.MainActivity;
import ngdc.rajshahi.reunion.R;
import ngdc.rajshahi.reunion.anotherHomeActivity.aboutUs.AboutUsActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.becomeAmember.Become_a_member_activity;
import ngdc.rajshahi.reunion.anotherHomeActivity.donarList.DonarListActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.memberList.MemberListActivity;
import ngdc.rajshahi.reunion.databinding.ActivityWebView1Binding;
import ngdc.rajshahi.reunion.homeActivity.HomePage;
import ngdc.rajshahi.reunion.payment.PaymentActivity;

public class WebView_1 extends AppCompatActivity {
    ActivityWebView1Binding binding;
    Bundle extras;

    private ValueCallback mUploadMessage;
    public ValueCallback<Uri[]> uploadMessage;
    public static final int REQUEST_SELECT_FILE = 100;
    private final static int FILECHOOSER_RESULTCODE = 1;

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
            binding.webviewId.setWebViewClient(new WebView_1.xWebViewClient());
            binding.webviewId.loadUrl(url);
        }


        binding.webviewId.setWebViewClient(new xWebViewClient());
        binding.webviewId.setWebChromeClient(new WebChromeClient() {
            private void openFileChooser(ValueCallback uploadMsg, String acceptType) {
                mUploadMessage = uploadMsg;
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("image/*");
                startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);
            }

            public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (uploadMessage != null) {
                    uploadMessage.onReceiveValue(null);
                    uploadMessage = null;
                }

                uploadMessage = filePathCallback;

                Intent intent = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    intent = fileChooserParams.createIntent();
                }
                try {
                    startActivityForResult(intent, REQUEST_SELECT_FILE);
                } catch (ActivityNotFoundException e) {
                    uploadMessage = null;
                    return false;
                }
                return true;
            }

            //For Android 4.1 only
            private void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                mUploadMessage = uploadMsg;
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);
            }

            private void openFileChooser(ValueCallback<Uri> uploadMsg) {
                mUploadMessage = uploadMsg;
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("image/*");
                startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode == REQUEST_SELECT_FILE) {
                if (uploadMessage == null)
                    return;
                uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, intent));
                uploadMessage = null;
            }
        } else if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage)
                return;
            Uri result = intent == null || resultCode != MainActivity.RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        }
    }

    private class xWebViewClient extends android.webkit.WebViewClient {
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
            Log.e("TAG", "onPageFinished: "+url);

//            String webUrl_base="https://www.ngdcr90.org/";  //homepage activity
//            String webUrl_about="https://www.ngdcr90.org/about";  //about activity
//            String webUrl_memberList="https://www.ngdcr90.org/member-list";  //member list activity
//            String webUrl_member_register="https://www.ngdcr90.org/member-register";  //become a member activity
//            String webUrl_get_user_payment="https://www.ngdcr90.org/get-user-payment";  //payment activity
//            String webUrl_donation="https://www.ngdcr90.org/donation"; //Homepage
//            String webUrl_donation_list="https://www.ngdcr90.org/donation-list";  //donar list activity
//            String webUrl_gallery="https://www.ngdcr90.org/gallery"; //webview

            String member_store= "https://www.ngdcr90.org/member-register-store";
            String payment_store= "https://www.ngdcr90.org/user-payment/store";

            if (url.equals(member_store)){
                startActivity(new Intent(getApplicationContext(), HomePage.class));
                Toast.makeText(WebView_1.this, "Registration Success", Toast.LENGTH_LONG).show();
            }
            if (url.equals(payment_store)){
                startActivity(new Intent(getApplicationContext(), HomePage.class));
                Toast.makeText(WebView_1.this, "Payment Success", Toast.LENGTH_LONG).show();
            }
//            //redirect url only from here
//            if (url.equals(webUrl_base)){startActivity(new Intent(getApplicationContext(),HomePage.class));}
//            if (url.equals(webUrl_about)){startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));}
//            if (url.equals(webUrl_memberList)){startActivity(new Intent(getApplicationContext(), MemberListActivity.class));}
//            if (url.equals(webUrl_member_register)){startActivity(new Intent(getApplicationContext(), HomePage.class));}
//            if (url.equals(webUrl_get_user_payment)){startActivity(new Intent(getApplicationContext(), HomePage.class));}
//            if (url.equals(webUrl_donation)){startActivity(new Intent(getApplicationContext(), HomePage.class));}
//            if (url.equals(webUrl_donation_list)){startActivity(new Intent(getApplicationContext(), DonarListActivity.class));}
//            if (url.equals(webUrl_gallery)){startActivity(new Intent(getApplicationContext(), HomePage.class));}
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webviewId.canGoBack()) {
            binding.webviewId.goBack();
            return true;
        }return super.onKeyDown(keyCode, event);
    }

    public void goToWebView(String url, String title, String whereFrom, Context mainActivity, Activity targetActivity){
        Intent intent = new Intent(mainActivity, targetActivity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(getResources().getString(R.string.send_url), url);
        intent.putExtra(getResources().getString(R.string.send_title), title);
        intent.putExtra(getResources().getString(R.string.where_from), whereFrom);
        startActivity(intent);
    }
}