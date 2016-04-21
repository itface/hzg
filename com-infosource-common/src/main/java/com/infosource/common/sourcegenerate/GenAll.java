package com.infosource.common.sourcegenerate;

import com.infosource.common.sourcegenerate.db.mysql.mybatismapping.GenMyBatisXmlService;
import com.infosource.common.sourcegenerate.db.mysql.mybatismapping.MyBatisXmlUtil;
import com.infosource.common.sourcegenerate.vm.GenVmSourceUtil;
import com.infosource.common.sourcegenerate.vm.VmSourceGenerateService;
import com.infosource.dao.org.UserDao;
import com.infosource.domain.org.User;
import com.infosource.domain.org.query.UserQuery;

import javax.annotation.Resource;

/**
 * Created by wangrongtao on 16/4/21.
 */
public class GenAll {

    public static void main(String[] args) {
        MyBatisXmlUtil myBatisXmlUtil = new MyBatisXmlUtil();
        GenVmSourceUtil genVmSourceUtil = new GenVmSourceUtil();
        myBatisXmlUtil.gen(User.class, UserQuery.class, UserDao.class,"user","user","UserDao.xml");
        genVmSourceUtil.genVm("user.vm","user");
    }
}
