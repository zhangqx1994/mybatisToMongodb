package com.tools.mysql2mongodb.common;

import java.util.HashMap;
import java.util.Map;

public class Definiton {

    private static Map<String,String> definiton = new HashMap<>();

    public static Map<String,String> getDefiniton(){
        if (definiton.size()==0){
            definiton.put("4K","4K");
            definiton.put("BD","蓝光");
            definiton.put("CESHI","测试");
            definiton.put("HD","高清");
            definiton.put("LD","流畅");
            definiton.put("OD","原画");
            definiton.put("SD","标清");
            definiton.put("XD","超清");
        }
        return definiton;
    }
}
