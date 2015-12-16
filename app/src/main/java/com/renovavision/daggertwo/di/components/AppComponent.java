package com.renovavision.daggertwo.di.components;

import android.content.SharedPreferences;

import com.renovavision.daggertwo.App;
import com.renovavision.daggertwo.di.modules.AppModule;
import com.renovavision.daggertwo.ui.repository.presenter.RepositoryPresenterImpl;
import com.renovavision.daggertwo.utils.chrome.ChromeCustomTabManager;
import com.renovavision.daggertwo.utils.config.BuildConfigManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by alexmprog on 16.12.2015.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(RepositoryPresenterImpl repositoryPresenter);

    BuildConfigManager getBuildConfigManager();

    App getApplication();

    SharedPreferences getSharePreferences();

    ChromeCustomTabManager getChromeTabManager();
}
