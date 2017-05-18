package id.co.picklon.model.rest;

import java.util.List;

import id.co.picklon.model.entities.AD;
import id.co.picklon.model.entities.Address;
import id.co.picklon.model.entities.Article;
import id.co.picklon.model.entities.Order;
import id.co.picklon.model.entities.Response;
import id.co.picklon.model.entities.Token;
import id.co.picklon.model.entities.WashService;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface PicklonService {
    //主要地质
    String ENDPOINT = ";

    @FormUrlEncoded
    @POST("1001")
    Observable<Response<List<AD>>> getAdList(@Query("tk") String token, @Field("d") String args);

    @GET("2001")
    Observable<Response<String>> getPtk();

    @FormUrlEncoded
    @POST("2002")
    Observable<Response<Void>> getVerifyCode(@Field("d") String args);

    @FormUrlEncoded
    @POST("2003")
    Observable<Response<Token>> register(@Field("d") String args);

    @FormUrlEncoded
    @POST("2004")
    Observable<Response<Token>> login(@Field("d") String args);

 
}
