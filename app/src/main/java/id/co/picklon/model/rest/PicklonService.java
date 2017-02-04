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
    String ENDPOINT = "http://ateam.ticp.io:8190/";

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

    @FormUrlEncoded
    @POST("2005")
    Observable<Response<Object>> resetPasword(@Field("d") String args);

    @FormUrlEncoded
    @POST("2006")
    Observable<Response<Object>> changeMobile(@Query("tk") String token, @Field("d") String args);

    @FormUrlEncoded
    @POST("3002")
    Observable<Response<Order>> reqNewOrder(@Query("tk") String token, @Field("d") String args);

    @GET("3004")
    Observable<Response<List<Order>>> getOrderList(@Query("tk") String token);

    @GET("4001")
    Observable<Response<Object>> getRegion(@Query("tk") String token);

    @GET("4002")
    Observable<Response<List<Address>>> getAddressList(@Query("tk") String token);

    @FormUrlEncoded
    @POST("4003")
    Observable<Response<Object>> addAddress(@Query("tk") String token, @Field("d") String args);

    @FormUrlEncoded
    @POST("4004")
    Observable<Response<Object>> editAddress(@Query("tk") String token, @Field("d") String args);

    @FormUrlEncoded
    @POST("4005")
    Observable<Response<Object>> delAddress(@Query("tk") String token, @Field("d") String args);

    @FormUrlEncoded
    @POST("5001")
    Observable<Response<List<Article>>> getRegulation(@Field("d") String args);

    @GET("5002")
    Observable<Response<List<Article>>> getTerms(@Query("tk") String token);

    @GET("5003")
    Observable<Response<List<Object>>> getFanPage(@Query("tk") String token);

    @FormUrlEncoded
    @POST("5004")
    Observable<Response<Object>> becomePartner(@Query("tk") String token, @Field("d") String args);

    @GET("5005")
    Observable<Response<List<WashService>>> getOrderConfig(@Query("tk") String token);
}
