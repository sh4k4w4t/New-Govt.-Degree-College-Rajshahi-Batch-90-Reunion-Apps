package ngdc.rajshahi.reunion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import ngdc.rajshahi.reunion.databinding.ActivityMainBinding;
import ngdc.rajshahi.reunion.homeActivity.HomePage;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.gifID.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),HomePage.class)));

        Handler handler = new Handler();
        handler.postDelayed(() -> startActivity(new Intent(getApplicationContext(), HomePage.class)), 5000);
    }
}