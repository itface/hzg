package com.infosource.domain.common;

/**
 * Created by wangrongtao on 15/10/13.
 */
public class BaseQuery extends BaseDomain{
    protected int startRow;
    protected int endRow;
    protected int pageSize;
    protected int page;

    public int getStartRow() {
        if (page < 1) {
            page=1;
        }
        if (pageSize < 1) {
            pageSize=1;
        }
        return (page-1)*pageSize;
    }
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
