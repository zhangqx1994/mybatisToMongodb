package com.tools.mysql2mongodb.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public  class LanguageType {

    private static Map<Integer,String> language = new HashMap<>();

    public static Map<Integer,String> getLanguage(){
        if (language.size()==0){
            language.put(1,"其他");
            language.put(11,"普通话");
            language.put(13,"英语");
            language.put(14,"粤语");
            language.put(15,"日语");
            language.put(16,"韩语");
            language.put(17,"法语");
            language.put(18,"德语");
            language.put(19,"意大利语");
            language.put(20,"中文");
            language.put(21,"英文");
        }
        return language;
    }
}
