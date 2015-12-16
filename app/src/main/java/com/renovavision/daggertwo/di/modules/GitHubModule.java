package com.renovavision.daggertwo.di.modules;

import com.renovavision.daggertwo.api.GitHubApi;
import com.renovavision.daggertwo.api.GitHubApiService;
import com.renovavision.daggertwo.di.scopes.UserScope;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by alexmprog on 16.12.2015.
 */

@Module
public class GitHubModule {

    @UserScope
    @Provides
    public GitHubApi providesGitHubApi(Retrofit retrofit) {
        return new GitHubApi(retrofit);
    }
}
