package com.xqg.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtils {

    public static Map<String,Object> result(String code, String message, Object data){

        Map<String ,Object> resultMap = new HashMap<>();

        resultMap.put("data",data);
        resultMap.put("code",code);
        resultMap.put("message",message);

        return resultMap;
    }

}
