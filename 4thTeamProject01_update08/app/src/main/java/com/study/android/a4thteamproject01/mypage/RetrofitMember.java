package com.study.android.a4thteamproject01.mypage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMember {

    Retrofit mRetrofit=new Retrofit.Builder()
            .baseUrl("http://192.168.35.203:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RetrofitMemSvc mService = mRetrofit.create(RetrofitMemSvc.class);
}
