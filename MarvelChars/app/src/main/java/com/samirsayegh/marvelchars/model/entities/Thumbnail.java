package com.samirsayegh.marvelchars.model.entities;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class Thumbnail {

    public static final String STANDARD_SMALL = "standard_small";
    public static final String STANDARD_MEDIUM = "standard_medium";
    public static final String STANDARD_LARGE = "standard_large";
    public static final String STANDARD_XLARGE = "standard_xlarge";
    public static final String STANDARD_AMAZING = "standard_amazing";
    public static final String STANDARD_INCREDIBLE = "standard_incredible";

    public static final String PORTRAIT_SMALL = "portrait_small";
    public static final String PORTRAIT_MEDIUM = "portrait_medium";
    public static final String PORTRAIT_LARGE = "portrait_large";
    public static final String PORTRAIT_XLARGE = "portrait_xlarge";
    public static final String PORTRAIT_AMAZING = "portrait_amazing";
    public static final String PORTRAIT_INCREDIBLE = "portrait_incredible";

    public static final String LANDSCAPE_SMALL = "landscape_small";
    public static final String LANDSCAPE_MEDIUM = "landscape_medium";
    public static final String LANDSCAPE_LARGE = "landscape_large";
    public static final String LANDSCAPE_XLARGE = "landscape_xlarge";
    public static final String LANDSCAPE_AMAZING = "landscape_amazing";
    public static final String LANDSCAPE_INCREDIBLE = "landscape_incredible";

    private String path;
    private String extension;

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath(String size) {
        return path + "/" + size + "." + extension;
    }

}
