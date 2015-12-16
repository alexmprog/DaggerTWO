package com.renovavision.daggertwo.di.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.renovavision.daggertwo.App;
import com.renovavision.daggertwo.di.scopes.AppScope;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by alexmprog on 16.12.2015.
 */

@Module
public class NetModule {

    private static final int CACHE_SIZE = 10 * 1024 * 1024; // 10 MiB

    String mBaseUrl;

    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @AppScope
    Cache provideOkHttpCache(App application) {
        return new Cache(application.getCacheDir(), CACHE_SIZE);
    }

    @Provides
    @AppScope
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setCache(cache);
        return okHttpClient;
    }

    @Provides
    @AppScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @AppScope
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .validateEagerly()
                .build();
        return retrofit;
    }
}
