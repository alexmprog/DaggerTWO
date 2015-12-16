package com.renovavision.daggertwo.ui.repository.presenter;

import android.text.TextUtils;

import com.renovavision.daggertwo.App;
import com.renovavision.daggertwo.models.Repository;
import com.renovavision.daggertwo.ui.repository.interactor.RepositoriesLoadedCallback;
import com.renovavision.daggertwo.ui.repository.interactor.RepositoryInteractor;
import com.renovavision.daggertwo.ui.repository.interactor.RepositoryInteractorImpl;
import com.renovavision.daggertwo.ui.repository.view.RepositoryView;
import com.renovavision.daggertwo.utils.chrome.ChromeCustomTabManager;
import com.renovavision.daggertwo.utils.config.BuildConfigManager;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class RepositoryPresenterImpl implements RepositoryPresenter, RepositoriesLoadedCallback {

    @Inject
    BuildConfigManager mBuildConfigManager;

    @Inject
    ChromeCustomTabManager mCustomTabManager;

    private RepositoryInteractor mInterator;
    private List<Repository> mRepositoryList;
    private WeakReference<RepositoryView> mRepositoryView;

    public RepositoryPresenterImpl(App app, RepositoryView repositoryView) {
        app.getAppComponent().inject(this);
        this.mInterator = new RepositoryInteractorImpl(app, this);
        this.mRepositoryView = new WeakReference<>(repositoryView);
    }

    @Override
    public void onResume() {
        RepositoryView repositoryView = mRepositoryView.get();
        if (repositoryView == null) {
            return;
        }
        repositoryView.showProgressIndicator();
        mInterator.loadRepositories(mBuildConfigManager.getRepositorySinceId());
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void openLink(int position) {
        if (mRepositoryList == null) {
            return;
        }

        Repository repository = mRepositoryList.get(position);
        if (repository == null) {
            return;
        }

        String url = repository.url;
        if (TextUtils.isEmpty(url)) {
            return;
        }

        RepositoryView repositoryView = mRepositoryView.get();
        if (repositoryView == null) {
            return;
        }

        mCustomTabManager.openLink(repositoryView.getContext(), url);
    }

    @Override
    public void onSuccess(List<Repository> repositoryList) {
        RepositoryView repositoryView = mRepositoryView.get();
        if (repositoryView == null) {
            return;
        }

        mRepositoryList = repositoryList;

        repositoryView.showRepositories(repositoryList);
    }

    @Override
    public void onError(String error) {
        RepositoryView repositoryView = mRepositoryView.get();
        if (repositoryView == null) {
            return;
        }

        repositoryView.showError(error);
    }
}
