package sv.ub.com.guia_3_paises.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import sv.ub.com.guia_3_paises.Model.Pais;
import sv.ub.com.guia_3_paises.Model.Response;

/**
 * Created by DK-Ragnar on 27/8/2018.
 */

public interface DasApiClient {

    @FormUrlEncoded
    @POST("ServicioPaises.php")
    Call<Pais> getCountryInfo (@Field("pais")String pais);


    @FormUrlEncoded
    @POST("ServicioPaises.php")
    Call<List<Response>> getCountryies(@Field("paises")String sdf);


}
