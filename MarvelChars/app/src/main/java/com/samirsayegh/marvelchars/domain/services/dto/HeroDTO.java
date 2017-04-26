package com.samirsayegh.marvelchars.domain.services.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.samirsayegh.marvelchars.domain.services.dto.base.BaseInformationDTO;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class HeroDTO extends BaseInformationDTO {

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
