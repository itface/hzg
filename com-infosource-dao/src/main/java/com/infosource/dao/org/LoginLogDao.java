package com.infosource.dao.org;


import com.infosource.domain.org.LoginLog;
import com.infosource.domain.org.query.LoginLogQuery;

import java.util.List;

/**
 * Created by wangrongtao on 15/10/12.
 */
public interface LoginLogDao {

    public List<LoginLog> findAll();

    public int save(LoginLog loginLog);

    public LoginLog findById(Long id);

    public List<LoginLog> findList(LoginLogQuery loginLogQuery);

    public List<LoginLog> findListByPage(LoginLogQuery loginLogQuery);

    public int count(LoginLogQuery loginLogQuery);

    public int deleteById(Long id);


}
