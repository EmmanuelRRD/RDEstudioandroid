package com.example.rdestudio;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import adapters.AdaptadorEstudio;
import estudio.fotografico.Estudio;

public class MainAdmin extends AppCompatActivity {

    AdaptadorEstudio adapter;
    ArrayList<Estudio> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin);


        ImageButton agregar = findViewById(R.id.btn_agregar);
        SearchView buscador = findViewById(R.id.searchView);
        RecyclerView list = findViewById(R.id.lista_recycler);
        lista = new ArrayList<>();
        adapter = new AdaptadorEstudio(lista, this);

        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);


        cargarDatos();

        //Funcionalidad para mi boton de agregar de mientras solo muestro el dialog
        agregar.setOnClickListener(v -> {
            Dialog dialogo = new Dialog(MainAdmin.this);
            dialogo.setTitle("Nuevo Estudio");
            dialogo.setCancelable(true);
            dialogo.setContentView(R.layout.dialogo);
            dialogo.show();

            Button cancelar = dialogo.findViewById(R.id.btn_cancelar);
            cancelar.setOnClickListener(v3 -> dialogo.dismiss());
        });
    }

    private void cargarDatos() {
        String url = "http://iscemmanuel.atwebpages.com/backend/controllers/procesar_consultas.php?tabla=estudio";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        JSONArray arr = new JSONArray(response);

                        lista.clear();
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj = arr.getJSONObject(i);

                            lista.add(new Estudio(
                                    obj.getString("id_estudio"),
                                    obj.getString("nombre"),
                                    obj.getString("direccion"),
                                    obj.getString("terminos_condiciones"),
                                    obj.getString("encargado"),
                                    obj.getString("id_usuario_responsable")
                            ));
                        }

                        adapter.notifyDataSetChanged();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    error.printStackTrace();
                }
        );

        Volley.newRequestQueue(this).add(stringRequest);
    }

}
