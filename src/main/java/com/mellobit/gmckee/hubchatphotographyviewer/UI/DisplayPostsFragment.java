package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mellobit.gmckee.hubchatphotographyviewer.R;

public class DisplayPostsFragment extends Fragment implements iPhotoPostsList{

    private RecyclerView photoPostListView;
    private TextView forumDescriptionLabel;
    private TextView forumTitleLabel;
    private SimpleDraweeView headerImage;
    private SimpleDraweeView logoImage;
    private RecyclerView.LayoutManager linearLayoutManager;

    private iPhotoPostListPresenter presenter;

    public DisplayPostsFragment() {
        // Required empty public constructor
    }

    public static DisplayPostsFragment newInstance(String param1, String param2) {
        DisplayPostsFragment fragment = new DisplayPostsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getActivity());
        presenter = new DisplayPostsPresenter(this, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_display_posts, container, false);

        headerImage = (SimpleDraweeView) rootView.findViewById(R.id.headerImage);
        logoImage = (SimpleDraweeView) rootView.findViewById(R.id.logoImage);
        forumTitleLabel = (TextView) rootView.findViewById(R.id.title_label);
        forumDescriptionLabel = (TextView)rootView.findViewById(R.id.description_label);
        photoPostListView = (RecyclerView) rootView.findViewById(R.id.photoPostListView);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        photoPostListView.setLayoutManager(linearLayoutManager);
        photoPostListView.setAdapter(new PhotoCommunityPostsAdapter(new PhotoCommunityPost[0], getActivity()));
        presenter.requestPostList();
        return rootView;
    }

    @Override
    public void onPostDataReady(RecyclerView.Adapter postAdapter) {
        Log.d("DISPLAY LIST FRAGMENT", "Setting adapter");
        photoPostListView.setAdapter(postAdapter);
    }

    @Override
    public void onForumMetaDataReady(ForumMetaDataResponse forumMetaDataResponse) {
        //Set Header
        headerImage.setImageURI(forumMetaDataResponse.forum.headerImage.url);
        logoImage.setImageURI(forumMetaDataResponse.forum.forumIcon.url);
        forumTitleLabel.setText(forumMetaDataResponse.forum.title);
        forumDescriptionLabel.setText(forumMetaDataResponse.forum.description);
    }
}
