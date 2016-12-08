package com.mellobit.gmckee.hubchatphotographyviewer.UI;

/**
 * Created by GMckee on 03/12/2016.
 */
public class PhotoCommunityPost {

    String rawContent;
    User createdBy;
    Stats stats;
    Entities entities;

    public String getRawContent() {
        return rawContent;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Stats getStats() {
        return stats;
    }

    public Entities getEntities() {
        return entities;
    }

}
