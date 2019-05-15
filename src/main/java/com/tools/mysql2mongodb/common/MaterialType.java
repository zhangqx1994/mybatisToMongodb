package com.tools.mysql2mongodb.common;

import java.util.HashMap;
import java.util.Map;

public class MaterialType {

    private static Map<Integer,String> materialType = new HashMap<>();

    public static Map<Integer,String> getMaterialType(){
        if(materialType.size()==0){
            materialType.put(1,"其他");
            materialType.put(11,"电视剧");
            materialType.put(12,"体育");
            materialType.put(13,"电影");
            materialType.put(14,"动漫");
            materialType.put(15,"纪录片");
            materialType.put(16,"科教");
            materialType.put(17,"综艺");
            materialType.put(18,"音乐");
            materialType.put(19,"娱乐");
            materialType.put(20,"新闻");
            materialType.put(21,"栏目");
            materialType.put(22,"生活");
            materialType.put(23,"法治");
            materialType.put(24,"少儿");
            materialType.put(25,"资讯");
            materialType.put(26,"电大教育");
            materialType.put(27,"财经");
            materialType.put(28,"戏曲");
            materialType.put(29,"国家电网");
            materialType.put(30,"无");
            materialType.put(31,"微视频");
            materialType.put(32,"教育");
            materialType.put(33,"电子竞技");
            materialType.put(34,"旅游");
            materialType.put(35,"摩洛哥");
            materialType.put(36,"Movies");
            materialType.put(37,"TV Shows");
            materialType.put(38,"Animation");
            materialType.put(39,"Documentaries");
            materialType.put(40,"巴西世界杯");
            materialType.put(41,"微电影");
            materialType.put(42,"购物");
            materialType.put(43,"曲艺");
            materialType.put(47,"央视名栏");
            materialType.put(51,"搞笑");
            materialType.put(52,"军事");
            materialType.put(53,"汽车2");
            materialType.put(54,"科技");
            materialType.put(55,"时尚");
            materialType.put(56,"母婴");
            materialType.put(57,"脱口秀");
            materialType.put(58,"原创");
            materialType.put(59,"健康");
            materialType.put(60,"农业");
            materialType.put(61,"儿童");
            materialType.put(62,"测试");
            materialType.put(63,"测试");
            materialType.put(64,"测试");
            materialType.put(65,"测试");
            materialType.put(66,"测试");
            materialType.put(67,"测试");
            materialType.put(68,"a_测试");
            materialType.put(69,"汽车1");
            materialType.put(70,"汽车3");
            materialType.put(71,"汽车4");
            materialType.put(72,"军事");
        }

        return materialType;
    }

}
