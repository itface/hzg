package com.infosource.domain.common;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangrongtao on 15/10/13.
 */
public class BaseDomain implements Serializable {
    protected Date created;
    protected Date modified;
    protected String optuserid;


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getOptuserid() {
        return optuserid;
    }

    public void setOptuserid(String optuserid) {
        this.optuserid = optuserid;
    }

    public void initBaseDomain() {
        /*Date date = new Date();
        long now = date.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowstr = sf.format(date);
        this.createtime = now;
        this.createtimestr = nowstr;
        this.modifiedtime = now;
        this.modifiedtimestr = nowstr;*/
    }
}
