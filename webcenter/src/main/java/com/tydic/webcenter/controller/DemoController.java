package com.tydic.webcenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tydic.webcenter.service.demo.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 16/4/13 18:26
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Reference(version = "1.0.0", check = false)
    private DemoService demoService;

    @RequestMapping("/test")
    @ResponseBody
    public String demoTest() {
        String str = "demoTest";
        log.info("demoTest=================================================================:{}", str);
        return demoService.testDemoService(str);
    }

}
