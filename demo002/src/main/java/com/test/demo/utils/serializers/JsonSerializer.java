package com.test.demo.utils.serializers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by huangguoping
 */
public class JsonSerializer {
    static ObjectMapper mapper = new ObjectMapper();
    public static String toJson(Object object){
        try {
            StringWriter str = new StringWriter();
            mapper.writeValue(str,object);
            return str.toString();
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public static <T>T from(String json, Class<T> type){
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        try {
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
            T t = mapper.readValue(json, type);
            return t;
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public static JsonNode readToNode (String json){
        try{
            return mapper.readTree(json);
        }catch (Exception e) {
        }
        return null;
    }
}
