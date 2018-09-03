package sv.com.ariel.shakiapi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sv.com.ariel.shakiapi.R;
import sv.com.ariel.shakiapi.model.Albums;

/**
 * Created by Ariel on 03/09/2018.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder>{


    private List<Albums> Albumss;
    private int layout;
    private onItemClickListener listener;

    public AlbumsAdapter(List<Albums> Albumss, int layout, onItemClickListener listener) {
        this.Albumss = Albumss;
        this.layout = layout;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inlfamos el layout y le pasamos lso datos al constructor del view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //llamamos al metodo bind del viewholder pasandole el objdeto y un listener
        holder.bind(Albumss.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return Albumss.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        //Elementos UI a rellenar
        public TextView textViewAlbums;

        public ViewHolder(View v){

            //recibe la vista completa para que la rendericemos, pasamos parametros a constructor padre
            // aqui tambien manejamos los datos de logioca para extraer datos y hacer referencias con los elementoss
            super(v);
            this.textViewAlbums =(TextView) v.findViewById(R.id.textViewPoster);
        }

        public void bind(final Albums Albums, final  onItemClickListener listener){
            //procesamos los datos para renderizar
            textViewAlbums.setText(Albums.getName());
            // this.textViewAlbums.setText(Albums.getName());
            /// definimos que por cada elemento del recycler view tenemos un listener que se va a comportart de la siguiente manera
            itemView.setOnClickListener(v -> listener.onItemClick(Albums, getAdapterPosition()));

        }

    }
    ///declaramos las interfaces con los metodos a implementar
    public interface onItemClickListener{
        void onItemClick(Albums Albums, int position);
    }
}