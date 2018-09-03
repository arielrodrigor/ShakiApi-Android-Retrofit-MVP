package sv.com.ariel.shakiapi.network;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sv.com.ariel.shakiapi.model.ShakiraMain;

/**
 * Created by DK-Ragnar on 27/8/2018.
 */

public interface ApiClient {

    @GET("1750503/raw")
    Call<ShakiraMain> getShakiApi();

}
