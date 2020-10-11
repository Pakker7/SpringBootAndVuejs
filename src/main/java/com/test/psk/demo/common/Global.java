package com.test.psk.demo.common;

import com.google.gson.Gson;

import java.util.HashMap;

public class Global {

    //return
    public static final String RESULT = "result";

    public static class Return {
        public static String resultJson(Object obj){
            Gson gson = new Gson();
            HashMap<String, Object> map = new HashMap<>();
            map.put(RESULT, obj);
            return gson.toJson(map);
        }
    }


}
