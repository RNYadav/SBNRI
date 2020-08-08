package com.sbnri.ravi.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sbnri.ravi.model.GitRepo;

@Dao
public interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GitRepo... gitRepos);

    @Query("SELECT * FROM GitRepo")
    DataSource.Factory<Integer, GitRepo> getRepo();
}
