package com.samirsayegh.marvelchars.model.entities;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class BaseContent {

    private String name;
    private String description;
    private Thumbnail thumbnail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public String getThumbnail(String size) {
        return thumbnail.getPath(size);
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}
