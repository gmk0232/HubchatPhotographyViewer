package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.content.Context;
import android.util.Log;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by GMckee on 04/12/2016.
 */
public class HubchatApiRest {
    private static final String BASE_URL = "https://api.hubchat.com/v1/forum/";
    private Retrofit retrofit;
    private Context ctx;
    private iPhotoPostListPresenter presenter;

    public HubchatApiRest(Context ctx, iPhotoPostListPresenter presenter){
        this.ctx = ctx;
        this.presenter = presenter;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL.toString())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private PhotoCommunityPost[] getPostsAsArray(PhotographyCommunityResponse posts){

        PhotoCommunityPost [] postsAsArray;

            List<PhotoCommunityPost> postsAsList =  posts.getPosts();
            postsAsArray = new PhotoCommunityPost[postsAsList.size()];

            for (int i = 0; i<postsAsArray.length; i++) {
                postsAsArray[i] = postsAsList.get(i);
            }

            return postsAsArray;
    }

    public PhotoCommunityPostsAdapter executeApiCall(){
        iHubchatApiInterface service = retrofit.create(iHubchatApiInterface.class);
        service.getPostsFromApi().
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<PhotographyCommunityResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d("APICALL", "Call completed!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("APICALL", e.getMessage());
                    }

                    @Override
                    public void onNext(PhotographyCommunityResponse photographyCommunityResponse) {
                        //Log.d("APICALL", photographyCommunityResponse.toString());

                        PhotoCommunityPost[] postsAsArray = getPostsAsArray(photographyCommunityResponse);
                        PhotoCommunityPostsAdapter adapter = new PhotoCommunityPostsAdapter(postsAsArray);
                        presenter.onRequestFinished(adapter);
                    }
                });



        return null;
    }
}
