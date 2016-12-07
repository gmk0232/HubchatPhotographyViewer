package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.util.Log;

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

    @Override
    public String toString() {
        String stringRep = "" + "\n";
        stringRep += "RAWCONTENT: " + rawContent + "\n";

        if(createdBy == null){
            Log.d("NULLCHECK", "isNull!");
        }
        stringRep += createdBy.toString();
        stringRep += stats.toString();
        stringRep += entities.toString();

        return stringRep;
    }
}
