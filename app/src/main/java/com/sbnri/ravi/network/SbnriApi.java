package com.sbnri.ravi.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SbnriApi {

    @GET("/orgs/octokit/repos?page=1&per_page=1000")
    Call<List<DataResponse>> getData();
}
