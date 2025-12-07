package connect.api;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ApiVolley {

    public static void enviarActualizacion(JSONObject body, Activity context) {

        String url = "http://iscemmanuel.atwebpages.com/backend/controllers/procesar_cambios.php";

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                response -> {
                    Log.d("VOLLEY_OK", "Servidor: " + response);
                    Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                },
                error -> {
                    Log.e("VOLLEY_ERROR", "Error en la petición", error);

                    if (error.networkResponse != null) {
                        String bodyError = new String(error.networkResponse.data);
                        Log.e("SERVIDOR_DICE", bodyError);
                    }
                }
        ) {
            @Override
            public byte[] getBody() {
                return body.toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };

        queue.add(request);
    }

}
