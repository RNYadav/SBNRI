package com.sbnri.ravi.network;


import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.sbnri.ravi.database.DataRepository;
import com.sbnri.ravi.model.GitRepo;

import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;;

public class RefreshHandler {
    public static void refreshDatabase(Application application) {
        refreshData(application);
    }

    private static void refreshData(Application application) {
        SbnriApi api = RetrofitClientInstance.getInstance(application).create(SbnriApi.class);
        Call<List<DataResponse>> call = api.getData();
        call.enqueue(dataCallback(application));

    }

    public static Callback<List<DataResponse>> dataCallback( Application application){

        DataRepository dataRepository = new DataRepository(application);
        return new Callback<List<DataResponse>>() {
            @Override
            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {
                Log.e("TAG", "onResponse: "+ response.toString());
                List<DataResponse> dataResponse = response.body();
                GitRepo[] gitRepos = new GitRepo[dataResponse.size()];
                // ArrayList to Array Conversion
                for (int i = 0; i < dataResponse.size(); i++) {
                    DataResponse item = dataResponse.get(i);
                    Log.e("TAG", "onResponse: "+item);
                    // Assign each value to String array
                    gitRepos[i] = new GitRepo(item.getId(), item.getOpenIssuesCount(),item.getName(),
                            item.getDescription(), item.getHtmlUrl(), item.getLicense()!=null?item.getLicense().getName():"",
                            item.getLicense()!=null?item.getLicense().getUrl():"", item.getPermissions().getAdmin(),
                            item.getPermissions().getPull(), item.getPermissions().getPush());
                }
                dataRepository.insertData(gitRepos);
            }

            @Override
            public void onFailure(Call<List<DataResponse>> call, Throwable t) {
                Toast.makeText(application, "Problem Loading Data", Toast.LENGTH_SHORT).show();
                Log.e("TAG", "onFailure: ", t);

            }

        };
    }
}