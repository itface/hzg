package com.infosource.common.persistence;

import com.infosource.common.persistence.dao.EntityDao;
import com.infosource.common.persistence.generate.EntityDaoBaseTest;
import com.infosource.common.persistence.query.Query;
import com.infosource.domain.org.User;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangrongtao on 16/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
//@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback=false)
public class UserTest extends EntityDaoBaseTest<User> {
    @Override
    public EntityDao<User> getEntityDao() {
        return null;
    }

    @Override
    public Class<User> getDomain() {
        return null;
    }

    @Override
    public Query getQuery() {
        return null;
    }
}
