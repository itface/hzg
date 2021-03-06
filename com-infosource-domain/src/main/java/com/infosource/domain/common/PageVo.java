package com.infosource.domain.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangrongtao on 15/12/21.
 */
public class PageVo<T> implements Serializable {
    private List<T> list;
    private int page;
    private int total;
    private int pagesize;
    private boolean havenext;
    private int start;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public boolean isHavenext() {
        return havenext;
    }

    public void setHavenext(boolean havenext) {
        this.havenext = havenext;
    }

    public int getStart() {
        if (page < 1) {
            page=1;
        }
        return (page-1)*pagesize+1;
    }
}
