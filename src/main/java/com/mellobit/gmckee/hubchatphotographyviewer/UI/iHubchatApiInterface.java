package com.mellobit.gmckee.hubchatphotographyviewer.UI;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by GMckee on 03/12/2016.
 */
public interface iHubchatApiInterface {

    String POST_LIST_BASE_URL = "https://api.hubchat.com/v1/forum/";

    @GET("photography/post")
    Observable<PhotographyCommunityResponse> getPostsFromApi();

    @GET("photography")
    Observable<ForumMetaDataResponse> getForumMetaDataFromApi();

    Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(POST_LIST_BASE_URL)
            .build();

}


