package connect.api;

import android.app.Activity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import login.RespuestaLogin;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("backend/controllers/validar_usuario.php")
    Call<RespuestaLogin> login(
            @Field("email") String email,
            @Field("password") String password
    );

    private void enviarActualizacion(JSONObject body, Activity context) {

        String url = "http://iscemmanuel.atwebpages.com/backend/controllers/procesar_cambios.php";

        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                body,
                response -> {
                    Toast.makeText(context, "Actualización exitosa", Toast.LENGTH_SHORT).show();
                },
                error -> {
                    Toast.makeText(context, "Error de servidor: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
        );

        queue.add(request);
    }

}