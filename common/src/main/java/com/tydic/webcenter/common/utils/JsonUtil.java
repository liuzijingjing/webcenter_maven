package com.tydic.webcenter.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtil {
    public JsonUtil() {
    }

    public static String toJSONString(Object obj) {
        String value;
        if (obj instanceof String) {
            value = obj + "";
        } else {
            value = JSONObject.toJSONString(obj);
        }

        return value;
    }

    public static <T> T toObject(String key, Class<T> clazz) {
        return JSONObject.parseObject(key, clazz);
    }

    public static <T> List<T> toList(String key, Class<T> clazz) {
        return JSONObject.parseArray(key, clazz);
    }
}
