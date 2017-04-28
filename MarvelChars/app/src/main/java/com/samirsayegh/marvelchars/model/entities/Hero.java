package com.samirsayegh.marvelchars.model.entities;

import java.io.Serializable;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class Hero extends BaseContent implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                '}' + super.toString();
    }
}
