package sn.esmt.httpclientandroid.httpconfig;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/users/login")
    public Call<UsersApiResponse> login(@Query("email") String email,@Query("password") String password);

}
