package com.renovavision.daggertwo.ui.repository.view;

import android.content.Context;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renovavision.daggertwo.R;
import com.renovavision.daggertwo.models.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ItemViewHolder> {

    private List<Repository> mItems;
    private Context mContext;

    public RepositoryAdapter(Context context) {
        super();
        this.mContext = context;
        this.mItems = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        Repository repository = mItems.get(position);

        String repositoryName = repository.name;
        if (!TextUtils.isEmpty(repositoryName)) {
            holder.mTextName.setText(repositoryName);
        }

        String repositoryDescription = repository.description;
        if (!TextUtils.isEmpty(repositoryDescription)) {
            holder.mTextDescription.setText(repositoryDescription);
        }

    }

    public void setRepositories(List<Repository> repositoryList) {
        this.mItems = repositoryList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextName;
        public TextView mTextDescription;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.text_name);
            mTextDescription = (TextView) itemView.findViewById(R.id.text_description);
        }
    }
}

