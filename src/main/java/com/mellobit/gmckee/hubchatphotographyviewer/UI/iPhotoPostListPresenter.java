package com.mellobit.gmckee.hubchatphotographyviewer.UI;

/**
 * Created by GMckee on 03/12/2016.
 */
public interface iPhotoPostListPresenter {
    public void requestPostList();
    public void onFetchPostsFinished(PhotoCommunityPostsAdapter adapter);
    public void onFetchForumMetaDataFinished(ForumMetaDataResponse forumMetaDataResponse);
}

