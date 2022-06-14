package ngdc.rajshahi.reunion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    ViewFlipper viewFlipperID;
    View view1;
    ScrollView scrollView2;

    ArrayList<HomeItemGridPojo> arrayList;
    RecyclerView recyclerView;
    HomeItemAdapter homeItem_adapter;

    ViewFlipper flipper;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        viewFlipperID = findViewById(R.id.viewFlipperID);
        view1 = findViewById(R.id.view1);
        scrollView2 = findViewById(R.id.scrollView2);

        gridListData();
        recyclerView = findViewById(R.id.home_item_recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomePage.this, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        homeItem_adapter = new HomeItemAdapter(HomePage.this, arrayList);
        recyclerView.setAdapter(homeItem_adapter);

        int[] imgArray = {R.drawable.go_to_reunion_2,R.drawable.go_to_reunion_1};
        flipper = findViewById(R.id.viewFlipperID);
        for (int j : imgArray) {
            showImage(j);
        }
    }

    private void gridListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new HomeItemGridPojo("About NGDC90", R.drawable.ic_baseline_info_24));
        arrayList.add(new HomeItemGridPojo("Become a member", R.drawable.ic_baseline_card_membership_24));
        arrayList.add(new HomeItemGridPojo("Member list", R.drawable.ic_baseline_list_alt_24));
        arrayList.add(new HomeItemGridPojo("Donate", R.drawable.ic_baseline_money_24));
        arrayList.add(new HomeItemGridPojo("Gallery", R.drawable.ic_baseline_insert_photo_24));
        arrayList.add(new HomeItemGridPojo("Contact", R.drawable.ic_baseline_contact_phone_24));
    }

    public void showImage(int img) {
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setBackgroundResource(img);

        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        flipper.setOutAnimation(getApplicationContext(), android.R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}