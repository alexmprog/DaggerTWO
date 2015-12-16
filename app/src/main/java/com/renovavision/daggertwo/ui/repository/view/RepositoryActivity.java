package com.renovavision.daggertwo.ui.repository.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.renovavision.daggertwo.App;
import com.renovavision.daggertwo.R;
import com.renovavision.daggertwo.models.Repository;
import com.renovavision.daggertwo.ui.repository.presenter.RepositoryPresenter;
import com.renovavision.daggertwo.ui.repository.presenter.RepositoryPresenterImpl;
import com.renovavision.daggertwo.utils.widget.DividerItemDecoration;
import com.renovavision.daggertwo.utils.widget.RecyclerItemClickListener;

import java.util.List;

/**
 * Created by alexmprog on 16.12.2015.
 */

public class RepositoryActivity extends AppCompatActivity implements RepositoryView {

    private RepositoryPresenter mRepositoryPresenter;

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private RepositoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getResources()
                .getDimensionPixelSize(R.dimen.activity_main_recycler_divider)));
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        mRepositoryPresenter.openLink(position);
                    }
                })
        );

        mAdapter = new RepositoryAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_indicator);
        mProgressBar.setVisibility(View.GONE);

        mRepositoryPresenter = new RepositoryPresenterImpl((App) getApplication(), this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mRepositoryPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRepositoryPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRepositoryPresenter.onDestroy();
    }

    @Override
    public void showProgressIndicator() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        // do something
    }

    @Override
    public void showRepositories(List<Repository> repositoryList) {
        mProgressBar.setVisibility(View.GONE);
        mAdapter.setRepositories(repositoryList);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
