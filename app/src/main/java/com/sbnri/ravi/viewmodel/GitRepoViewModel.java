package com.sbnri.ravi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.sbnri.ravi.database.AppDao;
import com.sbnri.ravi.database.DataRepository;
import com.sbnri.ravi.model.GitRepo;
import com.sbnri.ravi.network.DataResponse;
import com.sbnri.ravi.network.RefreshHandler;
import com.sbnri.ravi.network.RetrofitClientInstance;
import com.sbnri.ravi.network.SbnriApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitRepoViewModel extends AndroidViewModel {
    public LiveData<PagedList<GitRepo>> gitRepoLiveData;

    public GitRepoViewModel(@NonNull Application application) {
        super(application);
    }

    public void initGitRepo(){
        gitRepoLiveData = new DataRepository(getApplication()).getRepo();
    }

    public LiveData<PagedList<GitRepo>> getGitRepoLiveData() {
        return gitRepoLiveData;
    }

    public void loadMoreData(int page) {
        SbnriApi sbnriApi = RetrofitClientInstance.getInstance(getApplication()).create(SbnriApi.class);
        sbnriApi.getData(page).enqueue(RefreshHandler.dataCallback(getApplication()));

    }
}
