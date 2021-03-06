package com.infosource.common.sourcegenerate.vm;

import com.infosource.common.sourcegenerate.util.FileUtils;
import com.infosource.domain.anno.FormGlobalSetting;
import com.infosource.domain.anno.InputType;
import com.infosource.domain.org.User;
import com.infosource.domain.sourcegenerate.FieldModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangrongtao on 16/3/14.
 */
@Service
public class GenVmSourceUtil {

    private final String BREAK_ROW = "\n";
    private final String TAB_1 = "\t";
    private final String TAB_2 = TAB_1+TAB_1;
    private final String TAB_3 = TAB_1+TAB_2;
    private final String TAB_4 = TAB_1+TAB_3;
    private final String TAB_5 = TAB_1+TAB_4;
    private final String TAB_6 = TAB_1+TAB_5;
    private final String TAB_7 = TAB_1+TAB_6;
    private final String TAB_8 = TAB_1+TAB_7;
    private final String TAB_9 = TAB_1+TAB_8;
    private final String TAB_10 = TAB_1+TAB_9;
    private final String TAB_11 = TAB_1+TAB_10;
    private final String TAB_12 = TAB_1+TAB_11;
    private final String TAB_13 = TAB_1+TAB_12;
    private final String TAB_14 = TAB_1+TAB_13;
    private final String TAB_15 = TAB_1+TAB_14;

    private String htmlHeader(){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>").append(BREAK_ROW);
        sb.append("<html>").append(BREAK_ROW);
        return sb.toString();
    }
    private String htmlFoot(){
        StringBuilder sb = new StringBuilder();
        sb.append("</html>");
        return sb.toString();
    }
    private String head(){
        String firstTab = TAB_2;
        String secondTab = TAB_3;
        StringBuilder sb = new StringBuilder();
        sb.append(firstTab).append("<head>").append(BREAK_ROW);
        sb.append(secondTab).append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">").append(BREAK_ROW);
        sb.append(secondTab).append("<meta name=\"description\" content=\"\">").append(BREAK_ROW);
        sb.append(secondTab).append("<meta name=\"author\" content=\"\">").append(BREAK_ROW);
        sb.append(secondTab).append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">").append(BREAK_ROW);
        sb.append(secondTab).append("<meta http-equiv=\"cache-control\" content=\"no-cache\">").append(BREAK_ROW);
        sb.append(secondTab).append("<meta http-equiv=\"Expires\" content=\"0\">").append(BREAK_ROW);
        sb.append(secondTab).append("<link rel=\"stylesheet\" href=\"/static/bootstrap/3.3.5/css/bootstrap.min.css\">").append(BREAK_ROW);
        sb.append(secondTab).append("<link rel=\"stylesheet\" href=\"/static/bootstrap/3.3.5/css/bootstrap-theme.min.css\">").append(BREAK_ROW);
        sb.append(secondTab).append("<link rel=\"stylesheet\" href=\"/static/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css\">").append(BREAK_ROW);
        sb.append(secondTab).append("<link rel=\"stylesheet\" href=\"/static/css/common.css\">").append(BREAK_ROW);
        sb.append(secondTab).append("<script src=\"/static/jquery/1.11.3/jquery.min.js\"></script>").append(BREAK_ROW);
        sb.append(secondTab).append("<script src=\"/static/bootstrap/3.3.5/js/bootstrap.min.js\"></script>").append(BREAK_ROW);
        sb.append(secondTab).append("<script src=\"/static/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js\"></script>").append(BREAK_ROW);
        sb.append(secondTab).append("<script src=\"/static/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js\"></script>").append(BREAK_ROW);
        sb.append(secondTab).append("<script src=\"/static/mybootstrappager/my_bootstrap-pager.js\"></script>").append(BREAK_ROW);
        sb.append(firstTab).append("</head>").append(BREAK_ROW);
        return sb.toString();
    }
    private String vmScript() {
        String firstTab = TAB_2;
        String secondTab = TAB_3;
        StringBuilder sb = new StringBuilder();
        sb.append(firstTab).append("#if($!pageVo)").append(BREAK_ROW);
            sb.append(secondTab).append("#set($list = $!pageVo.list)").append(BREAK_ROW);
            sb.append(secondTab).append("#set($currentPage = $!pageVo.page)").append(BREAK_ROW);
            sb.append(secondTab).append("#set($total = $!pageVo.total)").append(BREAK_ROW);
            sb.append(secondTab).append("#set($pagesize = $!pageVo.pagesize)").append(BREAK_ROW);
            sb.append(secondTab).append("#set($startIndex = $!pageVo.getStart())").append(BREAK_ROW);
        sb.append(firstTab).append("#end").append(BREAK_ROW);
        return sb.toString();
    }
    /*<div class="caption-class">
    <caption><h2>用户管理</h2></caption>
    </div>
    <form id='queryform' name='queryform'>
    <div class="container">
    <table class="table table-bordered table-striped table-hover common-table">
    <tr>
    <td><input id="name" name="name" class="form-control" type="text" placeholder="名称" value="$!queryobj.name"/></td>
    <td><input id="userid" name="userid" class="form-control" type="text" placeholder="用户id" value="$!queryobj.userid"/></td>
    </tr>
    <tr>
    <td colspan="2">
    <input type="hidden" name="page" id="page" page="$!currentPage"/>
    <div class="pull-right">
    <a href="javascript:void(0);" class="btn btn-info btn-sm btn-query">
    <span class="glyphicon glyphicon-search"></span> 查询
            </a>
    <a href="javascript:void(0);" class="btn btn-info btn-sm btn-query-reset">
    <span class="glyphicon glyphicon-refresh"></span> 重置
            </a>
    </div>
    </td>
    </tr>
    </table>
    </div>
    </form>*/
    private  String body(String caption,List<FieldModel> fieldModelList){
        String firstTab = TAB_2;
        String secondTab = TAB_1+firstTab;
        String thirdTab = TAB_1+secondTab;
        String fouthTab = TAB_1+thirdTab;
        String fifthTab = TAB_1+fouthTab;
        String sixthTab = TAB_1+fifthTab;
        String seventhTab = TAB_1+sixthTab;
        String eightthTab = TAB_1+seventhTab;
        String ninthTab = TAB_1+eightthTab;
        String tenthTab = TAB_1+ninthTab;
        String eleventhTab = TAB_1+tenthTab;
        String twelfthTab = TAB_1+eleventhTab;
        String thirteenthTab = TAB_1+twelfthTab;
        StringBuilder sb = new StringBuilder();
        sb.append(firstTab).append("<body>").append(BREAK_ROW);
            sb.append(secondTab).append("<div class=\"caption-class\">").append(BREAK_ROW);
                sb.append(thirdTab).append("<caption><h2>").append(caption).append("</h2></caption>").append(BREAK_ROW);
            sb.append(secondTab).append("</div>").append(BREAK_ROW);
            sb.append(secondTab).append("<form id='queryform' name='queryform'>").append(BREAK_ROW);
                sb.append(thirdTab).append("<div class=\"container\">").append(BREAK_ROW);
                    sb.append(fouthTab).append("<table class=\"table table-bordered table-striped table-hover common-table\">").append(BREAK_ROW);
                        if (!CollectionUtils.isEmpty(fieldModelList)) {
                            for (int i = 0; i < fieldModelList.size(); ) {
                                FieldModel fieldModel = fieldModelList.get(i++);
                                if (fieldModel != null && fieldModel.isQueryAble()) {
                                    sb.append(fifthTab).append("<tr>").append(BREAK_ROW);
                                    sb.append(sixthTab).append("<td>").append(BREAK_ROW);
                                    sb.append(seventhTab).append(inputHtml(fieldModel.getType(), fieldModel.getId(), "field-query")).append(BREAK_ROW);
                                    sb.append(sixthTab).append("</td>").append(BREAK_ROW);
                                    FieldModel fieldModel2 = fieldModelList.get(i++);
                                    while (fieldModel2 == null || !fieldModel2.isQueryAble()) {
                                        fieldModel2 = fieldModelList.get(i++);
                                    }
                                    if (fieldModel2 != null && fieldModel2.isQueryAble()) {
                                        sb.append(sixthTab).append("<td>").append(BREAK_ROW);
                                        sb.append(seventhTab).append(inputHtml(fieldModel2.getType(), fieldModel2.getId(), "field-query")).append(BREAK_ROW);
                                        sb.append(sixthTab).append("</td>").append(BREAK_ROW);
                                    }
                                    sb.append(fifthTab).append("</tr>").append(BREAK_ROW);
                                }
                            }
                        }
                        sb.append(fifthTab).append("<tr>").append(BREAK_ROW);
                            sb.append(sixthTab).append("<td colspan='2'>").append(BREAK_ROW);
                                sb.append(seventhTab).append("<input type=\"hidden\" name=\"page\" id=\"page\" page=\"$!currentPage\"/>").append(BREAK_ROW);
                                sb.append(seventhTab).append("<div class=\"pull-right\">").append(BREAK_ROW);
                                    sb.append(eightthTab).append("<a href=\"javascript:void(0);\" class=\"btn btn-info btn-sm btn-query\"><span class=\"glyphicon glyphicon-search\"></span> 查询</a>").append(BREAK_ROW);
                                    sb.append(eightthTab).append("<a href=\"javascript:void(0);\" class=\"btn btn-info btn-sm btn-query-reset\"><span class=\"glyphicon glyphicon-refresh\"></span> 重置</a>").append(BREAK_ROW);
                                sb.append(seventhTab).append("</div>").append(BREAK_ROW);
                            sb.append(sixthTab).append("</td>").append(BREAK_ROW);
                        sb.append(fifthTab).append("</tr>").append(BREAK_ROW);
                    sb.append(fouthTab).append("</table>").append(BREAK_ROW);
                sb.append(thirdTab).append("</div>").append(BREAK_ROW);
            sb.append(secondTab).append("</form>").append(BREAK_ROW);
            sb.append(secondTab).append("<form id='mainform' name='mainform'>").append(BREAK_ROW);
                sb.append(thirdTab).append("<div class=\"container\">").append(BREAK_ROW);
                    sb.append(fouthTab).append("<div class=\"table-responsive\">").append(BREAK_ROW);
                        sb.append(fifthTab).append("<div>").append(BREAK_ROW);
                            sb.append(sixthTab).append("<table class=\"table table-bordered table-striped table-hover common-table\">").append(BREAK_ROW);
//                                sb.append(seventhTab).append("<caption><h2>").append(caption).append("</h2></caption>").append(BREAK_ROW);
                                sb.append(seventhTab).append("<thead>").append(BREAK_ROW);
                                    sb.append(eightthTab).append("<tr>").append(BREAK_ROW);
                                        sb.append(ninthTab).append("<th>").append(BREAK_ROW);
                                            sb.append(tenthTab).append("<a href=\"javascript:void(0)\" class=\"btn btn-default btn-sm btn-add\">").append(BREAK_ROW);
                                                sb.append(eleventhTab).append("<span class=\"glyphicon glyphicon-plus\"></span> 添加").append(BREAK_ROW);
                                            sb.append(tenthTab).append("</a>").append(BREAK_ROW);
                                        sb.append(ninthTab).append("</th>").append(BREAK_ROW);
                                        sb.append(ninthTab).append("<th>").append("序号").append("</th>").append(BREAK_ROW);
                                        if(!CollectionUtils.isEmpty(fieldModelList)){
                                            for(FieldModel fieldModel : fieldModelList){
                                                if (fieldModel.isShowInList()) {
                                                    String fieldname = fieldModel.getName();
                                                    sb.append(ninthTab).append("<th>").append(BREAK_ROW);
                                                    sb.append(eleventhTab).append(fieldname);
                                                    sb.append(ninthTab).append("</th>").append(BREAK_ROW);
                                                }
                                            }
                                        }
                                        sb.append(ninthTab).append("<th>").append("操作").append("</th>").append(BREAK_ROW);
                                    sb.append(eightthTab).append("</tr>").append(BREAK_ROW);
                                sb.append(seventhTab).append("</thead>").append(BREAK_ROW);
                                sb.append(seventhTab).append("<tbody>").append(BREAK_ROW);
                                    sb.append(eightthTab).append("#if($list && $list.size()>0)").append(BREAK_ROW);
                                        sb.append(ninthTab).append("#foreach($obj in $list)").append(BREAK_ROW);
                                            sb.append(tenthTab).append("#set($tempIndex=$velocityCount+$startIndex - 1)").append(BREAK_ROW);
                                            sb.append(tenthTab).append("<tr objId='$!obj.id'>").append(BREAK_ROW);
                                                sb.append(eleventhTab).append("<td>").append(BREAK_ROW);
                                                    sb.append(twelfthTab).append("<span>").append(BREAK_ROW);
                                                        sb.append(thirteenthTab).append("<a class='glyphicon glyphicon-trash btn btn-del' title='删除' href='javascript:void(0)'></a>").append(BREAK_ROW);
                                                    sb.append(twelfthTab).append("</span>").append(BREAK_ROW);
                                                sb.append(eleventhTab).append("</td>").append(BREAK_ROW);
                                                sb.append(eleventhTab).append("<td>").append("$!tempIndex").append("</td>").append(BREAK_ROW);
                                                if(!CollectionUtils.isEmpty(fieldModelList)) {
                                                    for (FieldModel fieldModel : fieldModelList) {
                                                        if (fieldModel.isShowInList()) {
                                                            sb.append(eleventhTab).append("<td>").append("$!obj.").append(fieldModel.getId()).append("</td>").append(BREAK_ROW);
                                                        }
                                                    }
                                                }
                                                sb.append(eleventhTab).append("<td>").append(BREAK_ROW);
                                                    sb.append(twelfthTab).append("<a class='glyphicon glyphicon-pencil btn' title='修改' href='javascript:void(0)'></a>").append(BREAK_ROW);
                                                    sb.append(twelfthTab).append("<a class='glyphicon glyphicon-eye-open btn' title='详情' href='javascript:void(0)'></a>").append(BREAK_ROW);
                                                sb.append(eleventhTab).append("</td>").append(BREAK_ROW);
                                            sb.append(tenthTab).append("</tr>").append(BREAK_ROW);
                                        sb.append(ninthTab).append("#end").append(BREAK_ROW);
                                    sb.append(eightthTab).append("#end").append(BREAK_ROW);
                                sb.append(seventhTab).append("</tbody>").append(BREAK_ROW);
                            sb.append(sixthTab).append("</table>").append(BREAK_ROW);
                        sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                        sb.append(fifthTab).append("<div class=\"pull-right\">").append(BREAK_ROW);
                            sb.append(sixthTab).append("<div id=\"pager\"></div>").append(BREAK_ROW);
                        sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                    sb.append(fouthTab).append("</div>").append(BREAK_ROW);
                sb.append(thirdTab).append("</div>").append(BREAK_ROW);
            sb.append(secondTab).append("</form>").append(BREAK_ROW);
        sb.append(firstTab).append("</body>").append(BREAK_ROW);
        return sb.toString();
    }
    public String modal(){
        String firstTab = TAB_4;
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        String fouthTab = thirdTab+TAB_1;
        String fifthTab = fouthTab+TAB_1;
        String sixthTab = fifthTab+TAB_1;
        StringBuilder sb = new StringBuilder();
        sb.append(firstTab).append("<div>").append(BREAK_ROW);
            sb.append(secondTab).append("<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">").append(BREAK_ROW);
                sb.append(thirdTab).append("<div class=\"modal-dialog\" style=\"width: 800px;\">").append(BREAK_ROW);
                    sb.append(fouthTab).append("<div class=\"modal-content\">").append(BREAK_ROW);
                        sb.append(fifthTab).append("<div class=\"modal-header\">").append(BREAK_ROW);
                            sb.append(sixthTab).append("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>").append(BREAK_ROW);
                            sb.append(sixthTab).append("<h4 class=\"modal-title\" id=\"myModalLabel\"></h4>").append(BREAK_ROW);
                        sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                        sb.append(fifthTab).append("<div class=\"modal-body\">").append(BREAK_ROW);
                        sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                        sb.append(fifthTab).append("<div class=\"modal-footer\">").append(BREAK_ROW);
                            sb.append(sixthTab).append("<button type=\"button\" class=\"btn btn-default btn-cancel\" data-dismiss=\"modal\"></button>").append(BREAK_ROW);
                            sb.append(sixthTab).append("<button type=\"button\" class=\"btn btn-primary btn-confirm\"></button>").append(BREAK_ROW);
                        sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                    sb.append(fouthTab).append("</div>").append(BREAK_ROW);
                sb.append(thirdTab).append("</div>").append(BREAK_ROW);
            sb.append(secondTab).append("</div>").append(BREAK_ROW);
        sb.append(firstTab).append("</div>").append(BREAK_ROW);
        return sb.toString();
    }
    public String readScriptTemplate(List<FieldModel> fieldModelList){
        StringBuilder sb = new StringBuilder();
        String firstTab = TAB_2;
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        String fouthTab = thirdTab+TAB_1;
        String fifthTab = fouthTab+TAB_1;
        sb.append(firstTab).append("<script id=\"readScriptTemplate\" type=\"text/template\">").append(BREAK_ROW);
            sb.append(secondTab).append("<div class='read-form'>").append(BREAK_ROW);
                if(!CollectionUtils.isEmpty(fieldModelList)){
                    int length = fieldModelList.size();
                    for(int i=0;i<length;){
                        sb.append(thirdTab).append("<div class=\"row\">").append(BREAK_ROW);
                        FieldModel fieldModel = fieldModelList.get(i++);
                        while (!fieldModel.isShowInReadForm()&&i<length) {
                            fieldModel = fieldModelList.get(i++);
                        }
                        if (fieldModel.isShowInReadForm()) {
                            sb.append(fouthTab).append("<div class=\"col-xs-2\">").append(BREAK_ROW);
                                sb.append(fifthTab).append("<label class='read-form-field'>").append(fieldModel.getName()).append(":</label>").append(BREAK_ROW);
                            sb.append(fouthTab).append("</div>").append(BREAK_ROW);
                            sb.append(fouthTab).append("<div class=\"col-xs-4\">").append(BREAK_ROW);
                                sb.append(fifthTab).append("<span class='read-form-"+fieldModel.getId()+" line-word-break read-form-field read-form-field-value'></span>").append(BREAK_ROW);
                            sb.append(fouthTab).append("</div>").append(BREAK_ROW);
                            if (i<length) {
                                fieldModel = fieldModelList.get(i++);
                                while (!fieldModel.isShowInReadForm()&&i<length) {
                                    fieldModel = fieldModelList.get(i++);
                                }
                                if (fieldModel.isShowInReadForm()) {
                                    sb.append(fouthTab).append("<div class=\"col-xs-2\">").append(BREAK_ROW);
                                    sb.append(fifthTab).append("<label class='read-form-field'>").append(fieldModel.getName()).append(":</label>").append(BREAK_ROW);
                                    sb.append(fouthTab).append("</div>").append(BREAK_ROW);
                                    sb.append(fouthTab).append("<div class=\"col-xs-4\">").append(BREAK_ROW);
                                    sb.append(fifthTab).append("<span class='read-form-"+fieldModel.getId()+" line-word-break read-form-field read-form-field-value'></span>").append(BREAK_ROW);
                                    sb.append(fouthTab).append("</div>").append(BREAK_ROW);
                                }
                            }
                        }
                        sb.append(thirdTab).append("</div>").append(BREAK_ROW);
                    }
                }
                sb.append(thirdTab).append("<div class=\"row\">").append(BREAK_ROW);
                    sb.append(fouthTab).append("<div class=\"col-xs-12\">").append(BREAK_ROW);
                        sb.append(fifthTab).append("<div class=\"alert alert-danger center-block error-msg\" style=\"display:none\"></div>").append(BREAK_ROW);
                    sb.append(fouthTab).append("</div").append(BREAK_ROW);
                sb.append(thirdTab).append("</div>").append(BREAK_ROW);
            sb.append(secondTab).append("</div>").append(BREAK_ROW);
        sb.append(firstTab).append("</script>").append(BREAK_ROW);
        return sb.toString();
    }
    public String editScriptTemplate(List<FieldModel> fieldModelList){
        StringBuilder sb = new StringBuilder();
        String firstTab = TAB_2;
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        String fouthTab = thirdTab+TAB_1;
        String fifthTab = fouthTab+TAB_1;
        String sixthTab = fifthTab+TAB_1;
        sb.append(firstTab).append("<script id=\"editScriptTemplate\" type=\"text/template\">").append(BREAK_ROW);
            sb.append(secondTab).append("<div class='edit-form'>").append(BREAK_ROW);
                sb.append(thirdTab).append("<form role=\"form\" id=\"editForm\">").append(BREAK_ROW);
                    if(!CollectionUtils.isEmpty(fieldModelList)){
                        int length = fieldModelList.size();
                        for(int i=0;i<length;){
                            FieldModel fieldModel = fieldModelList.get(i++);
                            sb.append(fouthTab).append("<div class=\"row form-group\">").append(BREAK_ROW);
                            while (!fieldModel.isShowInEditForm()&&i<length) {
                                fieldModel = fieldModelList.get(i++);
                            }
                            if (fieldModel.isShowInEditForm()) {
                                sb.append(fifthTab).append("<div class=\"col-xs-2\">").append(BREAK_ROW);
                                    sb.append(sixthTab).append("<label>").append(fieldModel.getName()).append("</label>").append(BREAK_ROW);
                                sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                                sb.append(fifthTab).append("<div class=\"col-xs-4\">").append(BREAK_ROW);
                                    sb.append(sixthTab).append(inputHtml(fieldModel.getType(),fieldModel.getId(),null)).append(BREAK_ROW);
                                sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                                if (i<length) {
                                    fieldModel = fieldModelList.get(i++);
                                    while (!fieldModel.isShowInEditForm()&&i<length) {
                                        fieldModel = fieldModelList.get(i++);
                                    }
                                    if (fieldModel.isShowInEditForm()) {
                                        sb.append(fifthTab).append("<div class=\"col-xs-2\">").append(BREAK_ROW);
                                        sb.append(sixthTab).append("<label>").append(fieldModel.getName()).append("</label>").append(BREAK_ROW);
                                        sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                                        sb.append(fifthTab).append("<div class=\"col-xs-4\">").append(BREAK_ROW);
                                        sb.append(sixthTab).append(inputHtml(fieldModel.getType(),fieldModel.getId(),null)).append(BREAK_ROW);
                                        sb.append(fifthTab).append("</div>").append(BREAK_ROW);
                                    }
                                }
                            }

                            sb.append(fouthTab).append("</div>").append(BREAK_ROW);
                        }
                    }
                    sb.append(fouthTab).append("<div><input type=\"hidden\" name='id' id='id'value='0'/></div>").append(BREAK_ROW);
                    sb.append(fouthTab).append("<div class=\"row\">").append(BREAK_ROW);
                        sb.append(fifthTab).append("<div class=\"col-xs-12\">").append(BREAK_ROW);
                            sb.append(sixthTab).append("<div class=\"alert alert-danger center-block error-msg\" style=\"display:none\"></div>").append(BREAK_ROW);
                        sb.append(fifthTab).append("</div").append(BREAK_ROW);
                    sb.append(fouthTab).append("</div>").append(BREAK_ROW);
                sb.append(thirdTab).append("</form>").append(BREAK_ROW);
            sb.append(secondTab).append("</div>").append(BREAK_ROW);
        sb.append(firstTab).append("</script>").append(BREAK_ROW);
        return sb.toString();
    }
    private String inputHtml(String fieldType,String fieldId,String fieldClass){
        String inputHtml = "";
        if ("text".equals(fieldType)) {
            inputHtml = "<input id=\""+fieldId+"\" name=\""+fieldId+"\" class=\"form-control "+(fieldClass==null?"":"field-query")+"\" type=\"text\"/>";
        } else if ("select".equals(fieldType)) {
            inputHtml = "<select id=\""+fieldId+"\" name=\""+fieldId+"\" class=\"form-control "+(fieldClass==null?"":"field-query")+"\"></select>";
        }else if ("textarea".equals(fieldType)) {
            inputHtml = "<textarea id=\""+fieldId+"\" name=\""+fieldId+"\" rows=\"6\" class=\"form-control "+(fieldClass==null?"":"field-query")+"\"></textarea>";
        }else if ("hidden".equals(fieldType)) {
            inputHtml = "<input type=\"hidden\" name='"+fieldId+"' id='"+fieldId+"'/>";
        }else if ("date".equals(fieldType)) {
            inputHtml = "<input id=\""+fieldId+"\" name=\""+fieldId+"\" class=\"form-control datetimepicker-class "+(fieldClass==null?"":"field-query")+"\" type=\"text\" readonly/>";
        }
        return inputHtml;
    }
    private String javascript(List<FieldModel> fieldModelList,String baseurl){
        StringBuilder sb = new StringBuilder();
        String firstTab = TAB_2;
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("<script>").append(BREAK_ROW);
        sb.append(globalJsVariable(secondTab,baseurl)).append(BREAK_ROW);
        sb.append(functionInitDatetimepicker(secondTab)).append(BREAK_ROW);
        sb.append(functionInitEditFormEvent(secondTab)).append(BREAK_ROW);
        sb.append(functionDelEvent(secondTab)).append(BREAK_ROW);
        sb.append(functionUpdateEvent(secondTab)).append(BREAK_ROW);
        sb.append(functionReadEvent(secondTab)).append(BREAK_ROW);
        sb.append(functionAddEvent(secondTab)).append(BREAK_ROW);
        sb.append(functionShowModalErrorMsg(secondTab)).append(BREAK_ROW);
        sb.append(functionShowModal(secondTab)).append(BREAK_ROW);
        sb.append(functionDel(secondTab)).append(BREAK_ROW);
        sb.append(functionEdit(secondTab)).append(BREAK_ROW);
        sb.append(functionSetFormData(secondTab)).append(BREAK_ROW);
        sb.append(functionHideModal(secondTab)).append(BREAK_ROW);
//        sb.append(functionInitEditFormData(secondTab,fieldModelList)).append(BREAK_ROW);
        sb.append(functionSetEditFormData(secondTab)).append(BREAK_ROW);
        sb.append(functionSetReadFormData(secondTab)).append(BREAK_ROW);
        sb.append(firstTab).append("</script>").append(BREAK_ROW);
        return sb.toString();
    }
    private String globalJsVariable(String firstTab,String baseurl){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("var currentId;").append(BREAK_ROW);
        sb.append(firstTab).append("var locationUrl = '").append(baseurl).append("';").append(BREAK_ROW);
        sb.append(firstTab).append("jQuery('#pager').my_page({url:locationUrl,currentPage:'$!currentPage',formname:'mainform',total:'$!total',pageSize:'$!pagesize',queryform:'queryform'});").append(BREAK_ROW);
        sb.append(firstTab).append("initDatetimepicker();").append(BREAK_ROW);
        sb.append(firstTab).append("$('.btn-query').click(function(e){").append(BREAK_ROW);
            sb.append(secondTab).append("$('#page').val(1);").append(BREAK_ROW);
            sb.append(secondTab).append("$(\"form[name='queryform']\").attr(\"action\", locationUrl);").append(BREAK_ROW);
            sb.append(secondTab).append("$(\"form[name='queryform']\").attr(\"method\", 'POST');").append(BREAK_ROW);
            sb.append(secondTab).append("$(\"form[name='queryform']\").submit();").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        sb.append(firstTab).append("$('.btn-query-reset').click(function(e){").append(BREAK_ROW);
            sb.append(secondTab).append("$(\".field-query\",\"form[id='queryform']\").val('');").append(BREAK_ROW);
            sb.append(secondTab).append("$('#page').val(1);").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        /*sb.append(firstTab).append("$('.datetimepicker-class').datetimepicker({").append(BREAK_ROW);
            sb.append(secondTab).append("format: 'yyyy-mm-dd',").append(BREAK_ROW);
            sb.append(secondTab).append("minView: \"month\",").append(BREAK_ROW);
            sb.append(secondTab).append("language: 'zh-CN',").append(BREAK_ROW);
            sb.append(secondTab).append("autoclose:true").append(BREAK_ROW);
        sb.append(firstTab).append("});").append(BREAK_ROW);*/
        return sb.toString();
    }
    private String functionInitDatetimepicker(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        sb.append(firstTab).append("function initDatetimepicker(){").append(BREAK_ROW);
            sb.append(secondTab).append("$('.datetimepicker-class').datetimepicker({").append(BREAK_ROW);
                sb.append(thirdTab).append("format: 'yyyy-mm-dd',").append(BREAK_ROW);
                sb.append(thirdTab).append("minView: \"month\",").append(BREAK_ROW);
                sb.append(thirdTab).append("language: 'zh-CN',").append(BREAK_ROW);
                sb.append(thirdTab).append("autoclose:true").append(BREAK_ROW);
            sb.append(secondTab).append("});").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionInitEditFormEvent(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        sb.append(firstTab).append("function initEditFormEvent(){").append(BREAK_ROW);
            sb.append(secondTab).append("initDatetimepicker();").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionDelEvent(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        sb.append(firstTab).append("jQuery('.btn-del').click(function(e){").append(BREAK_ROW);
        sb.append(secondTab).append("currentId = jQuery(e.target).parents('tr').attr('objId');").append(BREAK_ROW);
        sb.append(secondTab).append("if(currentId>0){").append(BREAK_ROW);
        sb.append(thirdTab).append("showModal('确认删除？','注意','取消','确定删除',del);").append(BREAK_ROW);
        sb.append(secondTab).append("}else{").append(BREAK_ROW);
        sb.append(thirdTab).append("showModal('删除无效','注意','取消','确定删除',del);").append(BREAK_ROW);
        sb.append(secondTab).append("}").append(BREAK_ROW);
        sb.append(firstTab).append("})").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionUpdateEvent(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("jQuery('.glyphicon-pencil').click(function(e){").append(BREAK_ROW);
            sb.append(secondTab).append("currentId = jQuery(e.target).parents('tr').attr('objId');").append(BREAK_ROW);
            sb.append(secondTab).append("var edithtml = jQuery('#editScriptTemplate').html();").append(BREAK_ROW);
            sb.append(secondTab).append("showModal(edithtml,'更新','取消','保存',edit);").append(BREAK_ROW);
            sb.append(secondTab).append("setFormData('edit');").append(BREAK_ROW);
            sb.append(secondTab).append("initEditFormEvent();").append(BREAK_ROW);
        sb.append(firstTab).append("})").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionReadEvent(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("jQuery('.glyphicon-eye-open').click(function(e){").append(BREAK_ROW);
            sb.append(secondTab).append("currentId = jQuery(e.target).parents('tr').attr('objId');").append(BREAK_ROW);
            sb.append(secondTab).append("var readhtml = jQuery('#readScriptTemplate').html();").append(BREAK_ROW);
            sb.append(secondTab).append("showModal(readhtml,'详情','取消','关闭',hideModal);").append(BREAK_ROW);
            sb.append(secondTab).append("setFormData('read');").append(BREAK_ROW);
        sb.append(firstTab).append("})").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionAddEvent(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("jQuery('.btn-add').click(function(e){").append(BREAK_ROW);
            sb.append(secondTab).append("currentId = 0;").append(BREAK_ROW);
            sb.append(secondTab).append("var edithtml = jQuery('#editScriptTemplate').html();").append(BREAK_ROW);
            sb.append(secondTab).append("showModal(edithtml,'新增','取消','保存',edit);").append(BREAK_ROW);
            sb.append(secondTab).append("setEditFormData(null);").append(BREAK_ROW);
            sb.append(secondTab).append("initEditFormEvent();").append(BREAK_ROW);
        sb.append(firstTab).append("})").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionShowModalErrorMsg(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("function showModalErrorMsg(msg){").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .error-msg').empty();").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .error-msg').html(msg);").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .error-msg').show();").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionShowModal(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = firstTab+TAB_1;
        sb.append(firstTab).append("function showModal(html,title,cancelBtnVal,comfirmBtnval,confirmCallback){").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .error-msg').empty();").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .modal-body').empty();").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .modal-title').html(title);").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .btn-cancel').html(cancelBtnVal);").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .btn-confirm').html(comfirmBtnval);").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .modal-body').append(html);").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal .btn-confirm').unbind(\"click\");").append(BREAK_ROW);
            sb.append(secondTab).append("if(confirmCallback){").append(BREAK_ROW);
                sb.append(thirdTab).append("jQuery('#myModal .btn-confirm').on('click',confirmCallback);").append(BREAK_ROW);
            sb.append(secondTab).append("}").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal').modal('show');").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionDel(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        String fouthTab = TAB_1+thirdTab;
        String fifthTab = TAB_1+fouthTab;
        sb.append(firstTab).append("function del(){").append(BREAK_ROW);
            sb.append(secondTab).append("var id = currentId;").append(BREAK_ROW);
            sb.append(secondTab).append("var url = locationUrl+'").append("/remove';").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery.ajax({").append(BREAK_ROW);
                sb.append(thirdTab).append("url:url,").append(BREAK_ROW);
                sb.append(thirdTab).append("data:{id:id},").append(BREAK_ROW);
                sb.append(thirdTab).append("type:'POST',").append(BREAK_ROW);
                sb.append(thirdTab).append("cache:false,").append(BREAK_ROW);
                sb.append(thirdTab).append("success:function(data) {").append(BREAK_ROW);
                    sb.append(fouthTab).append("if(data>0){").append(BREAK_ROW);
                        sb.append(fifthTab).append("window.location.href=locationUrl;").append(BREAK_ROW);
                    sb.append(fouthTab).append("}else{").append(BREAK_ROW);
                        sb.append(fifthTab).append("showModal('删除失败','注意','取消','确定',null);").append(BREAK_ROW);
                    sb.append(fouthTab).append("}").append(BREAK_ROW);
                sb.append(thirdTab).append("},").append(BREAK_ROW);
                sb.append(thirdTab).append("error:function(){").append(BREAK_ROW);
                    sb.append(fouthTab).append("showModal('删除异常','注意','取消','确定',null);").append(BREAK_ROW);
                sb.append(thirdTab).append("}").append(BREAK_ROW);
            sb.append(secondTab).append("});").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionEdit(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        String fouthTab = TAB_1+thirdTab;
        String fifthTab = TAB_1+fouthTab;
        sb.append(firstTab).append("function edit(){").append(BREAK_ROW);
            sb.append(secondTab).append("var id = currentId;").append(BREAK_ROW);
            sb.append(secondTab).append("var param = $(\"form[id='editForm']\").serialize();").append(BREAK_ROW);
            sb.append(secondTab).append("var url = locationUrl+'").append("/edit';").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery.ajax({").append(BREAK_ROW);
                sb.append(thirdTab).append("url:url,").append(BREAK_ROW);
                sb.append(thirdTab).append("data:param,").append(BREAK_ROW);
                sb.append(thirdTab).append("type:'POST',").append(BREAK_ROW);
                sb.append(thirdTab).append("cache:false,").append(BREAK_ROW);
                sb.append(thirdTab).append("success:function(data) {").append(BREAK_ROW);
                    sb.append(fouthTab).append("if(data){").append(BREAK_ROW);
                        sb.append(fifthTab).append("showModalErrorMsg(data);").append(BREAK_ROW);
                    sb.append(fouthTab).append("}else{").append(BREAK_ROW);
                        sb.append(fifthTab).append("window.location.href=locationUrl").append(";").append(BREAK_ROW);
                    sb.append(fouthTab).append("}").append(BREAK_ROW);
                sb.append(thirdTab).append("},").append(BREAK_ROW);
                sb.append(thirdTab).append("error:function(){").append(BREAK_ROW);
                    sb.append(fouthTab).append("showModalErrorMsg('提交数据异常');").append(BREAK_ROW);
                sb.append(thirdTab).append("}").append(BREAK_ROW);
            sb.append(secondTab).append("});").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionSetFormData(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        String fouthTab = TAB_1+thirdTab;
        String fifthTab = TAB_1+fouthTab;
        String sixthTab = TAB_1+fifthTab;
        sb.append(firstTab).append("function setFormData(type){").append(BREAK_ROW);
            sb.append(secondTab).append("var readFormClass = 'read-form';").append(BREAK_ROW);
            sb.append(secondTab).append("var editFormClass = 'edit-form';").append(BREAK_ROW);
            sb.append(secondTab).append("var id = currentId;").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery.ajax({").append(BREAK_ROW);
                sb.append(thirdTab).append("url:locationUrl+'").append("/findbyid',").append(BREAK_ROW);
                sb.append(thirdTab).append("data:{id:id},").append(BREAK_ROW);
                sb.append(thirdTab).append("type:'GET',").append(BREAK_ROW);
                sb.append(thirdTab).append("cache:false,").append(BREAK_ROW);
                sb.append(thirdTab).append("success:function(data) {").append(BREAK_ROW);
                    sb.append(fouthTab).append("if(data){").append(BREAK_ROW);
                        sb.append(fifthTab).append("if(type=='edit'){").append(BREAK_ROW);
                            sb.append(sixthTab).append("setEditFormData(data);").append(BREAK_ROW);
                        sb.append(fifthTab).append("}else if(type=='read'){").append(BREAK_ROW);
                            sb.append(sixthTab).append("setReadFormData(data);").append(BREAK_ROW);
                        sb.append(fifthTab).append("}").append(BREAK_ROW);
                    sb.append(fouthTab).append("}else{").append(BREAK_ROW);
                        sb.append(fifthTab).append("showModalErrorMsg('数据为空');").append(BREAK_ROW);
                    sb.append(fouthTab).append("}").append(BREAK_ROW);
                sb.append(thirdTab).append("},").append(BREAK_ROW);
                sb.append(thirdTab).append("error:function(){").append(BREAK_ROW);
                    sb.append(fouthTab).append("showModalErrorMsg('查询数据异常');").append(BREAK_ROW);
                sb.append(thirdTab).append("}").append(BREAK_ROW);
            sb.append(secondTab).append("});").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionHideModal(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("function hideModal(){").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('#myModal').modal('hide');").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    /*private String functionInitEditFormData(String firstTab,List<FieldModel> fieldModelList){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        sb.append(firstTab).append("function initEditFormData(){").append(BREAK_ROW);
        if (!CollectionUtils.isEmpty(fieldModelList)) {
            for (FieldModel fieldModel : fieldModelList) {
                sb.append(secondTab).append("jQuery('#").append(fieldModel.getId()).append("').val('');").append(BREAK_ROW);
            }
        }
        sb.append(secondTab).append("jQuery('#id').val(0);").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }*/
    private String functionSetEditFormData(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        String fourthTab = thirdTab+TAB_1;
        sb.append(firstTab).append("function setEditFormData(data){").append(BREAK_ROW);
            sb.append(secondTab).append("$(\"form[id='editForm']\")[0].reset();").append(BREAK_ROW);
            sb.append(secondTab).append("if(data){").append(BREAK_ROW);
                sb.append(thirdTab).append("for (var i in data) {").append(BREAK_ROW);
                    sb.append(fourthTab).append("var fieldid = i;").append(BREAK_ROW);
                    sb.append(fourthTab).append("var v = data[i];").append(BREAK_ROW);
                    sb.append(fourthTab).append("jQuery('#'+fieldid,$(\"form[id='editForm']\")).val(v);").append(BREAK_ROW);
                sb.append(thirdTab).append("}").append(BREAK_ROW);
            sb.append(secondTab).append("}").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    private String functionSetReadFormData(String firstTab){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        String fourthTab = thirdTab+TAB_1;
        sb.append(firstTab).append("function setReadFormData(data){").append(BREAK_ROW);
            sb.append(secondTab).append("jQuery('.read-form-field-value').html('');").append(BREAK_ROW);
            sb.append(secondTab).append("if(data){").append(BREAK_ROW);
                sb.append(thirdTab).append("for (var i in data) {").append(BREAK_ROW);
                    sb.append(fourthTab).append("var fieldid = i;").append(BREAK_ROW);
                    sb.append(fourthTab).append("var v = data[i];").append(BREAK_ROW);
                    sb.append(fourthTab).append("jQuery('.read-form-'+fieldid).html(v);").append(BREAK_ROW);
                sb.append(thirdTab).append("}").append(BREAK_ROW);
            sb.append(secondTab).append("}").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }
    /*private String functionSetReadFormData(String firstTab,List<FieldModel> fieldModelList){
        StringBuilder sb = new StringBuilder();
        String secondTab = firstTab+TAB_1;
        String thirdTab = secondTab+TAB_1;
        sb.append(firstTab).append("function setReadFormData(data){").append(BREAK_ROW);
            sb.append(secondTab).append("initEditFormData();").append(BREAK_ROW);
            sb.append(secondTab).append("if(data){").append(BREAK_ROW);
            if (!CollectionUtils.isEmpty(fieldModelList)) {
                for (FieldModel fieldModel : fieldModelList) {
                    sb.append(thirdTab).append("jQuery('.read-form-").append(fieldModel.getId()).append("').html(data.").append(fieldModel.getId()).append(");").append(BREAK_ROW);
                }
            }
            sb.append(secondTab).append("}").append(BREAK_ROW);
        sb.append(firstTab).append("}").append(BREAK_ROW);
        return sb.toString();
    }*/


    private  List<FieldModel>  getFieldModelList(Class clazz){
        List<FieldModel> list = new ArrayList<FieldModel>();
        FormGlobalSetting formGlobalSetting = clazz.getAnnotation(FormGlobalSetting.class)==null?null:(FormGlobalSetting)clazz.getAnnotation(FormGlobalSetting.class);
        if (formGlobalSetting != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                if (!field.getName().equals("id")) {
                    InputType fieldAnnotation = field.getAnnotation(InputType.class)==null?null:(InputType)field.getAnnotation(InputType.class);
                    if (fieldAnnotation != null) {
                        FieldModel fieldModel = new FieldModel();
                        String id = field.getName();
                        InputType.type inputtype = fieldAnnotation.value();
                        String name = fieldAnnotation.name();
                        boolean showInEditForm = fieldAnnotation.showInEditForm();
                        boolean showInReadForm = fieldAnnotation.showInReadForm();
                        boolean showInList = fieldAnnotation.showInList();
                        fieldModel.setId(id);
                        fieldModel.setName(name);
                        fieldModel.setType(inputtype.name());
                        fieldModel.setShowInEditForm(showInEditForm);
                        fieldModel.setShowInList(showInList);
                        fieldModel.setShowInReadForm(showInReadForm);
                        list.add(fieldModel);
                    }
                }
            }
        }
        return list;
    }
    public String genStr(Class clazz,String baseurl,String caption) {
        StringBuilder sb = new StringBuilder();
        /*FormGlobalSetting formGlobalSetting = clazz.getAnnotation(FormGlobalSetting.class)==null?null:(FormGlobalSetting)clazz.getAnnotation(FormGlobalSetting.class);
        String baseurl = "";
        String caption = "";
        if (formGlobalSetting!=null) {
            baseurl = formGlobalSetting.baseurl();
            caption = formGlobalSetting.tableCaption();
        }*/
        List<FieldModel> list = getFieldModelList(clazz);
        sb.append(htmlHeader());
        sb.append(head());
        sb.append(vmScript());
        sb.append(body(caption,list));
        sb.append(modal());
        sb.append(readScriptTemplate(list));
        sb.append(editScriptTemplate(list));
        sb.append(javascript(list,baseurl));
        sb.append(htmlFoot());
        return sb.toString();
    }

    public void gen(Class clazz,String baseurl,String caption){
        try {
            String domainname = clazz.getSimpleName();
            String vmname = domainname.toLowerCase()+".vm";
            String path = FileUtils.getFilePath(domainname);
            String s = genStr(clazz,baseurl,caption);
            String filename = path+File.separator+vmname;
            FileUtils.writeFile(filename,s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
//        System.out.println(vmSourceGenerateService.generate(Action.class));
//        GenVmSourceUtil vmSourceGenerateService = new GenVmSourceUtil();
//        vmSourceGenerateService.genVm("user.vm","user");
        /*Class cls = VmSourceGenerateServiceImpl.class;
        ClassLoader loader=cls.getClassLoader();
        String clsName=cls.getName()+".class";
        Package pack=cls.getPackage();
        String path="";
        if(pack!=null){
            String packName=pack.getName();
            //此处简单判定是否是Java基础类库，防止用户传入JDK内置的类库
            if(packName.startsWith("java.")||packName.startsWith("javax."))
                throw new java.lang.IllegalArgumentException("不要传送系统类！");
            //在类的名称中，去掉包名的部分，获得类的文件名
            clsName=clsName.substring(packName.length()+1);
            //判定包名是否是简单包名，如果是，则直接将包名转换为路径，
            if(packName.indexOf(".")<0) path=packName+"/";
            else{//否则按照包名的组成部分，将包名转换为路径
                int start=0,end=0;
                end=packName.indexOf(".");
                while(end!=-1){
                    path=path+packName.substring(start,end)+"/";
                    start=end+1;
                    end=packName.indexOf(".",start);
                }
                path=path+packName.substring(start)+"/";
            }
        }
        //调用ClassLoader的getResource方法，传入包含路径信息的类文件名
        java.net.URL url =loader.getResource(path);
        java.net.URL url2 =loader.getResource(path+clsName);
        System.out.println(url);
        System.out.println(url2);*/
    }
}
