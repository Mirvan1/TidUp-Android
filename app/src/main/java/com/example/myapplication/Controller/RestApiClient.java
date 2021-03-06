package com.example.myapplication.Controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {

    private RestApi mRestApi;

    public RestApiClient(String restApiServiceUrl) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(1, TimeUnit.SECONDS);

        OkHttpClient okHttpClient = builder.build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))

                .build();

        mRestApi = retrofit.create(RestApi.class);
    }

    public RestApi getRestApi() {
        return mRestApi;
    }
}
