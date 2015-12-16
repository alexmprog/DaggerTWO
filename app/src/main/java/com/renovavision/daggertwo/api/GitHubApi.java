package com.renovavision.daggertwo.api;

import com.renovavision.daggertwo.models.Repository;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class GitHubApi {

    public interface ResponseCallback<T> {

        void onSuccess(T data);

        void onError(Throwable throwable);
    }

    Retrofit mRetrofit;

    GitHubApiService mApiInterface;


    public GitHubApi(Retrofit retrofit) {
        mRetrofit = retrofit;
        mApiInterface = retrofit.create(GitHubApiService.class);
    }

    public void getRepositories(int sinceId, final ResponseCallback responseCallback) {
        Call<List<Repository>> call = mApiInterface.getRepositoriesById(sinceId);
        call.enqueue(new Callback<List<Repository>>() {

            @Override
            public void onResponse(Response<List<Repository>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    responseCallback.onSuccess(response.body());
                } else {
                    responseCallback.onError(null);
                }

            }

            @Override
            public void onFailure(Throwable t) {
                responseCallback.onError(t);
            }
        });
    }
}
