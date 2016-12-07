package com.mellobit.gmckee.hubchatphotographyviewer.UI;

/**
 * Created by GMckee on 05/12/2016.
 */
public class Avatar {
    Crop crop;
    String url;

    @Override
    public String toString() {
        String stringRep = "\t" + "AVATAR";
        stringRep += crop.toString() + "\n";
        stringRep += url + "\n";
        return stringRep;
    }
}
