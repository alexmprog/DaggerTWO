package com.renovavision.daggertwo.utils.config;

import com.renovavision.daggertwo.BuildConfig;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class BuildConfigManager {

    public BuildConfigManager() {

    }

    public String getGitHubBaseUrl() {
        return BuildConfig.GITHUB_API_BASE_URL;
    }

    // only for resting
    public int getRepositorySinceId() {
        return 839;
    }
}
