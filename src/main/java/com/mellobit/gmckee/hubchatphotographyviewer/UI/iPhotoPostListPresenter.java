package com.mellobit.gmckee.hubchatphotographyviewer.UI;

/**
 * Created by GMckee on 03/12/2016.
 */
public interface iPhotoPostListPresenter {
    void requestData();
    void onFetchPostsFinished(PhotoCommunityPostsAdapter adapter);
    void onFetchForumMetaDataFinished(ForumMetaDataResponse forumMetaDataResponse);
}

