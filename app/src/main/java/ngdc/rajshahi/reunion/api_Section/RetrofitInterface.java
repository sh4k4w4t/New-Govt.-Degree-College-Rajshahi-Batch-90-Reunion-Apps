package ngdc.rajshahi.reunion.api_Section;

import java.util.ArrayList;

import ngdc.rajshahi.reunion.anotherHomeActivity.memberList.Model_1_for_final;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
        @GET("member-list.json")
//    @GET("member-list")
    Call<ArrayList<Model_1_for_final>> memberList();
}
