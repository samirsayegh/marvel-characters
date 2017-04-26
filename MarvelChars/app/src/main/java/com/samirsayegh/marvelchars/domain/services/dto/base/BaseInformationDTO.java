package com.samirsayegh.marvelchars.domain.services.dto.base;

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
}
