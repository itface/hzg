package com.infosource.domain.org.query;


import com.infosource.domain.common.BaseQuery;

/**
 * Created by wangrongtao on 15/10/13.
 */
public class UserRoleQuery extends BaseQuery {

    private Long id;
    private String userid;
    private Integer roleid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String toLogString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id").append(":").append(id).append(",");
        sb.append("userid").append(":").append(userid).append(",");
        sb.append("roleid").append(":").append(roleid).append(",");
        sb.append("startRow").append(":").append(startRow).append(",");
        sb.append("pageSize").append(":").append(pageSize).append(",");
        return sb.toString();
    }
}
