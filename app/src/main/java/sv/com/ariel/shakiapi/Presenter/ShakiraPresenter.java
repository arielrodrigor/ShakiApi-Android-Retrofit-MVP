package sv.com.ariel.shakiapi.Presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.com.ariel.shakiapi.Contract.ShakiraContract;
import sv.com.ariel.shakiapi.model.ShakiraMain;
import sv.com.ariel.shakiapi.network.ApiClient;
import sv.com.ariel.shakiapi.network.ApiProvider;

/**
 * Created by Ariel on 03/09/2018.
 */

public class ShakiraPresenter implements ShakiraContract.presenter {
    ShakiraContract.view view;


    private ApiClient client;





    public ShakiraPresenter(ShakiraContract.view view) {
        this.view = view;
        ApiProvider provider = new ApiProvider();

        client = provider.registerDasClient();
    }

    @Override
    public void get() {
        view.showLoading();
        client.getShakiApi().enqueue(new Callback<ShakiraMain>() {
            @Override
            public void onResponse(Call<ShakiraMain> call, Response<ShakiraMain> response) {
                if(response.isSuccessful())
                {
                    if(!response.body().isError())
                    {
                        view.showProfile(response.body().getShakira());

                    }
                }
                view.hideLoading();

            }

            @Override
            public void onFailure(Call<ShakiraMain> call, Throwable t) {
                view.hideLoading();

            }
        });
    }
}
