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
import javax.validation.Valid;
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
    public String view(UserQuery userQuery,ModelMap model){
        if (userQuery.getPage() <1) {
            userQuery.setPage(1);
        }
        userQuery.setPageSize(PAGE_SIZE);
        PageVo<User> pageVo =  testUserService.findListByPage(userQuery);
        model.put("pageVo", pageVo);
        model.put("queryobj", userQuery);
        return "/test/user";
    }
    @ResponseBody
    @RequestMapping("/findbyid")
    public User findbyid(long id)throws Exception{
        User user = testUserService.findById(id);
        return user;
    }
    @ResponseBody
    @RequestMapping("/remove")
    public int remove(long id)throws Exception{
        return testUserService.deleteById(id);
    }
    @ResponseBody
    @RequestMapping("/edit")
    public String save(HttpServletRequest request, @Valid User user, BindingResult result)throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError objectError : list) {
                stringBuilder.append(objectError.getDefaultMessage()).append("<br>");
            }
        }else{
            int effectrow = 0;
            if (user.getId() < 1) {
                effectrow = testUserService.save(user);
            }else{
                effectrow = testUserService.update(user);
            }
            if (effectrow<1) {
                stringBuilder.append("操作失败") ;
            }
        }
        return stringBuilder.toString();
    }
}
