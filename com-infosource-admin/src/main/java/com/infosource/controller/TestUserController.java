package com.infosource.controller;

import com.infosource.domain.common.PageVo;
import com.infosource.domain.org.User;
import com.infosource.domain.org.query.UserQuery;
import com.infosource.service.org.TestUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangrongtao on 16/4/20.
 */
@Controller
@RequestMapping("/test")
public class TestUserController {
    public static final int PAGE_SIZE = 20;
    @Resource
    private TestUserService testUserService;

    @RequestMapping()
    public String view(Integer page,ModelMap model){
        if (page == null) {
            page=1;
        }
        UserQuery userQuery = new UserQuery();
        userQuery.setPage(page);
        userQuery.setPageSize(PAGE_SIZE);
        PageVo<User> pageVo =  testUserService.findListByPage(userQuery);
        model.put("pageVo", pageVo);
        return "/test/user";
    }
    /*@ResponseBody
    @RequestMapping("/findbyid")
    public CustomsTO findbyid(long id)throws Exception{
        CustomsTO customsTO = customsPlatformService.findbyid(id);
        return customsTO;
    }
    @ResponseBody
    @RequestMapping("/remove")
    public void remove(long id)throws Exception{
        customsPlatformService.deletebyidInTransaction(id);
    }
    @ResponseBody
    @RequestMapping("/edit")
    public String save(HttpServletRequest request, CustomsTO customsTO, BindingResult result)throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError objectError : list) {
                stringBuilder.append(objectError.getDefaultMessage()).append("<br>");
            }
        }else{
            String pin = LoginContext.getLoginContext().getPin();
            customsTO.setOperatorId(pin);
            String msg = null;
            if (customsTO.getId() < 1) {
                msg = customsPlatformService.save(customsTO);
            }else{
                msg = customsPlatformService.update(customsTO);
            }
            if (!StringUtils.isEmpty(msg)) {
                stringBuilder.append(msg);
            }
        }
        return stringBuilder.toString();
    }*/
}
