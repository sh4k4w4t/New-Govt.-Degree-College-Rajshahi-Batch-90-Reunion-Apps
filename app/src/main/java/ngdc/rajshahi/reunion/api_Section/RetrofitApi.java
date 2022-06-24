package ngdc.rajshahi.reunion.api_Section;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    public static Retrofit api;
    public static RetrofitInterface retrofitInterface;

    public static RetrofitInterface getRetrofitInterface(){
        if (retrofitInterface==null){
            if (api==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                OkHttpClient okHttpClient= new OkHttpClient.Builder()
                        .connectTimeout(7000, TimeUnit.SECONDS)
                        .readTimeout(7000,TimeUnit.SECONDS)
                        .build();

                api= new Retrofit.Builder()
                        .baseUrl("https://www.ngdcr90.org/api/")
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            retrofitInterface= api.create(RetrofitInterface.class);
            return retrofitInterface;
        }
        return retrofitInterface;
    }

}