package com.example.myapplication.Controller;

public class BaseManager {


    protected RestApi getRestApi()
    {
        RestApiClient restApiClient = new RestApiClient(BaseURL.URL);
        return restApiClient.getRestApi();
    }
}