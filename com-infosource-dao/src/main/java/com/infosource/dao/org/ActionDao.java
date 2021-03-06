package com.infosource.dao.org;


import com.infosource.domain.org.Action;
import com.infosource.domain.org.query.ActionQuery;

import java.util.List;

/**
 * Created by wangrongtao on 15/10/12.
 */
public interface ActionDao {

    public List<Action> findAll();

    public int save(Action action);
    public int update(Action action);

    public Action findById(Long id);

    public List<Action> findList(ActionQuery actionQuery);

    public List<Action> findListByPage(ActionQuery actionQuery);

    public int count(ActionQuery actionQuery);

    public int deleteById(Long id);
    public List<Action> findByIds(Long[] ids);
    public List<Action> findByTags(String[] tags);
}
