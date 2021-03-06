package com.infosource.dao.org;


import com.infosource.domain.org.Role;
import com.infosource.domain.org.query.RoleQuery;

import java.util.List;

/**
 * Created by wangrongtao on 15/10/12.
 */
public interface RoleDao {

    public List<Role> findAll();

    public int save(Role role);
    public int update(Role role);

    public Role findById(Long id);

    public List<Role> findList(RoleQuery roleQuery);

    public List<Role> findListByPage(RoleQuery roleQuery);

    public int count(RoleQuery roleQuery);

    public int deleteById(Long id);


}
