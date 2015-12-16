package com.renovavision.daggertwo.di.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.renovavision.daggertwo.App;
import com.renovavision.daggertwo.utils.chrome.ChromeCustomTabManager;
import com.renovavision.daggertwo.utils.config.BuildConfigManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alexmprog on 16.12.2015.
 */

// provide access to App class
@Module
public class AppModule {

    App mApplication;


    public AppModule(App application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    App providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(App application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    BuildConfigManager providesBuildConfigManager() {
        return new BuildConfigManager();
    }

    @Provides
    @Singleton
    ChromeCustomTabManager providesCustomTabManager() {
        return new ChromeCustomTabManager();
    }
}
