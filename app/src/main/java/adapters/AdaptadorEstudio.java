package adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rdestudio.R;

import java.util.List;

import estudio.fotografico.Estudio;


public class AdaptadorEstudio extends RecyclerView.Adapter<AdaptadorEstudio.ViewHolder> {

    private List<Estudio> lista;
    private Activity context;

    // --- ESTE ES EL CONSTRUCTOR CORRECTO ---
    public AdaptadorEstudio(List<Estudio> lista, Activity context) {
        this.lista = lista;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, direccion;
        ImageView editar, eliminar;

        public ViewHolder(View v) {
            super(v);
            nombre = v.findViewById(R.id.text_nombre);
            direccion = v.findViewById(R.id.text_direccion);

            editar = v.findViewById(R.id.btn_editar);
            eliminar = v.findViewById(R.id.btn_eliminar);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estudio, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int position) {
        Estudio estudio = lista.get(position);
        h.nombre.setText(estudio.getNombre());
        h.direccion.setText(estudio.getDireccion());

        h.editar.setOnClickListener(v -> {
            int pos = h.getAdapterPosition();

            if (pos != RecyclerView.NO_POSITION) {

                //Gialog de agregar
                Dialog dialogo = new Dialog(context);
                dialogo.setTitle("Editar registro");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.dialogo);
                dialogo.show();

                EditText identificador = dialogo.findViewById(R.id.caja_idestudio);
                EditText nombre = dialogo.findViewById(R.id.caja_nombre);
                EditText direccion = dialogo.findViewById(R.id.caja_direccion);
                EditText servicio = dialogo.findViewById(R.id.caja_descripcion);
                EditText encargado = dialogo.findViewById(R.id.encargado);
                EditText jefe = dialogo.findViewById(R.id.caja_usuario_responsable);

                Button guardar = dialogo.findViewById(R.id.btn_add);
                guardar.setText("Guardar");

                identificador.setKeyListener(null);

                Button cancelar = dialogo.findViewById(R.id.btn_cancelar);

                Estudio e = lista.get(pos);

                e = lista.get(pos);

                //identificador.setText();
                identificador.setText(e.getId_estudio());
                nombre.setText(e.getNombre());
                direccion.setText(e.getDireccion());
                servicio.setText(e.getTerminos());
                encargado.setText(e.getEncargado());
                jefe.setText(e.getId_usuario_responsable());

                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            //Vamos a pasar como parametros lo recopilado del dialogo.xml
                            int pos = h.getAdapterPosition();

                            if (pos != RecyclerView.NO_POSITION) {
                                Estudio e = lista.get(pos);

                                e = new Estudio(
                                        identificador.getText().toString(),
                                        nombre.getText().toString(),
                                        direccion.getText().toString(),
                                        servicio.getText().toString(),
                                        encargado.getText().toString(),
                                        jefe.getText().toString()
                                );

                                //dao.editar(context);

                                // Actualiza la lista y refresca solo esa fila
                                //lista.set(pos, c);
                                notifyItemChanged(pos);

                                dialogo.dismiss();


                            }

                        }catch (Exception e){
                            Toast.makeText(context.getApplication(),"Error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogo.dismiss();
                    }
                });

            }



        });

        h.eliminar.setOnClickListener(v -> {
            int pos = h.getAdapterPosition();

            if (pos != RecyclerView.NO_POSITION) {

                Estudio c = lista.get(pos);

                AlertDialog.Builder del = new AlertDialog.Builder(a);
                del.setMessage("¿Seguro que desea eliminar este registro?");
                del.setPositiveButton("Sí", (dialog, which) -> {

                    dao.eliminar(c.getIdCliente());

                    lista.remove(pos);

                    notifyItemRemoved(pos);
                    notifyItemRangeChanged(pos, lista.size());

                });
                del.setNegativeButton("No", null);
                del.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }
}
