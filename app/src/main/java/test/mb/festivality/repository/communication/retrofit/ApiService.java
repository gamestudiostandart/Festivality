package test.mb.festivality.repository.communication.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import test.mb.festivality.utils.models.Reasponce;

public interface ApiService {

    @Headers("Content-Type: " + "application/json")
    @GET("user-list")
    Call<String> getList(@Header("X-APIClient") XAPIClient xapiClient,
                            @Header("x-header-request") XHeaderRequest xHeaderRequest);

}
