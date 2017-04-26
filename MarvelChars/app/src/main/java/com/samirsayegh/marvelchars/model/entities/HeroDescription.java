package com.samirsayegh.marvelchars.model.entities;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class HeroDescription extends Hero {

    private List<BaseContent> comicList;
    private List<BaseContent> eventList;

    public List<BaseContent> getComicList() {
        return comicList;
    }

    public void setComicList(List<BaseContent> comicList) {
        this.comicList = comicList;
    }

    public List<BaseContent> getEventList() {
        return eventList;
    }

    public void setEventList(List<BaseContent> eventList) {
        this.eventList = eventList;
    }
}
