package com.samirsayegh.marvelchars.domain.entities;

import java.util.List;

/**
 * Created by yormirsamir.sayegh on 28/04/2017.
 */

public class OffsetList<T> {

    private int offset;
    private int total;
    private List<T> list;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
