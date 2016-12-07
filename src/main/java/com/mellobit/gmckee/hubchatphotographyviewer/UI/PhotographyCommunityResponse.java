package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import java.util.List;

/**
 * Created by GMckee on 03/12/2016.
 */
public class PhotographyCommunityResponse{
    //Root class for api response

    private String status;

    private List<PhotoCommunityPost> posts;

    public String getStatus() {
        return status;
    }

    public List<PhotoCommunityPost> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        String stringRep = "";

        stringRep += status + "\n";

        for (PhotoCommunityPost post: posts) {
            stringRep += "*******POST*********" + "\n";
            stringRep += post.toString();
        }

        return stringRep;
    }
}
