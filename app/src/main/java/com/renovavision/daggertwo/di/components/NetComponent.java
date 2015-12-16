package com.renovavision.daggertwo.di.components;

import com.renovavision.daggertwo.di.modules.AppModule;
import com.renovavision.daggertwo.di.modules.NetModule;
import com.renovavision.daggertwo.di.scopes.AppScope;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

/**
 * Created by alexmprog on 16.12.2015.
 */

@AppScope
@Component(dependencies = AppComponent.class, modules = NetModule.class)
public interface NetComponent {

    Retrofit retrofit();

    OkHttpClient okHttpClient();
}
