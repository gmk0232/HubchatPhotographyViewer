package com.mellobit.gmckee.hubchatphotographyviewer.UI;


import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by GMckee on 03/12/2016.
 */
public interface iHubchatApiInterface {

    @GET("photography/post")
    Observable<PhotographyCommunityResponse> getPostsFromApi();

    @GET("photography")
    Observable<ForumMetaDataResponse> getForumMetaDataFromApi();

}


