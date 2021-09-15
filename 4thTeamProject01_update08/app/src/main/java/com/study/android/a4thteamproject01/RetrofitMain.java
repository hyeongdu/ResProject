package com.study.android.a4thteamproject01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitMain {
//    Gson gson = new GsonBuilder()
//            .setLenient()
//            .create();
    //    private Context context;
//    public RetrofitMain(Context context){
//        this.context=context;
//    }

    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("http://192.168.35.203:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    RetrofitService service1=retrofit.create(RetrofitService.class);
}
