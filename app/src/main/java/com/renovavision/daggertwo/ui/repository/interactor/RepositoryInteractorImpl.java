package com.renovavision.daggertwo.ui.repository.interactor;

import com.renovavision.daggertwo.App;
import com.renovavision.daggertwo.api.GitHubApi;
import com.renovavision.daggertwo.models.Repository;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class RepositoryInteractorImpl implements RepositoryInteractor {

    @Inject
    GitHubApi mGitHubApi;

    private WeakReference<RepositoriesLoadedCallback> mLoadedCallback;

    public RepositoryInteractorImpl(App app, RepositoriesLoadedCallback repositoriesLoadedCallback) {
        app.getGitHubComponent().inject(this);
        this.mLoadedCallback = new WeakReference<>(repositoriesLoadedCallback);
    }

    @Override
    public void loadRepositories(int sinceId) {
        mGitHubApi.getRepositories(sinceId, new GitHubApi.ResponseCallback<List<Repository>>() {

            @Override
            public void onSuccess(List<Repository> data) {
                RepositoriesLoadedCallback repositoriesLoadedCallback = mLoadedCallback.get();
                if (repositoriesLoadedCallback == null) {
                    return;
                }

                repositoriesLoadedCallback.onSuccess(data);
            }

            @Override
            public void onError(Throwable throwable) {
                RepositoriesLoadedCallback repositoriesLoadedCallback = mLoadedCallback.get();
                if (repositoriesLoadedCallback == null) {
                    return;
                }

                repositoriesLoadedCallback.onError(throwable.getMessage());
            }
        });
    }
}
