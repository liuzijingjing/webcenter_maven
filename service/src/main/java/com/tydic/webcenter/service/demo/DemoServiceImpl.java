package com.tydic.webcenter.service.demo;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author zhanglingsi
 *         createTime: 16/4/13 18:23
 */
@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    @Override
    public String testDemoService(String testStr) {
        return testStr + "-" + "zhanglingsi";
    }
}
