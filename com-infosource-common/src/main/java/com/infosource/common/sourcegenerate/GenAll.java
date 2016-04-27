package com.infosource.common.sourcegenerate;

import com.infosource.common.sourcegenerate.controller.ControllerGenerator;
import com.infosource.common.sourcegenerate.dao.GenDaoSourceUtil;
import com.infosource.common.sourcegenerate.db.mysql.mybatismapping.MyBatisXmlUtil;
import com.infosource.common.sourcegenerate.service.GenServiceImplUtil;
import com.infosource.common.sourcegenerate.service.GenServiceInterfaceUtil;
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
        GenServiceInterfaceUtil genServiceInterfaceUtil = new GenServiceInterfaceUtil();
        GenServiceImplUtil genServiceImplUtil = new GenServiceImplUtil();
        ControllerGenerator controllerGenerator = new ControllerGenerator();
        Class claxx = User.class;
        Class queryClass = UserQuery.class;
        String baseurl = "/test";
        String caption = "用户管理";
        myBatisXmlUtil.gen(claxx, queryClass);
        genVmSourceUtil.gen(claxx,baseurl,caption);
        genDaoSourceUtil.gen(claxx,queryClass);
        genServiceInterfaceUtil.gen(claxx,queryClass);
        genServiceImplUtil.gen(claxx,queryClass);
        controllerGenerator.gen(claxx,queryClass,baseurl,"/test");
    }
}
