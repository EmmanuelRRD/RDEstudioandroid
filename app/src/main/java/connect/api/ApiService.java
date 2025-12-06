package connect.api;

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
}