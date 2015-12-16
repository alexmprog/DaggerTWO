package com.renovavision.daggertwo.ui.repository.view;

import android.content.Context;

import com.renovavision.daggertwo.models.Repository;

import java.util.List;

/**
 * Created by alexmprog on 16.12.2015.
 */
public interface RepositoryView {

    void showProgressIndicator();

    void showError(String message);

    void showRepositories(List<Repository> repositoryList);

    Context getContext();
}
