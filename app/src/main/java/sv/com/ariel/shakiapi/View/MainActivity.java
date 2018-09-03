package sv.com.ariel.shakiapi.View;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import sv.com.ariel.shakiapi.Adapter.AlbumsAdapter;
import sv.com.ariel.shakiapi.Contract.ShakiraContract;
import sv.com.ariel.shakiapi.Presenter.ShakiraPresenter;
import sv.com.ariel.shakiapi.R;
import sv.com.ariel.shakiapi.model.Albums;
import sv.com.ariel.shakiapi.model.Shakira;

public class MainActivity extends AppCompatActivity implements ShakiraContract.view {


    ShakiraPresenter presenter;
    ProgressDialog loginProgressDialog;

    TextView nombre;
    TextView fecha;


    private RecyclerView myReclyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txtNombre);
        fecha=findViewById(R.id.txtDate);


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


        nombre.setText(shakira.getName());
        fecha.setText(shakira.getBirth());

        try{

            myReclyclerView = (RecyclerView) findViewById(R.id.rvAlbums);
            myAdapter = new AlbumsAdapter(shakira.getAlbums(), R.layout.item, new AlbumsAdapter.onItemClickListener() {
                @Override
                public void onItemClick(Albums Albums, int position) {

                    if(Albums.getSongs() != null)
                    {
                        MaterialDialog.Builder materialBuilder = new MaterialDialog.Builder(MainActivity.this);
                        materialBuilder.title("Canciones")
                                .items(Albums.getSongs())
                                .positiveText("Ok")
                                .show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "El album no tiene canciones", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            //todos los tipos de layout manager con los que se puede jugar con el recycler view
            myLayoutManager = new LinearLayoutManager(this);
            //myLayoutManager = new GridLayoutManager(this,2);
            // myLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            //solo en caso que sepamos que el tamaño del layout no va a cambiar ahrehgamos esto e incrementa el rendimiento, aunque de nada sirve con el StraggeredGridLayout porque cambia los tamaños
            myReclyclerView.setHasFixedSize(true);
            //animacion por defecto
            myReclyclerView.setItemAnimator(new DefaultItemAnimator());

            myReclyclerView.setLayoutManager(myLayoutManager);
            myReclyclerView.setAdapter(myAdapter);
        }catch(Exception e)
        {
            System.out.println("nose :" + e.getMessage());
        }



    }
}
