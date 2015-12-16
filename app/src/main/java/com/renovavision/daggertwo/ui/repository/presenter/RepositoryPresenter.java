package com.renovavision.daggertwo.ui.repository.presenter;

import com.renovavision.daggertwo.ui.repository.view.RepositoryView;

/**
 * Created by alexmprog on 16.12.2015.
 */
public interface RepositoryPresenter {

    void onResume();

    void onPause();

    void onDestroy();

    void openLink(int position);
}
