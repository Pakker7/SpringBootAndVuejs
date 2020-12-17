package com.test.psk.demo.web.common;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.psk.demo.web.config.LocalDateTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Global {

    //return
    public static final String RESULT = "result";

    public static class Return {
        public static String resultJson(Object obj){
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();

            HashMap<String, Object> map = new HashMap<>();
            map.put(RESULT, obj);
            return gson.toJson(map);
        }
    }


}
