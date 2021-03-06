package com.infosource.dao.org;

import com.infosource.domain.org.Org;
import com.infosource.domain.org.query.OrgQuery;

import java.util.List;

/**
 * Created by wangrongtao on 15/10/12.
 */
public interface OrgDao {

    public List<Org> findAll();
    public List<Org> findByParentorgid(Long parentorgid);

    public int save(Org org);
    public int update(Org org);

    public Org findById(Long id);
    public Org findByOrgtag(String orgtag);

    public List<Org> findList(OrgQuery orgQuery);

    public List<Org> findListByPage(OrgQuery orgQuery);

    public int count(OrgQuery orgQuery);

    public int deleteById(Long id);
    public int deleteByParentorgid(Long parentorgid);


}
