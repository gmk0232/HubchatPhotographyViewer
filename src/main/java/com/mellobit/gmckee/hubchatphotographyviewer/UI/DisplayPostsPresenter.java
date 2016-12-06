package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.content.Context;

/**
 * Created by GMckee on 03/12/2016.
 */
public class DisplayPostsPresenter implements iPhotoPostListPresenter{

    private Context ctx;
    private iPhotoPostsList postsListFragment;

    public DisplayPostsPresenter(iPhotoPostsList postsListFragment, Context ctx){
        this.postsListFragment = postsListFragment;
        this.ctx = ctx;

    }

    @Override
    public void requestPostList() {
        HubchatApiRest hubchatApiRest= new HubchatApiRest(ctx, this);
        postsListFragment.onPostDataReady(hubchatApiRest.executeApiCall());
    }

    @Override
    public void onRequestFinished(PhotoCommunityPostsAdapter adapter) {
        postsListFragment.onPostDataReady(adapter);
    }
}
