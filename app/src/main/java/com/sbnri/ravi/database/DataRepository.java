package com.sbnri.ravi.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.sbnri.ravi.model.GitRepo;

public class DataRepository {
    private AppDao appDao;

    public DataRepository(final Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        appDao = database.appDao();
    }

    public LiveData<PagedList<GitRepo>> getRepo() {
        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(10).build();
        return new LivePagedListBuilder<>(appDao.getRepo(), config).build();
    }

    public void insertData (Object... data){
        new InsertDataAsyncTask(appDao).execute(data);
    }

    private static class InsertDataAsyncTask extends AsyncTask<Object, Void, Void> {
        private AppDao appDao;

        private InsertDataAsyncTask(AppDao appDao){
            this.appDao = appDao;
        }

        @Override
        protected Void doInBackground(Object... data) {
            appDao.insert((GitRepo[]) data);
            return null;
        }
    }
}
