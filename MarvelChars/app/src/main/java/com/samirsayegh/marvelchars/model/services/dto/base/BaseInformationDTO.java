package com.samirsayegh.marvelchars.model.services.dto.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class BaseInformationDTO {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("thumbnail")
    @Expose
    private ThumbnailDTO thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ThumbnailDTO getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailDTO thumbnail) {
        this.thumbnail = thumbnail;
    }
}
