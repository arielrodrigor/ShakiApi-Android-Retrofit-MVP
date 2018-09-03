package sv.com.ariel.shakiapi.Contract;

import sv.com.ariel.shakiapi.model.Shakira;

/**
 * Created by Ariel on 03/09/2018.
 */

public interface ShakiraContract {
    interface  view{
        void showLoading();
        void hideLoading();
        void showProfile(Shakira shakira);
    }
    interface presenter{
        void get();
    }
}
