package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mellobit.gmckee.hubchatphotographyviewer.R;

public class DisplayPostsFragment extends Fragment implements iPhotoPostsList{

    private RecyclerView photoPostListView;
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
        presenter = new DisplayPostsPresenter(this, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_display_posts, container, false);
        photoPostListView = (RecyclerView) rootView.findViewById(R.id.photoPostListView);
        presenter.requestPostList();
        return rootView;
    }

    @Override
    public void onPostDataReady(RecyclerView.Adapter postAdapter) {
        photoPostListView.setAdapter(postAdapter);
    }
}
