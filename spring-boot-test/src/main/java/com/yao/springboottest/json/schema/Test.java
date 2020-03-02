package com.yao.springboottest.json.schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/02/24 12:13
 */
public class Test {
    private final static String SCHEMA_KEY = "$schema";
    private final static String SCHEMA_TYPE = "type";
    private final static String SCHEMA_PROPERTIES = "properties";
    private final static String SCHEMA_DESCRIPTION = "description";
    private final static String SCHEMA_ITEMS = "items";
    private final static String SCHEMA_PATH_SEPARATOR = "/";
    private final static String SCHEMA_OBJECT = "object";
    private final static String SCHEMA_ARRAY = "array";

    public static void main(String[] args) {
        String str = "{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"hsn\":{\"type\":\"string\"},\"name\":{\"type\":\"string\"},\"province\":{\"type\":\"array\",\"items\":{\"type\":\"number\"}},\"sku\":{\"type\":\"array\",\"items\":{\"type\":\"object\",\"properties\":{\"bNeedAnnex\":{\"type\":\"boolean\"},\"bNeedGift\":{\"type\":\"boolean\"},\"num\":{\"type\":\"number\"},\"price\":{\"type\":\"number\"},\"skuId\":{\"type\":\"string\"}}}},\"thirdOrder\":{\"type\":\"object\",\"properties\":{\"test\":{\"type\":\"string\"}}},\"yaoyao\":{\"type\":\"array\",\"items\":{\"type\":\"object\",\"properties\":{\"name\":{\"type\":\"string\"},\"work\":{\"type\":\"array\",\"items\":{\"type\":\"object\",\"properties\":{\"home\":{\"type\":\"string\"}}}}}}}}}";
        try {
            JsonNode mainNode = JsonLoader.fromString(str);
            Gson gson = new Gson();
            Map map = parseSchema(mainNode, "", "");
            System.out.println(gson.toJson(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析schema为obejct类型然后添加数据
     *
     * @param jsonNode
     * @return
     */
    public static Map parseSchema(final JsonNode jsonNode,final String path,final String name) {
        Map map = new LinkedTreeMap();
        Map childMap = new LinkedTreeMap();
        StringBuffer url = getUrl(path, name);

        //判断是否是初始解析
        if (url.length()>0){
            map.put(SCHEMA_TYPE, jsonNode.get(SCHEMA_TYPE).asText());
        }else {
            map.put(SCHEMA_KEY, jsonNode.get(SCHEMA_KEY).asText());
            map.put(SCHEMA_TYPE, jsonNode.get(SCHEMA_TYPE).asText());
        }
        JsonNode nodes = jsonNode.get(SCHEMA_PROPERTIES);
        nodes.fieldNames().forEachRemaining((k) -> {
            JsonNode node = nodes.get(k);
            switch (node.get(SCHEMA_TYPE).asText()) {
                case SCHEMA_OBJECT:
                    childMap.put(k,parseSchema(nodes.get(k),url.toString(),k));
                    break;
                case SCHEMA_ARRAY:
                    childMap.put(k, parseArraSchema(nodes.get(k), url.toString(), k));
                    break;
                default:
                    childMap.put(k, parseBaseSchema(nodes.get(k), url.toString(), k));
            }
        });
        map.put(SCHEMA_PROPERTIES,childMap);
        return map;
    }

    /**
     * 用于解析非obejct和array类型的json
     *
     * @param jsonNode
     * @param path
     * @param name
     * @return
     */
    public static Map parseBaseSchema(JsonNode jsonNode, String path, String name) {
        StringBuffer url = getUrl(path, name);
        Map map = new LinkedTreeMap();
        map.put(SCHEMA_TYPE, jsonNode.get(SCHEMA_TYPE).asText());
        map.put(SCHEMA_DESCRIPTION, url.toString());
        return map;
    }

    /**
     * 解析schema 中array然后添加数据
     *
     * @param jsonNode
     * @param path
     * @return
     */
    public static Map parseArraSchema(JsonNode jsonNode, String path, String name) {
        StringBuffer url = getUrl(path, name);
        Map map = new LinkedTreeMap();
        map.put(SCHEMA_TYPE, jsonNode.get(SCHEMA_TYPE).asText());
        JsonNode itemes = jsonNode.get(SCHEMA_ITEMS);
        switch (itemes.get(SCHEMA_TYPE).asText()) {
            case SCHEMA_OBJECT:
                map.put(SCHEMA_ITEMS, parseSchema(itemes, url.toString(),""));
                break;
            case SCHEMA_ARRAY:
                map.put(SCHEMA_ITEMS, parseArraSchema(itemes, url.toString(),""));
                break;
            default:
                map.put(SCHEMA_ITEMS, parseBaseSchema(itemes, url.toString(), ""));
        }
        return map;
    }

    public static StringBuffer getUrl(final String path,final String name){
        StringBuffer stringBuffer = new StringBuffer();
        if (!StringUtils.isEmpty(path)){
            stringBuffer.append(path);
        }
        if (!StringUtils.isEmpty(name)){
            stringBuffer.append(SCHEMA_PATH_SEPARATOR).append(name);
        }
        return stringBuffer;
    }
}
