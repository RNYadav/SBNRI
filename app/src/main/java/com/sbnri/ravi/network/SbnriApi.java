package com.sbnri.ravi.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SbnriApi {

    @GET("/orgs/octokit/repos?page=1&per_page=10")
    Call<List<DataResponse>> getData();


    @GET("/orgs/octokit/repos?&per_page=10")
    Call<List<DataResponse>> getData(@Query("page")int number);
}
