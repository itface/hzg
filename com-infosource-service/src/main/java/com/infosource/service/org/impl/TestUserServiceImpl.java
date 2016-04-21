package com.infosource.service.org.impl;

import com.infosource.common.sourcegenerate.util.IdWorker;
import com.infosource.dao.org.TestUserDao;
import com.infosource.domain.common.PageVo;
import com.infosource.domain.org.User;
import com.infosource.domain.org.query.UserQuery;
import com.infosource.service.org.TestUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangrongtao on 16/4/20.
 */
@Service
public class TestUserServiceImpl implements TestUserService {

    @Resource
    private TestUserDao testUserDao;
    @Override
    public List<User> findAll() {
        return testUserDao.findAll();
    }

    @Override
    public int save(User user) {
        return testUserDao.save(user);
    }


    @Override
    public User findById(Long id) {
        return testUserDao.findById(id);
    }

    @Override
    public List<User> findList(UserQuery userQuery) {
        return testUserDao.findList(userQuery);
    }

    @Override
    public PageVo<User> findListByPage(UserQuery userQuery) {
        int count = this.count(userQuery);
        if (count > 0) {
            List<User> list = testUserDao.findListByPage(userQuery);
            PageVo<User> pageVo = new PageVo<User>();
            pageVo.setList(list);
            pageVo.setPage(userQuery.getPage());
            pageVo.setPagesize(userQuery.getPageSize());
            pageVo.setTotal(count);
            return pageVo;
        }
        return null;
    }

    @Override
    public int count(UserQuery userQuery) {
        return testUserDao.count(userQuery);
    }

    @Override
    public int deleteById(Long id) {
        return testUserDao.deleteById(id);
    }

    @Override
    public int update(User user) {
        return testUserDao.update(user);
    }
}
