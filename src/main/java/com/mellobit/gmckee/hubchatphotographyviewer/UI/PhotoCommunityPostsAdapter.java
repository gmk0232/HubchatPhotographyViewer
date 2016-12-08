package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mellobit.gmckee.hubchatphotographyviewer.R;

import java.util.ArrayList;

/**
 * Created by GMckee on 05/12/2016.
 */
public class PhotoCommunityPostsAdapter extends RecyclerView.Adapter<PhotoCommunityPostsAdapter.PostHolder>{

    PhotoCommunityPost[] dataSet;
    Context ctx;

    public static class PostHolder extends RecyclerView.ViewHolder {
        public TextView postText;
        public TextView userName;
        public TextView upVotes;
        public SimpleDraweeView userAvatar;
        public ViewGroup imageHolder;
        public ArrayList<SimpleDraweeView> postImages;

        public PostHolder(View v) {
            super(v);
            postText = (TextView) v.findViewById(R.id.postText);
            userName = (TextView) v.findViewById(R.id.userNameLabel);
            userAvatar = (SimpleDraweeView) v.findViewById(R.id.userAvatarDrawee);
            imageHolder = (ViewGroup) v.findViewById(R.id.imageHolder);
            upVotes = (TextView) v.findViewById(R.id.upVotes);
            postImages = new ArrayList<>();

        }
    }

    public PhotoCommunityPostsAdapter(PhotoCommunityPost[] dataSet, Context ctx){
        this.dataSet = dataSet;
        this.ctx = ctx;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_post_list_item, parent, false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        holder.postText.setText(dataSet[position].getRawContent().trim());
        holder.userName.setText(dataSet[position].getCreatedBy().username);
        holder.userAvatar.setImageURI(dataSet[position].getCreatedBy().avatar.url);
        holder.upVotes.setText(dataSet[position].getStats().upVotes);
        holder.imageHolder.removeAllViews();

        if(!dataSet[position].entities.getImages().isEmpty()){

            for (Image image: dataSet[position].entities.getImages()) {
                SimpleDraweeView imageFromPost = new SimpleDraweeView(ctx);
                imageFromPost.setPadding(5,5,5,5);
                imageFromPost.setImageURI(image.cdnUrl);
                imageFromPost.setLayoutParams(new LinearLayout.LayoutParams(600, 600));
                imageFromPost.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                holder.imageHolder.addView(imageFromPost);
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}
