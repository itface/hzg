package com.infosource.common.sourcegenerate.service;

import com.infosource.common.sourcegenerate.util.FileUtils;

import java.io.File;

/**
 * Created by wangrongtao on 16/4/21.
 */
public class GenServiceImplUtil {
    private final String BREAK_ROW = "\n";
    private final String TAB_1 = "\t";

    private String getDomainname(Class clazz){
        return clazz.getSimpleName();
    }
    private String getServiceName(Class clazz){
        return clazz.getSimpleName()+"Service";
    }
    private String getServiceImplName(Class clazz){
        return clazz.getSimpleName()+"ServiceImpl";
    }
    private String getDaoName(Class clazz){
        return clazz.getSimpleName() + "Dao";
    }
    private String getDaoValName(Class clazz){
        String daoname = getDaoName(clazz);
        String daovalname = daoname.substring(0,1).toLowerCase()+daoname.substring(1);
        return daovalname;
    }
    private String getQueryObjName(Class clazz){
        return clazz.getSimpleName()+"Query";
    }
    private String getQueryObjValName(Class clazz){
        String queryObjName = getQueryObjName(clazz);
        return queryObjName.substring(0,1).toLowerCase()+queryObjName.substring(1);
    }
    private String getPackage(Class clazz){
        StringBuilder sb = new StringBuilder();
        String packagename = clazz.getPackage().getName();
        String daoPackagename = packagename.replace("domain", "service")+".impl";
        sb.append("package ").append(daoPackagename).append(";").append(BREAK_ROW);
        return sb.toString();
    }
    private String getHeader(Class clazz){
        StringBuilder sb = new StringBuilder();
        sb.append("public class ").append(getServiceName(clazz)).append(" implements ").append(getServiceImplName(clazz)).append("{").append(BREAK_ROW);
        return sb.toString();
    }
    private String getDependency(String firstTab, Class clazz){
        StringBuilder sb = new StringBuilder();
        String domainname = clazz.getSimpleName();
        sb.append(firstTab).append("@Resource").append(BREAK_ROW);
        sb.append(firstTab).append("private ").append(getDaoName(clazz)).append(" ").append(getDaoValName(clazz)).append(BREAK_ROW);
        return sb.toString();
    }
    private String getFooter(){
        StringBuilder sb = new StringBuilder();
        sb.append("}");
        return sb.toString();
    }
    private String getFindAll(String firstTab, Class clazz){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("@Override").append(BREAK_ROW);
        sb.append(firstTab).append("public List< ").append(getDomainname(clazz)).append("> findAll(){").append(BREAK_ROW);
            sb.append(secondTab).append("return").append(getDaoValName(clazz)).append(".findAll();").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String getFindById(String firstTab, Class clazz){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("@Override").append(BREAK_ROW);
        sb.append(firstTab).append("public ").append(getDomainname(clazz)).append(" findById(long id){").append(BREAK_ROW);
            sb.append(secondTab).append("return").append(getDaoValName(clazz)).append(".findById(id);").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String getDeleteById(String firstTab, Class clazz){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("@Override").append(BREAK_ROW);
        sb.append(firstTab).append("public int deleteById(long id){").append(BREAK_ROW);
            sb.append(secondTab).append("return").append(getDaoValName(clazz)).append(".deleteById(id);").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String getFindList(String firstTab, Class clazz){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("@Override").append(BREAK_ROW);
        sb.append(firstTab).append("public List< ").append(getDomainname(clazz)).append("> findList(").append(getQueryObjName(clazz)).append(" ").append(getQueryObjValName(clazz)).append("){").append(BREAK_ROW);
            sb.append(secondTab).append("return").append(getDaoValName(clazz)).append(".findList(").append(getQueryObjValName(clazz)).append(");").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String getFindListByPage(String firstTab, Class clazz){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        sb.append(firstTab).append("@Override").append(BREAK_ROW);
        sb.append(firstTab).append("public PageVo< ").append(getDomainname(clazz)).append("> findListByPage(").append(getQueryObjName(clazz)).append(" ").append(getQueryObjValName(clazz)).append("){").append(BREAK_ROW);
            sb.append(secondTab).append("int count = this.count(").append(getQueryObjValName(clazz)).append(");").append(BREAK_ROW);
            sb.append(secondTab).append("if(count > 0){").append(BREAK_ROW);
                sb.append(thirdTab).append("List<User> list = testUserDao.findListByPage(userQuery);").append(BREAK_ROW);
            sb.append(secondTab).append("}").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String getContent(Class clazz){
        StringBuilder sb = new StringBuilder();
        String domainname = clazz.getSimpleName();
        String domainObjValName = domainname.substring(0,1).toLowerCase()+domainname.substring(1);
        String queryObjName = domainname + "Query";
        String queryObjValName = domainObjValName + "Query";
        sb.append(TAB_1).append("public ").append(domainname).append(" findById(long id);").append(BREAK_ROW);
        sb.append(TAB_1).append("public int deleteById(long id);").append(BREAK_ROW);
        sb.append(TAB_1).append("public List< ").append(domainname).append("> findAll();").append(BREAK_ROW);
        sb.append(TAB_1).append("public List< ").append(domainname).append("> findList(").append(queryObjName).append(" ").append(queryObjValName).append(");").append(BREAK_ROW);
        sb.append(TAB_1).append("public PageVo< ").append(domainname).append("> findListByPage(").append(queryObjName).append(" ").append(queryObjValName).append(");").append(BREAK_ROW);
        sb.append(TAB_1).append("public int count(").append(queryObjName).append(" ").append(queryObjValName).append(");").append(BREAK_ROW);
        sb.append(TAB_1).append("public int save(").append(domainname).append(" ").append(domainObjValName).append(");").append(BREAK_ROW);
        sb.append(TAB_1).append("public int update(").append(domainname).append(" ").append(domainObjValName).append(");").append(BREAK_ROW);
        return sb.toString();
    }
    public String genStr(Class clazz){
        StringBuilder sb = new StringBuilder();
        sb.append(getPackage(clazz));
        sb.append(getHeader(clazz));
        sb.append(getContent(clazz));
        sb.append(getFooter());
        return sb.toString();
    }
    public void gen(Class clazz){
        try {
            String domainname = clazz.getSimpleName();
            String daoname = domainname+"Service.java";
            String path = FileUtils.getFilePath(domainname);
            String s = genStr(clazz);
            String filename = path+ File.separator+daoname;
            FileUtils.writeFile(filename,s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
