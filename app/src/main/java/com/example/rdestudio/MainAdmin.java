package com.example.rdestudio;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import estudio.fotografico.Estudio;

public class MainAdmin extends AppCompatActivity {

    //daoCliente dao;
    //Adaptador adapter;
    ArrayList<Estudio> lista;
    //cliente c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin);

        RecyclerView list = findViewById(R.id.lista_recycler);
        ImageButton agregar = findViewById(R.id.btn_agregar);
        SearchView buscador = findViewById(R.id.searchView);

        agregar.setOnClickListener(v -> {
            Dialog dialogo = new Dialog(MainAdmin.this);
            dialogo.setTitle("Nuevo Cliente");
            dialogo.setCancelable(true);
            dialogo.setContentView(R.layout.dialogo);
            dialogo.show();

            Button cancelar = dialogo.findViewById(R.id.btn_cancelar);

            cancelar.setOnClickListener(v3 -> dialogo.dismiss());

        });

    }
}
