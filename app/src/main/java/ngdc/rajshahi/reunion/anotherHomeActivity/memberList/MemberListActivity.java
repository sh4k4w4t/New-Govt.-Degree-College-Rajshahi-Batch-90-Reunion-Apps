package ngdc.rajshahi.reunion.anotherHomeActivity.memberList;

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
import ngdc.rajshahi.reunion.homeActivity.HomePage;
import ngdc.rajshahi.reunion.R;
import ngdc.rajshahi.reunion.api_Section.RetrofitApi;
import ngdc.rajshahi.reunion.api_Section.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberListActivity extends AppCompatActivity {
    RecyclerView recyclerViewId;
    ProgressDialog progressDialog;
    RetrofitInterface allInterface;
    AdapterForMemberList adapter;
    ArrayList<Model_1_for_final> dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_member_list);
        this.setTitle(getString(R.string.title_member_list));

        recyclerViewId= findViewById(R.id.recyclerViewId);
        recyclerViewId.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewId.setHasFixedSize(true);

        allInterface= RetrofitApi.getRetrofitInterface();
        loadInformation();
    }

    private void loadInformation() {
        Call<ArrayList<Model_1_for_final>> call= allInterface.memberList();
        progressDialog = new ProgressDialog(MemberListActivity.this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        call.enqueue(new Callback<ArrayList<Model_1_for_final>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Model_1_for_final>> call, @NonNull Response<ArrayList<Model_1_for_final>> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    dataSet= response.body();
                    adapter= new AdapterForMemberList(dataSet);
                    recyclerViewId.setAdapter(adapter);
                }else {
                    Toast.makeText(MemberListActivity.this,"Try again..",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Model_1_for_final>> call, @NonNull Throwable t) {
                Toast.makeText(MemberListActivity.this,"Check Internet...",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), HomePage.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomePage.class));
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.serach_menu,menu);
        MenuItem searchItem= menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }
}