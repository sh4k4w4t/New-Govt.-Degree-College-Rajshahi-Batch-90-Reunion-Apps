package ngdc.rajshahi.reunion.api_Section;

import java.util.ArrayList;

import ngdc.rajshahi.reunion.anotherHomeActivity.donarList.ModelForDonarList;
import ngdc.rajshahi.reunion.anotherHomeActivity.memberList.Model_1_for_final;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    //    @GET("member-list")
    @GET("member-list.json")
    Call<ArrayList<Model_1_for_final>> memberList();

    @GET("donar-list.json")
    Call<ArrayList<ModelForDonarList>> donationList();

}
