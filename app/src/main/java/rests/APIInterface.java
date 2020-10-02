package rests;

import model.ResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface APIInterface {
    @GET("top-headlines")
    Call<ResponseModel> getLatestNews(@Query("q") String source, @Query("language") String language, @Query("country") String country, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);
}
//hi
//its adi pull request
