package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import com.google.gson.annotations.SerializedName;

/**
 * Created by GMckee on 07/12/2016.
 */
public class Forum {

    String title;
    String description;
    HeaderImage headerImage;

    @SerializedName("image")
    ForumIcon forumIcon;

}
