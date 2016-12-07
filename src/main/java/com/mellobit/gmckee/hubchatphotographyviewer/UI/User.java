package com.mellobit.gmckee.hubchatphotographyviewer.UI;

/**
 * Created by GMckee on 05/12/2016.
 */
public class User {

    String username;
    Avatar avatar;

    @Override
    public String toString() {
        String stringRep = "";
        stringRep += username;
        stringRep += avatar.toString();

        return stringRep;
    }
}
