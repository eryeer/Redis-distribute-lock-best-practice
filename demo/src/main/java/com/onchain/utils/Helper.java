package com.onchain.utils;

import com.alibaba.fastjson.JSONObject;

public class Helper {

    /**
     * check param whether is null or ''
     *
     * @param params
     * @return boolean
     */
    public static Boolean isEmptyOrNull(Object... params) {
        if (params != null) {
            for (Object val : params) {
                if ("".equals(val) || val == null) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static Boolean isNotEmptyOrNull(Object... params){
        return !isEmptyOrNull(params);
    }

    /**
     * judge whether the string is in json format.
     *
     * @param str
     * @return
     */
    public static Boolean isJSONStr(String str) {
        try{
            JSONObject obj = JSONObject.parseObject(str);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static String currentMethod() {
        return new Exception("").getStackTrace()[1].getMethodName();
    }


}
