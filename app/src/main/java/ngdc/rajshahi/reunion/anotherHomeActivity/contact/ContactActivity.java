package ngdc.rajshahi.reunion.anotherHomeActivity.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import ngdc.rajshahi.reunion.homeActivity.HomePage;
import ngdc.rajshahi.reunion.R;

public class ContactActivity extends AppCompatActivity {
    TextView textView,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_contact);

        textView= findViewById(R.id.textView);
        textView2= findViewById(R.id.textView2);
        textView3= findViewById(R.id.textView3);
        textView.setText(getResources().getString(R.string.contact_title));
        textView2.setText(getResources().getString(R.string.contact_description_1));
        textView3.setText(getResources().getString(R.string.contact_description_2));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
        super.onBackPressed();
    }
}