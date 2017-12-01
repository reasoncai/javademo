package com.cai.javademo.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by reason on 17/12/1.
 */
public class JsonTest {
    public static void main(String[] args) {
        int[] ints = new int[3];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids",ints);
        System.out.println(jsonObject.toString());
        JSONArray ids = jsonObject.getJSONArray("ids");
        System.out.println(ids.toString());
        Integer[] integers = new Integer[3];
        ids.toArray(integers);
        System.out.println(integers[1]);
        Object[] objects = ids.toArray();
        System.out.println(objects[2]);
    }
}
