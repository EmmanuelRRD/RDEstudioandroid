package com.example.rdestudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import connect.api.ApiService;
import login.RespuestaLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);//es el login en si es lo primerito que vez
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void loginUsuario(View v){
        EditText cajaCorreo = findViewById(R.id.caja_correo);
        EditText cajaPassword = findViewById(R.id.caja_password);

        String correo = cajaCorreo.getText().toString().trim();
        String password = cajaPassword.getText().toString().trim();

        if(correo.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService api = RetrofitClient
                .getClient("http://iscemmanuel.atwebpages.com/") // Aqui inicio el RetrofitClient
                .create(ApiService.class);

        Call<RespuestaLogin> call = api.login(correo, password);

        call.enqueue(new Callback<RespuestaLogin>() {
            @Override
            public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {

                if(response.isSuccessful() && response.body() != null){
                    RespuestaLogin data = response.body();

                    if (data.getStatus().equals("ok")) {
                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                        // si redirect == "admin"
                        if(data.getRedirect().equals("admin")) {//aqui saca el redirect respuesta api y verifica el tipo usuario
                            //Para agegar mas logins de varios usuarios
                            startActivity(new Intent(MainActivity.this, MainAdmin.class));
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                //Log.e("API_ERROR", "Error en conexión", t);
                Toast.makeText(MainActivity.this, "Error en conexión", Toast.LENGTH_LONG).show();
            }

        });
    }

    public void mostrarActivityLogin(View v){
        Intent admin = new Intent(this, MainCrearCuenta.class);
        startActivity(admin);
    }

}