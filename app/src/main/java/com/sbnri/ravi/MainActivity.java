package com.sbnri.ravi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sbnri.ravi.adapter.GitRepoAdapter;
import com.sbnri.ravi.utils.EndlessRecyclerViewScrollListener;
import com.sbnri.ravi.viewmodel.GitRepoViewModel;

public class MainActivity extends AppCompatActivity {
    private GitRepoAdapter adapter;
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GitRepoViewModel viewModel = new ViewModelProvider(this).get(GitRepoViewModel.class);
        viewModel.initGitRepo();
        adapter = new GitRepoAdapter();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        viewModel.getGitRepoLiveData().observe(this, gitRepos -> {
            adapter.updateList(gitRepos);
        });

        //Implement RecyclerView Scroll Listener to enable pagination
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                viewModel.loadMoreData((totalItemsCount/10)+1);
            }
        });
    }
}