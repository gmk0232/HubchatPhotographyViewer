package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mellobit.gmckee.hubchatphotographyviewer.R;

/**
 * Created by GMckee on 05/12/2016.
 */
public class PhotoCommunityPostsAdapter extends RecyclerView.Adapter<PhotoCommunityPostsAdapter.PostHolder>{

    PhotoCommunityPost[] dataSet;

    public static class PostHolder extends RecyclerView.ViewHolder {
        public TextView postText;
        public TextView userName;
        public SimpleDraweeView userAvatar;


        public PostHolder(View v) {
            super(v);
            postText = (TextView) v.findViewById(R.id.postText);
            userName = (TextView) v.findViewById(R.id.userNameLabel);
            userAvatar = (SimpleDraweeView) v.findViewById(R.id.userAvatarDrawee);
        }
    }

    public PhotoCommunityPostsAdapter(PhotoCommunityPost[] dataSet){
        this.dataSet = dataSet;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_post_list_item, parent, false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        holder.postText.setText(dataSet[position].getRawContent().trim());
        holder.userName.setText(dataSet[position].getCreatedBy().username);
        holder.userAvatar.setImageURI(dataSet[position].getCreatedBy().avatar.url);
    }


    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}
