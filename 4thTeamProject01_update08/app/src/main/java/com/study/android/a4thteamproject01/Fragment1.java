package com.study.android.a4thteamproject01;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.naver.maps.geometry.LatLng;
import com.squareup.picasso.Picasso;

import com.study.android.a4thteamproject01.hyungdoo.NaverMap;
import com.study.android.a4thteamproject01.hyungdoo.SirenOrder;
import com.study.android.a4thteamproject01.hyungdoo.SirenOrderResult;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment1 extends Fragment {

    private static final String TAG="lecture";
    private Context context;

    SingerAdapter adapter1;
    RestaurantVertListAdapter adapter2;
    RecyclerView mRecyclerView1;
    RecyclerView mRecyclerView2;
    RetrofitMain retroservice;

    ViewFlipper viewFlipper;

    Button button;
    int nCount;
    String latitude;
    String longtitude;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"Fragment1");
        ViewGroup rootView=(ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        context=rootView.getContext();

        adapter1=new SingerAdapter(rootView.getContext());
        adapter2=new RestaurantVertListAdapter(rootView.getContext());

        viewFlipper =  rootView.findViewById(R.id.viewFlipper);
        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        //viewFlipper.setInAnimation(showIn);
        viewFlipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);


//        Bundle bundle=getArguments();
//        latitude=bundle.getString("latitude");
//        longtitude=bundle.getString("longtitude");



        retroservice=new RetrofitMain();
        //인기맛집 리스트
        retroservice.service1.getPosts("likelist").enqueue(new Callback<JSONObjectResult>(){

            @Override
            public void onResponse(retrofit2.Call<JSONObjectResult> call, Response<JSONObjectResult> response) {
                if(response.isSuccessful()){
                    JSONObjectResult like=response.body();
                    Log.d(TAG, String.valueOf(like.likeresult));

                    for(PostResult data:like.likeresult){
//                        SingerItem item=new SingerItem(data.getR_name(), data.getGu_name(),data.getT_name(), R.drawable.cat1);
                        SingerItem item=new SingerItem(data.getM_number(),data.getR_name(), data.getGu_name(),data.getT_name(),data.getCountreview(), data.getGradeavg());
                        adapter1.addItem(item);
//                        Log.d(TAG,"postresult: "+data.getTitle()+","+data.getWriter()+","+data.getCountlike());
                    }

                    mRecyclerView1= rootView.findViewById(R.id.recyclerView1);
                    mRecyclerView1.setAdapter(adapter1);
                    mRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
                    mRecyclerView1.scrollToPosition(adapter1.getItemCount() - 1);
                    mRecyclerView1.setItemAnimator(new DefaultItemAnimator());

                }else{
                    Log.d(TAG, "onResponse-likelist:실패");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<JSONObjectResult> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }

        });
        //신상 맛집 리스트
        retroservice.service1.getPosts("recentlist").enqueue(new Callback<JSONObjectResult>(){

            @Override
            public void onResponse(retrofit2.Call<JSONObjectResult> call, Response<JSONObjectResult> response) {
                if(response.isSuccessful()){
                    JSONObjectResult order=response.body();
                    Log.d(TAG,String.valueOf(order.recentresult));
                    for(PostResult data:order.recentresult){
                        SingerItem item=new SingerItem(data.getM_number(),data.getR_name(), data.getGu_name(),data.getT_name(),data.getCountreview(), data.getGradeavg());
                        adapter2.addItem(item);
//                        Log.d(TAG,"postresult: "+data.getTitle()+","+data.getWriter()+","+data.getCountlike());
                    }

                    mRecyclerView2= rootView.findViewById(R.id.recyclerView2);
                    mRecyclerView2.setAdapter(adapter2);
                    mRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
                    mRecyclerView2.scrollToPosition(adapter2.getItemCount() - 1);
                    mRecyclerView2.setItemAnimator(new DefaultItemAnimator());

                }else{
                    Log.d(TAG, "onResponse-orderbylist:실패");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<JSONObjectResult> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }

        });

        nCount=1;
        return rootView;
    }


//    public void onMyLocatBtnClicked(View v){
//        Intent intent = new Intent(getActivity(), NaverMap.class);
//        Log.d(TAG, "버튼 클릭" + latitude + ", "+longtitude);
//        intent.putExtra("latitude",latitude);
//        intent.putExtra("longitude",longtitude);
//        startActivity(intent);
//    }

    private void requestMyLocation() {
    LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
    try {

        long minTime = 10000;
        float minDistance = 0;
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        manager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,

                minTime,
                minDistance,
                new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
//                        Log.d(TAG, "onLocationChanged111111");
                        showCurrentLocation(location);
                        manager.removeUpdates(this);
                    }

                    @Override
                    public void
                    onStatusChanged(String provider, int status, Bundle extras) {
                        Log.d(TAG, "onLocationChanged222222");
                    }

                    @Override
                    public void
                    onProviderEnabled(String provider) {
                        Log.d(TAG, "onLocationChanged33333");
                    }

                    @Override
                    public void
                    onProviderDisabled(String provider) {
                        Log.d(TAG, "onLocationChanged444444");
                    }
                }

        );

        Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (lastLocation != null) {
            this.latitude = String.valueOf(lastLocation.getLatitude());
            Log.d(TAG,"lastLocation : " + String.valueOf(lastLocation.getLatitude()));
            this.longtitude = String.valueOf(lastLocation.getLongitude());
            Log.d(TAG,"lastLocation : " + String.valueOf(lastLocation.getLongitude()));
        }

        manager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                minTime,
                minDistance,
                new LocationListener() {
                    @Override
                    public void onLocationChanged(@NonNull Location location) {
//                        Log.d(TAG, "onLocationChanged55555");
                        showCurrentLocation(location);
                        manager.removeUpdates(this);
                    }

                    @Override
                    public void
                    onStatusChanged(String provider, int status, Bundle extras) {
                        Log.d(TAG, "onLocationChanged666666");
                    }

                    @Override
                    public void
                    onProviderEnabled(String provider) {
                        Log.d(TAG, "onLocationChanged77777");
                    }

                    @Override
                    public void
                    onProviderDisabled(String provider) {
                        Log.d(TAG, "onLocationChanged88888");
                    }
                }
        );

    } catch (SecurityException e) {
        e.printStackTrace();
    }
}

    private void showCurrentLocation(Location location) {
        LatLng curPoint = new LatLng(location.getLatitude(), location.getLongitude());

        this.latitude = String.valueOf(location.getLatitude());
        this.longtitude = String.valueOf(location.getLongitude());

    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.reviewappbar, menu);
    }
}