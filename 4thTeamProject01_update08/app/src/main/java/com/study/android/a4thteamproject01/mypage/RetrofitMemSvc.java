package com.study.android.a4thteamproject01.mypage;

import com.study.android.a4thteamproject01.ReviewListDto;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitMemSvc {

    @FormUrlEncoded
    @POST("android/join")
    Call<Integer> postJoinData(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST("android/applogin")
    Call<Integer> postLoginData(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST("checkId")
    Call<UserDto> postCheckId(@FieldMap HashMap<String,String> map);

    @GET("android/c_res_list")
    Call<JSONObjectResult2> getMyReservData(@Query("c_id") String c_id);
    @GET("android/checkReservation")
    Call<JSONObjectResult2> checkReservation(@Query("r_rsvnumber") String c_id);
    @GET("android/noCheckReservation")
    Call<JSONObjectResult2> noCheckReservation(@Query("r_rsvnumber") String c_id);

    @GET("android/my_profile_data")
    Call<JSONObjectResult2> getModifyProfile(@Query("c_id") String c_id);

    @FormUrlEncoded
    @POST("android/modify_profile")
    Call<Integer> setMyProfile(@FieldMap HashMap<String, String> map);

    @GET("android/my_review")
    Call<JSONObjectResult2> getMyReviewList(@Query("c_id") String c_id);
    @GET("android/my_siren")
    Call<JSONObjectResult2> getMySirenList(@Query("c_id") String c_id);

    @GET("android/reservationList")
    Call<JSONObjectResult2> getMyReservationList(@Query("c_id") String c_id);

}
