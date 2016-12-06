package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by GMckee on 05/12/2016.
 */
public class PhotoCommunityPostsAdapter extends RecyclerView.Adapter{

    PhotoCommunityPost[] dataSet;

    public PhotoCommunityPostsAdapter(PhotoCommunityPost[] dataSet){
        this.dataSet = dataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
