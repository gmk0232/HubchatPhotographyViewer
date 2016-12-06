package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import retrofit2.Callback;

/**
 * Created by GMckee on 03/12/2016.
 */
public interface iPhotoCommunityPostsManager extends Callback {

    public void fetchPosts(Object request);
}
