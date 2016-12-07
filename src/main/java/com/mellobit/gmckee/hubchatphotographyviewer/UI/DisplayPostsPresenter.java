package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.content.Context;
import android.util.Log;

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
        hubchatApiRest.executeGetPostsFromApi();
        hubchatApiRest.executeGetForumMetaDataFromApi();
    }

    @Override
    public void onFetchPostsFinished(PhotoCommunityPostsAdapter adapter) {
        Log.d("DISPLAY POSTS PRESENTER", "Calling onPostDataReady");
        postsListFragment.onPostDataReady(adapter);
    }

    @Override
    public void onFetchForumMetaDataFinished(ForumMetaDataResponse forumMetaDataResponse) {
        postsListFragment.onForumMetaDataReady(forumMetaDataResponse);
    }
}
