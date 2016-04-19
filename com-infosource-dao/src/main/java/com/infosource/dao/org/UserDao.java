package com.infosource.dao.org;


import com.infosource.domain.org.User;
import com.infosource.domain.org.query.UserQuery;

import java.util.List;

/**
 * Created by wangrongtao on 15/10/12.
 */
public interface UserDao {

    public List<User> findAll();

    public int save(User user);
    public int update(User user);

    public User findById(Long id);
    public User findByUserid(String userid);

    public List<User> findList(UserQuery userQuery);

    public List<User> findListByPage(UserQuery userQuery);

    public int count(UserQuery userQuery);

    public int deleteById(Long id);

    public int updateLoginStatus(User user);

}
