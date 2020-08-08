package com.sbnri.ravi.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;

import com.sbnri.ravi.BR;
import com.sbnri.ravi.R;
import com.sbnri.ravi.databinding.RowGitrepoBinding;
import com.sbnri.ravi.model.GitRepo;

import java.util.List;

public class GitRepoAdapter extends RecyclerView.Adapter<GitRepoAdapter.GitRepoViewHolder> {

    private List<GitRepo> list;

    public GitRepoAdapter(PagedList<GitRepo> gitRepos) {
        this.list = gitRepos;
    }

    @NonNull
    @Override
    public GitRepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowGitrepoBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_gitrepo, parent, false);
        return new GitRepoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GitRepoViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GitRepoViewHolder extends RecyclerView.ViewHolder {
        public RowGitrepoBinding itemRowBinding;

        public GitRepoViewHolder(RowGitrepoBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }
    }
}
