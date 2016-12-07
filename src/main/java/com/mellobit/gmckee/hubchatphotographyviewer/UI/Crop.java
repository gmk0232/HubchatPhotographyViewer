package com.mellobit.gmckee.hubchatphotographyviewer.UI;

/**
 * Created by GMckee on 05/12/2016.
 */
public class Crop {
    int height;
    int width;
    int x;
    int y;

    @Override
    public String toString() {
        String stringRep = "\t" + "CROP_INFO";
        stringRep += "Height: " + height + "\n";
        stringRep += "Width: " + width + "\n";
        stringRep += "X: " + x + "\n";
        stringRep += "Y: " + y + "\n";
        
        return stringRep;
    }
}
