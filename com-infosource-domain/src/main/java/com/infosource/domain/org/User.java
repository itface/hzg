package com.infosource.domain.org;

import com.infosource.domain.anno.FormGlobalSetting;
import com.infosource.domain.anno.InputType;
import com.infosource.domain.common.BaseDomain;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by wangrongtao on 15/10/13.
 */
@FormGlobalSetting(tableCaption = "用户管理",baseurl = "/test")
public class User extends BaseDomain implements Comparable<User> {
    private long id;
    @NotBlank
    @Length(max=100)
    @InputType(name="名称",queryAble = true,showInList = true,showInEditForm = true,showInReadForm = true)
    private String name;
    /**
     * 手机号
     */
    @NotBlank
    @Length(max=100)
    @InputType(name="用户id",queryAble = true,showInList = true,showInEditForm = true,showInReadForm = true)
    private String userid;
    private String pwd;
    /**
     * 帐号状态,预留，1是正常，-1锁定
     */
    private int status;
    private long orgid;
    private long lastlogintime;
    private String lastlogintimestr;
    private int loginfailcount;
    /**
     * 0代表密码验证，1代码短信验证
     */
    private int logintype;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public long getOrgid() {
        return orgid;
    }

    public void setOrgid(long orgid) {
        this.orgid = orgid;
    }

    public int getLoginfailcount() {
        return loginfailcount;
    }

    public void setLoginfailcount(int loginfailcount) {
        this.loginfailcount = loginfailcount;
    }

    public long getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(long lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastlogintimestr() {
        return lastlogintimestr;
    }

    public void setLastlogintimestr(String lastlogintimestr) {
        this.lastlogintimestr = lastlogintimestr;
    }

    public int getLogintype() {
        return logintype;
    }

    public void setLogintype(int logintype) {
        this.logintype = logintype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userid.equals(user.userid);

    }

    @Override
    public int hashCode() {
        return userid.hashCode();
    }
    @Override
    public int compareTo(User o) {
        if (o != null) {
            return id > o.getId()?1:-1;
        }
        return 0;
    }
}
