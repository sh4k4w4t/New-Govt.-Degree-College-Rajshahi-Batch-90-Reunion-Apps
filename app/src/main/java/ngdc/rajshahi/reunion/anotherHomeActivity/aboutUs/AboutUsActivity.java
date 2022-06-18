
package ngdc.rajshahi.reunion.anotherHomeActivity.aboutUs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

import ngdc.rajshahi.reunion.HomePage;
import ngdc.rajshahi.reunion.R;

public class AboutUsActivity extends AppCompatActivity {
    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about_us);
        this.setTitle(getResources().getString(R.string.about_title));

        textView= findViewById(R.id.textView);
        textView2= findViewById(R.id.textView2);
        textView.setText(getResources().getString(R.string.about_title));
        textView2.setText(getResources().getString(R.string.about_description));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
        super.onBackPressed();
    }
}