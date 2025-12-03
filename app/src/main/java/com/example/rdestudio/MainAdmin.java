package com.example.rdestudio;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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



    }
}
