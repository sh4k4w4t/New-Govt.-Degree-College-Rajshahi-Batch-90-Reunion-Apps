package ngdc.rajshahi.reunion.anotherHomeActivity.socialMedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import ngdc.rajshahi.reunion.HomePage;
import ngdc.rajshahi.reunion.R;

public class SocialMediaActivity extends AppCompatActivity {
    CardView facebook, website, mail_us,meetUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_social_media);
        this.setTitle(getString(R.string.title_social_media));

        facebook= findViewById(R.id.follow_us_facebook_id);
        website= findViewById(R.id.follow_us_Website);
        mail_us= findViewById(R.id.follow_us_email);
        meetUp= findViewById(R.id.follow_us_meetUp);

        facebook.setOnClickListener(view -> {
            String full_address = getResources().getString(R.string.facbook_url);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(full_address));
            startActivity(i);
        });

        website.setOnClickListener(view -> {
            String full_address = getResources().getString(R.string.website_url);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(full_address));
            startActivity(i);
        });

        mail_us.setOnClickListener(view -> {
            Intent mailIntent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.parse(getString(R.string.mail_first_part) + getResources().getString(R.string.email));
            mailIntent.setData(data);
            startActivity(Intent.createChooser(mailIntent, getString(R.string.send_mail)));
        });

        meetUp.setOnClickListener(view -> Toast.makeText(this, R.string.still_working, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
        super.onBackPressed();
    }
}