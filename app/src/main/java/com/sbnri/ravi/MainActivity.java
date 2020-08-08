package com.sbnri.ravi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sbnri.ravi.adapter.GitRepoAdapter;
import com.sbnri.ravi.database.AppDatabase;
import com.sbnri.ravi.viewmodel.GitRepoViewModel;

public class MainActivity extends AppCompatActivity {
    private GitRepoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GitRepoViewModel viewModel = new ViewModelProvider(this).get(GitRepoViewModel.class);
        viewModel.initGitRepo(AppDatabase.getInstance(this).appDao());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        viewModel.getGitRepoLiveData().observe(this, gitRepos -> {
            adapter = new GitRepoAdapter(gitRepos);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(adapter);
        });
    }
}