package com.infosource.common.sourcegenerate;

import com.infosource.common.sourcegenerate.dao.GenDaoSourceUtil;
import com.infosource.common.sourcegenerate.db.mysql.mybatismapping.MyBatisXmlUtil;
import com.infosource.common.sourcegenerate.vm.GenVmSourceUtil;
import com.infosource.domain.org.User;
import com.infosource.domain.org.query.UserQuery;

/**
 * Created by wangrongtao on 16/4/21.
 */
public class GenAll {

    public static void main(String[] args) {
        MyBatisXmlUtil myBatisXmlUtil = new MyBatisXmlUtil();
        GenVmSourceUtil genVmSourceUtil = new GenVmSourceUtil();
        GenDaoSourceUtil genDaoSourceUtil = new GenDaoSourceUtil();
        Class claxx = User.class;
        myBatisXmlUtil.gen(claxx, UserQuery.class);
        genVmSourceUtil.gen(claxx);
        genDaoSourceUtil.gen(claxx);
    }
}
