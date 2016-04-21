package com.infosource.common.sourcegenerate.db.mysql.mybatismapping.impl;

import com.infosource.common.sourcegenerate.db.mysql.mybatismapping.GenMyBatisXmlService;
import com.infosource.common.sourcegenerate.util.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by wangrongtao on 16/4/21.
 */
@Service
public class GenMyBatisXmlServiceImpl implements GenMyBatisXmlService {
    private final String BREAK_ROW = "\n";
    private final String TAB_1 = "\t";

    public String makeXml(Class domainClass, Class queryClass,Class daoClass, String tablename) {
        StringBuilder sb = new StringBuilder();
        sb.append(getHeader(daoClass));
        sb.append(getResultMap(TAB_1,domainClass));
        sb.append(getAllQueryFields(TAB_1,domainClass));
        sb.append(getPage(TAB_1,domainClass));
        sb.append(getDynamicWhereCloumn(TAB_1,queryClass));
        sb.append(getFindAll(TAB_1,queryClass,tablename));
        sb.append(getFindById(TAB_1,queryClass,tablename));
        sb.append(getFindList(TAB_1,queryClass,tablename));
        sb.append(getFindListByPage(TAB_1,queryClass,tablename));
        sb.append(getCount(TAB_1,queryClass,tablename));
        sb.append(getSave(TAB_1,domainClass,tablename));
        sb.append(getDeleteById(TAB_1,queryClass,tablename) );
        sb.append(getFoot());
        return sb.toString();
    }


    private String getHeader(Class daoClass) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append(BREAK_ROW);
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">").append(BREAK_ROW);
        sb.append("<mapper namespace=\"").append(daoClass.getName()).append("\">").append(BREAK_ROW);
        return sb.toString();
    }
    private String getFoot() {
        StringBuilder sb = new StringBuilder();
        sb.append("</mapper>");
        return sb.toString();
    }

    private String getResultMap(String firstTab,Class domainClass) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<resultMap id=\"ResultMap\" type=\"").append(domainClass.getName()).append("\">").append(BREAK_ROW);
        Field[] fields = domainClass.getDeclaredFields();
        for (Field field : fields) {
            sb.append(secondTab).append("<result column=\"").append(field.getName()).append("\" property=\"").append(field.getName()).append("\"/>").append(BREAK_ROW);
        }
        sb.append(firstTab).append("</resultMap>").append(BREAK_ROW);
        return sb.toString();
    }
    private String getSelectFields(String firstTab,Class domainClass){
        StringBuilder sb = new StringBuilder();
        Field[] fields = domainClass.getDeclaredFields();
        for (Field field : fields) {
            sb.append(field.getName()).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }
    private String getSelectFieldValues(String firstTab,Class domainClass){
        StringBuilder sb = new StringBuilder();
        Field[] fields = domainClass.getDeclaredFields();
        for (Field field : fields) {
            sb.append("#{").append(field.getName()).append("},");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }
    private String getAllQueryFields(String firstTab,Class domainClass) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<sql id=\"allColumn\">").append(BREAK_ROW);
        sb.append(secondTab).append(getSelectFields(secondTab,domainClass));
        sb.append(firstTab).append("</sql>").append(BREAK_ROW);
        return sb.toString();
    }
    private String getPage(String firstTab,Class domainClass) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<sql id=\"page\">").append(BREAK_ROW);
        sb.append(secondTab).append("limit #{startRow},#{pageSize}");
        sb.append(firstTab).append("</sql>").append(BREAK_ROW);
        return sb.toString();
    }
    private boolean isInteger(Class<?> clz) {
        return clz.isAssignableFrom(Integer.class) || clz == int.class;
    }
    private boolean isLong(Class<?> clz) {
        return clz.isAssignableFrom(Long.class)|| clz == long.class;
    }
    private String getDynamicWhereCloumn(String firstTab,Class queryClass) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        String thirdTab = TAB_1+secondTab;
        String fourthTab = TAB_1+thirdTab;
        String fifthTab = TAB_1+fourthTab;
        sb.append(firstTab).append("<sql id=\"condition\">").append(BREAK_ROW);
        sb.append(thirdTab).append("<trim prefix=\"WHERE\" prefixOverrides=\"AND | OR\">").append(BREAK_ROW);
        Field[] fieldList = queryClass.getDeclaredFields();
        for (Field field : fieldList) {
            if (isInteger(field.getType()) || isLong(field.getType())) {
                sb.append(fourthTab).append("<if test=\"").append(field.getName()).append(" != null and ").append(field.getName()).append(">0\">").append(BREAK_ROW);
            }else{
                sb.append(fourthTab).append("<if test=\"").append(field.getName()).append(" != null \">").append(BREAK_ROW);
            }
            sb.append(fifthTab).append(field.getName()).append("=#{").append(field.getName()).append("}\n");
            sb.append(fourthTab).append("</if>").append(BREAK_ROW);
        }
        sb.append(thirdTab).append("</trim>").append(BREAK_ROW);
        sb.append(firstTab).append("</sql>").append(BREAK_ROW);
        return sb.toString();
    }


    private String getFindAll(String firstTab,Class queryClass,String tablename) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<select id=\"findAll\" parameterType=\"").append(queryClass.getName()).append("\"  resultMap=\"ResultMap\">").append(BREAK_ROW);
        sb.append(secondTab).append("select <include refid=\"allColumn\"/> from ").append(tablename).append(BREAK_ROW);
        sb.append(firstTab).append("</select>").append(BREAK_ROW);
        return sb.toString();
    }
    private String getFindById(String firstTab,Class queryClass,String tablename) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<select id=\"findById\" parameterType=\"long\"  resultMap=\"ResultMap\">").append(BREAK_ROW);
        sb.append(secondTab).append("select <include refid=\"allColumn\"/> from ").append(tablename).append(" where id = #{id}").append(BREAK_ROW);
        sb.append(firstTab).append("</select>").append(BREAK_ROW);
        return sb.toString();
    }

    private String getFindList(String firstTab,Class queryClass,String tablename) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<select id=\"findList\" parameterType=\"").append(queryClass.getName()).append("\"  resultMap=\"ResultMap\">").append(BREAK_ROW);
        sb.append(secondTab).append("select <include refid=\"allColumn\"/> from ").append(tablename).append(" <include refid=\"condition\"/>").append(BREAK_ROW);
        sb.append(firstTab).append("</select>").append(BREAK_ROW);
        return sb.toString();
    }
    private String getFindListByPage(String firstTab,Class queryClass,String tablename) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<select id=\"findListByPage\" parameterType=\"").append(queryClass.getName()).append("\"  resultMap=\"ResultMap\">").append(BREAK_ROW);
        sb.append(secondTab).append("select <include refid=\"allColumn\"/> from ").append(tablename).append(" <include refid=\"condition\"/>").append(" <include refid=\"page\"/>").append(BREAK_ROW);
        sb.append(firstTab).append("</select>").append(BREAK_ROW);
        return sb.toString();
    }
    private String getCount(String firstTab,Class queryClass,String tablename) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<select id=\"count\" parameterType=\"").append(queryClass.getName()).append("\"  resultType=\"int\">").append(BREAK_ROW);
        sb.append(secondTab).append("select count(1) from ").append(tablename).append(" <include refid=\"condition\"/>").append(BREAK_ROW);
        sb.append(firstTab).append("</select>").append(BREAK_ROW);
        return sb.toString();
    }
    private String getSave(String firstTab,Class domainClass,String tablename) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<insert id=\"save\" parameterType=\"").append(domainClass.getName()).append("\">").append(BREAK_ROW);
        sb.append(secondTab).append("insert into ").append(tablename).append("(").append(getSelectFields(secondTab,domainClass)).append(")")
                .append(" values(").append(getSelectFieldValues(secondTab,domainClass)).append(")").append(BREAK_ROW);
        sb.append(firstTab).append("</insert>").append(BREAK_ROW);
        return sb.toString();
    }
    private String getDeleteById(String firstTab,Class queryClass,String tablename) {
        StringBuilder sb = new StringBuilder();
        String secondTab = TAB_1+firstTab;
        sb.append(firstTab).append("<delete id=\"deleteById\" parameterType=\"long\">").append(BREAK_ROW);
        sb.append(secondTab).append("delete from  ").append(tablename).append(" where id = #{id}").append(BREAK_ROW);
        sb.append(firstTab).append("</delete>").append(BREAK_ROW);
        return sb.toString();
    }
    public void gen(Class domainClass, Class queryClass,Class daoClass, String tablename,String dirname,String xmlname){
        try {
            String path = FileUtils.getFilePath(this.getClass(),dirname);
            String s = makeXml(domainClass,queryClass,daoClass,tablename);
            String filename = path+ File.separator+xmlname;
            FileUtils.writeFile(filename,s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        /*MyBatisXmlUtil myBatisXmlUtil = new MyBatisXmlUtil();
        myBatisXmlUtil.gen(User.class, UserQuery.class, UserDao.class,"user","user","UserDao.xml");*/
    }
}
