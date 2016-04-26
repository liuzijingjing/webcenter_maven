package com.tydic.webcenter.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/14 18:13
 */
public class ErrorHandleController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/screen/error";
    }


    @RequestMapping
    public String errorHandle(){
        return getErrorPath();
    }
}
