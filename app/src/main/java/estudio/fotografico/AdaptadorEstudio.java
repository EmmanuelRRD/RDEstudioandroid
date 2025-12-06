package estudio.fotografico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rdestudio.R;

import java.util.List;


public class AdaptadorEstudio extends RecyclerView.Adapter<AdaptadorEstudio.ViewHolder> {

    private List<Estudio> lista;
    private Context context;

    // --- ESTE ES EL CONSTRUCTOR CORRECTO ---
    public AdaptadorEstudio(List<Estudio> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudio, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Estudio e = lista.get(position);
        holder.nombre.setText(e.getNombre());
        holder.direccion.setText(e.getDireccion());
        holder.encargado.setText(e.getEncargado());
    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, direccion, encargado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.text_nombre);
            direccion = itemView.findViewById(R.id.text_direccion);
        }
    }
}

