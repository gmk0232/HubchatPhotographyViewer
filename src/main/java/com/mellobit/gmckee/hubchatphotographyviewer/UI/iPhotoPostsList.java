package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.support.v7.widget.RecyclerView;

/**
 * Created by GMckee on 03/12/2016.
 */
public interface iPhotoPostsList {
    void onPostDataReady(RecyclerView.Adapter postAdapter);
    void onForumMetaDataReady(ForumMetaDataResponse forumMetaDataResponse);
}
