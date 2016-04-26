package com.tydic.webcenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.tydic.webcenter.common.utils.Response;
import com.tydic.webcenter.common.utils.SystemConstant;
import com.tydic.webcenter.service.demo.UserInfoService;
import com.tydic.webcenter.service.model.UserDTO;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Reference(version = SystemConstant.SERVICE_DUBBO_VERSION)
    private UserInfoService userInfoService;

    @RequestMapping
    public PageInfo<UserDTO> getAll(UserDTO userInfo) {
        Response<List<UserDTO>> response = userInfoService.getAll(userInfo);
        return new PageInfo<UserDTO>(response.getResult());
    }

    @RequestMapping(value = "/add")
    public UserDTO add() {
        return new UserDTO();
    }

    @RequestMapping(value = "/view/{id}")
    public UserDTO view(@PathVariable Integer id) {
        ModelAndView result = new ModelAndView();
        Response<UserDTO> userInfo = userInfoService.getById(Long.valueOf(id.toString()));
        return userInfo.getResult();
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable Integer id) {
        ModelMap result = new ModelMap();
        if(userInfoService.deleteById(Long.valueOf(id.toString())).getResult()){
            result.put("msg", "删除成功!");
        }else {
            result.put("msg", "删除失败!");
        }
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(UserDTO userInfo) {
        ModelMap result = new ModelMap();
        String msg = null;
        if(userInfoService.save(userInfo).getResult()){
            msg = userInfo.getId() == null ? "新增成功!" : "更新成功!";
        } else {
            msg = userInfo.getId() == null ? "新增失败!" : "更新失败!";
        }
        result.put("userInfo", userInfo);
        result.put("msg", msg);
        return result;
    }
}
