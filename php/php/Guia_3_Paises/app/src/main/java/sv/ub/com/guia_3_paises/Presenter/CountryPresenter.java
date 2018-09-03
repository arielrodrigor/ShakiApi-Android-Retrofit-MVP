package sv.ub.com.guia_3_paises.Presenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.ub.com.guia_3_paises.Contract.PaisContract;
import sv.ub.com.guia_3_paises.Model.Pais;
import sv.ub.com.guia_3_paises.network.DasApiClient;
import sv.ub.com.guia_3_paises.network.DasApiProvider;

/**
 * Created by DK-Ragnar on 27/8/2018.
 */

public class CountryPresenter implements PaisContract.Presenter {


    PaisContract.View view;
    private DasApiClient client;
    public CountryPresenter(PaisContract.View view) {
        this.view = view;

        DasApiProvider provider = new DasApiProvider();

        client = provider.registerDasClient();
    }

    @Override
    public void getCountryInfo(String country) {
        client.getCountryInfo(country).enqueue(new Callback<Pais>() {
            @Override
            public void onResponse(Call<Pais> call, Response<Pais> response) {
                if(response.isSuccessful()){
                    view.showCountryInfo(response.body());
                }
            }

            @Override
            public void onFailure(Call<Pais> call, Throwable t) {
                view.showError();
            }
        });



    }

    @Override
    public void getCountries() {
        client.getCountryies("1").enqueue(new Callback<List<sv.ub.com.guia_3_paises.Model.Response>>() {
            @Override
            public void onResponse(Call<List<sv.ub.com.guia_3_paises.Model.Response>> call, Response<List<sv.ub.com.guia_3_paises.Model.Response>> response) {
                view.showCountries(response.body());
            }

            @Override
            public void onFailure(Call<List<sv.ub.com.guia_3_paises.Model.Response>> call, Throwable t) {

            }
        });
    }
}
