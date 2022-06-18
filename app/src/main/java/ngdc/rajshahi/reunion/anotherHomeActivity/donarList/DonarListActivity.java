package ngdc.rajshahi.reunion.anotherHomeActivity.donarList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;
import ngdc.rajshahi.reunion.HomePage;
import ngdc.rajshahi.reunion.R;
import ngdc.rajshahi.reunion.api_Section.RetrofitApi;
import ngdc.rajshahi.reunion.api_Section.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonarListActivity extends AppCompatActivity {
    RecyclerView recyclerViewId;
    ProgressDialog progressDialog;
    RetrofitInterface allInterface;
    AdapterForDonationList adapter;
    ArrayList<ModelForDonarList> dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_donar_list);
        this.setTitle("Donation List");

        recyclerViewId = findViewById(R.id.recyclerViewIdForDonateList);
        recyclerViewId.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewId.setHasFixedSize(true);

        allInterface= RetrofitApi.getRetrofitInterface();
        loadInformation();
    }

    private void loadInformation() {
        Call<ArrayList<ModelForDonarList>> call= allInterface.donationList();
        progressDialog = new ProgressDialog(DonarListActivity.this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        call.enqueue(new Callback<ArrayList<ModelForDonarList>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ModelForDonarList>> call, @NonNull Response<ArrayList<ModelForDonarList>> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    dataSet= response.body();
                    adapter= new AdapterForDonationList(dataSet);
                    recyclerViewId.setAdapter(adapter);
                }else {
                    Toast.makeText(DonarListActivity.this,"Try again..",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ModelForDonarList>> call, @NonNull Throwable t) {
                Toast.makeText(DonarListActivity.this,"Check Internet...",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
        super.onBackPressed();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater= getMenuInflater();
//        inflater.inflate(R.menu.serach_menu,menu);
//        MenuItem searchItem= menu.findItem(R.id.action_search);
//        SearchView searchView=(SearchView) searchItem.getActionView();
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String s) {
//                adapter.getFilter().filter(s);
//                return false;
//            }
//        });
//        return true;
//    }
}