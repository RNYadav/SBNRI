package com.sbnri.ravi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.sbnri.ravi.database.AppDao;
import com.sbnri.ravi.model.GitRepo;

public class GitRepoViewModel extends AndroidViewModel {
    public LiveData<PagedList<GitRepo>> gitRepoLiveData;

    public GitRepoViewModel(@NonNull Application application) {
        super(application);
    }

    public void initGitRepo(AppDao appDao){
        PagedList.Config config = (new PagedList.Config.Builder()).setPageSize(10).build();
        gitRepoLiveData = new LivePagedListBuilder<>(appDao.getRepo(),config).build();
    }

    public LiveData<PagedList<GitRepo>> getGitRepoLiveData() {
        return gitRepoLiveData;
    }
}
