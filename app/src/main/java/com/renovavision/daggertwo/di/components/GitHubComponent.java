package com.renovavision.daggertwo.di.components;

import com.renovavision.daggertwo.api.GitHubApi;
import com.renovavision.daggertwo.di.modules.GitHubModule;
import com.renovavision.daggertwo.di.scopes.UserScope;
import com.renovavision.daggertwo.ui.repository.interactor.RepositoryInteractorImpl;

import dagger.Component;

/**
 * Created by alexmprog on 16.12.2015.
 */

@UserScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(RepositoryInteractorImpl repositoryInteractor);

    GitHubApi getGitHubApi();
}
