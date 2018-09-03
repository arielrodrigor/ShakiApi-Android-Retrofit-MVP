package sv.com.ariel.shakiapi.View;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import sv.com.ariel.shakiapi.Contract.ShakiraContract;
import sv.com.ariel.shakiapi.Presenter.ShakiraPresenter;
import sv.com.ariel.shakiapi.R;
import sv.com.ariel.shakiapi.model.Shakira;

public class MainActivity extends AppCompatActivity implements ShakiraContract.view {


    ShakiraPresenter presenter;
    ProgressDialog loginProgressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginProgressDialog  = new ProgressDialog(this);
        loginProgressDialog.setMessage("waka waka..");
        loginProgressDialog.setCancelable(false);


        presenter = new ShakiraPresenter(this);
        presenter.get();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showProfile(Shakira shakira) {
        Toast.makeText(this, shakira.getName(), Toast.LENGTH_SHORT).show();
    }
}
