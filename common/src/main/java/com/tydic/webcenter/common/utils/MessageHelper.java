package com.tydic.webcenter.common.utils;

import java.text.MessageFormat;


public class MessageHelper {

    public MessageHelper() {
    }

    public static String formatMsg(String msgTemplate, Object... positionValues) {
        try {
            return MessageFormat.format(msgTemplate, positionValues);
        } catch (Exception var5) {
            StringBuilder buf = new StringBuilder("资源信息占位符替换异常，占位符参数信息：");

            for (int i = 0; i < positionValues.length; ++i) {
                buf.append(" arg[" + i + "]=" + positionValues[i]);
            }

            return msgTemplate;
        }
    }
}