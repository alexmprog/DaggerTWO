package com.renovavision.daggertwo.utils.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by alexmprog on 16.12.2015.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private final int mSpace;

    public DividerItemDecoration(int space) {
        mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace / 2;
        outRect.top = mSpace / 2;
        outRect.right = mSpace / 2;
        outRect.bottom = mSpace / 2;
    }
}
