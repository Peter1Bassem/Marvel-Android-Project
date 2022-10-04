package com.peter.marvel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;

    private MyApi myAPI;


    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPI = retrofit.create(MyApi.class);
    }

    public static synchronized RetrofitClient getInstance(){

        if(instance == null){
            instance = new RetrofitClient();
        }

        return instance;

    }

    public MyApi getMyAPI(){
        return  myAPI;
    }

}

