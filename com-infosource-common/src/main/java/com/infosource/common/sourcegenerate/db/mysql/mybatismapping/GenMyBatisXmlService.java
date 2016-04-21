package com.infosource.common.sourcegenerate.db.mysql.mybatismapping;

/**
 * Created by wangrongtao on 16/4/21.
 */
public interface GenMyBatisXmlService {
    public void gen(Class domainClass, Class queryClass,Class daoClass, String tablename,String dirname,String xmlname);
}
