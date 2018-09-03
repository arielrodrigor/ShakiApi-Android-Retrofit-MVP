package sv.ub.com.guia_3_paises.Contract;

import java.util.List;

import sv.ub.com.guia_3_paises.Model.Pais;
import sv.ub.com.guia_3_paises.Model.Response;

/**
 * Created by DK-Ragnar on 27/8/2018.
 */

public interface PaisContract {

    interface View{
        void showCountries(List<Response> response);
        void showCountryInfo(Pais pais);
        void showError();


    }
    interface Presenter{
        void getCountryInfo(String country);
        void getCountries();

    }
}
