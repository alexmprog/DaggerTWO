package com.renovavision.daggertwo.api;

import com.renovavision.daggertwo.models.Repository;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by alexmprog on 16.12.2015.
 */

public interface GitHubApiService {

    @GET("repositories")
    Call<List<Repository>> getRepositoriesById(@Query("since") int sinceId);

}
