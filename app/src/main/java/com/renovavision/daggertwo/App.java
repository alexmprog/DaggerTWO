package com.renovavision.daggertwo;

import android.app.Application;

import com.renovavision.daggertwo.di.components.AppComponent;
import com.renovavision.daggertwo.di.components.DaggerAppComponent;
import com.renovavision.daggertwo.di.components.DaggerGitHubComponent;
import com.renovavision.daggertwo.di.components.DaggerNetComponent;
import com.renovavision.daggertwo.di.components.GitHubComponent;
import com.renovavision.daggertwo.di.components.NetComponent;
import com.renovavision.daggertwo.di.modules.AppModule;
import com.renovavision.daggertwo.di.modules.GitHubModule;
import com.renovavision.daggertwo.di.modules.NetModule;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class App extends Application {

    private AppComponent mAppComponent;
    private NetComponent mNetComponent;
    private GitHubComponent mGitHubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        mNetComponent = DaggerNetComponent.builder()
                .appComponent(mAppComponent)
                .netModule(new NetModule(mAppComponent.getBuildConfigManager().getGitHubBaseUrl()))
                .build();

        mGitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(mNetComponent)
                .gitHubModule(new GitHubModule())
                .build();

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public GitHubComponent getGitHubComponent() {
        return mGitHubComponent;
    }
}
