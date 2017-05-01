package com.samirsayegh.marvelchars.domain.entities;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class HeroDescription extends Hero {

    private int comicCount;
    private int eventCount;
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

    public int getComicCount() {
        return comicCount;
    }

    public void setComicCount(int comicCount) {
        this.comicCount = comicCount;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }
}
