package com.sbnri.ravi.model;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.sbnri.ravi.R;

@Entity
public class GitRepo {
    @NonNull
    @PrimaryKey
    int id;
    int issue_count;
    String name, desc, repo_url, license, license_url;
    Boolean p_admin, p_pull, p_push;

    public GitRepo(int id, int issue_count, String name, String desc, String repo_url, String license, String license_url, Boolean p_admin, Boolean p_pull, Boolean p_push) {
        this.id = id;
        this.issue_count = issue_count;
        this.name = name;
        this.desc = desc;
        this.repo_url = repo_url;
        this.license = license;
        this.license_url = license_url;
        this.p_admin = p_admin;
        this.p_pull = p_pull;
        this.p_push = p_push;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssue_count() {
        return issue_count;
    }

    public void setIssue_count(int issue_count) {
        this.issue_count = issue_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRepo_url() {
        return repo_url;
    }

    public void setRepo_url(String repo_url) {
        this.repo_url = repo_url;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicense_url() {
        return license_url;
    }

    public void setLicense_url(String license_url) {
        this.license_url = license_url;
    }

    public Boolean getP_admin() {
        return p_admin;
    }

    public void setP_admin(Boolean p_admin) {
        this.p_admin = p_admin;
    }

    public Boolean getP_pull() {
        return p_pull;
    }

    public void setP_pull(Boolean p_pull) {
        this.p_pull = p_pull;
    }

    public Boolean getP_push() {
        return p_push;
    }

    public void setP_push(Boolean p_push) {
        this.p_push = p_push;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        GitRepo gitRepo = (GitRepo) obj;
        return gitRepo.getId() == this.id;
    }


    @BindingAdapter("setTint")
    public static void setData(ImageView imageView, Boolean status){
        if(status)
            imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), R.color.colorPrimaryDark), android.graphics.PorterDuff.Mode.SRC_IN);
        else
            imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);
    }
}
