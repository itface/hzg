package com.infosource.service.org;



import com.infosource.domain.common.PageVo;
import com.infosource.domain.org.User;
import com.infosource.domain.org.query.UserQuery;

import java.util.List;

/**
 * Created by wangrongtao on 15/10/14.
 */
public interface TestUserService {

    public List<User> findAll();

    public int save(User user);

    public User findById(Long id);

    public List<User> findList(UserQuery userQuery);

    public PageVo<User> findListByPage(UserQuery userQuery);

    public int count(UserQuery userQuery);

    public int deleteById(Long id);
}
