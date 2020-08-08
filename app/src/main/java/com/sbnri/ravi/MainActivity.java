package com.sbnri.ravi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.sbnri.ravi.adapter.GitRepoAdapter;
import com.sbnri.ravi.database.AppDatabase;
import com.sbnri.ravi.database.DataRepository;
import com.sbnri.ravi.model.GitRepo;
import com.sbnri.ravi.viewmodel.GitRepoViewModel;

public class MainActivity extends AppCompatActivity {

    private GitRepoAdapter adapter = new GitRepoAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitRepoViewModel viewModel = ViewModelProviders.of(this).get(GitRepoViewModel.class);
        viewModel.initGitRepo(AppDatabase.getInstance(this).appDao());

        DataRepository dataRepository = new DataRepository(getApplication());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        LiveData<PagedList<GitRepo>> status = dataRepository.getRepo();
        status.observe(this, new Observer<PagedList<GitRepo>>() {
            @Override
            public void onChanged(PagedList<GitRepo> cases) {
                adapter.setData(cases);
                Log.e("TAG", "onChanged: Repo "+cases.size());
            }
        });
    }
}