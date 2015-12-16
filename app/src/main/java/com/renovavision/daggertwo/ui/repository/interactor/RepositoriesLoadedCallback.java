package com.renovavision.daggertwo.ui.repository.interactor;

import com.renovavision.daggertwo.models.Repository;

import java.util.List;

/**
 * Created by alexmprog on 16.12.2015.
 */
public interface RepositoriesLoadedCallback {

    void onSuccess(List<Repository> repositoryList);

    void onError(String error);
}
