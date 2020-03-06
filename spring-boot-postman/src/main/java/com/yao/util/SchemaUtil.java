package com.yao.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @className SchemaUtil
 * @description: 用来转化json到schema方法
 * @author: yaoyao
 * @create: 2020/03/05 11:41
 */
@Slf4j
public class SchemaUtil {

    private final static String SCHEMA_KEY = "$schema";
    private final static String SCHEMA_TYPE = "type";
    private final static String SCHEMA_PROPERTIES = "properties";
    private final static String SCHEMA_DESCRIPTION = "description";
    private final static String SCHEMA_ITEMS = "items";
    private final static String SCHEMA_PATH_SEPARATOR = "/";
    private final static String SCHEMA_OBJECT = "object";
    private final static String SCHEMA_ARRAY = "array";
    private final static String SCHEMA_STRING = "string";
    private final static String SCHEMA_NUMBER = "number";
    private final static String SCHEMA_BOOLEAN = "boolean";
    private final static String SCHEMA_ROOT = "root";
    private final static String SCHEMA_4 = "http://json-schema.org/draft-04/schema#";

    /**
     * 解析json字符串
     *
     * @param json
     * @return
     * @throws JsonProcessingException
     */
    public static String json2Schema(String json) throws JsonProcessingException {
        Map nodes = new LinkedHashMap();
        JsonMapper jsonMapper = new JsonMapper();
        Map map = jsonMapper.readValue(json, Map.class);
        parseObject(nodes, SCHEMA_ROOT, map, true);
        Map schema = (Map) nodes.get(SCHEMA_ROOT);
        return jsonMapper.writeValueAsString(schema);
    }

    /**
     * 解析对象型json
     *
     * @param map
     * @param k    字段key
     * @param v    字段value
     * @param flag 用于判断是否是第一个参数
     */
    private static void parseObject(Map map, Object k, Object v, Boolean flag) {
        Map nodes = new LinkedHashMap();
        Map node = new LinkedHashMap();
        ((Map) v).forEach((x, y) -> {
            if (y instanceof Map) {
                parseObject(node, x, y, false);
            } else if (y instanceof List) {
                paresArray(node, x, y);
            } else {
                parseBase(node, x, y);
            }
        });
        if (flag) {
            nodes.put(SCHEMA_KEY, SCHEMA_4);
        }
        nodes.put(SCHEMA_TYPE, SCHEMA_OBJECT);
        nodes.put(SCHEMA_PROPERTIES, node);
        map.put(k, nodes);
    }


    /**
     * 解析数组
     *
     * @param map
     * @param k
     * @param v
     */
    private static void paresArray(Map map, Object k, Object v) {
        Map nodes = new LinkedHashMap();
        Map node = new LinkedHashMap();
        ArrayList<Object> obj = new ArrayList<>();
        ((List) v).forEach((l) -> {
            if (l instanceof Map) {
                parseObject(node, k, l, false);
                obj.add(node.get(k));
            } else if (l instanceof List) {
                paresArray(node, k, l);
            } else {
                parseBase(node, k, l);
            }
        });
        mergeArray(k, node, obj);
        nodes.put(SCHEMA_TYPE, SCHEMA_ARRAY);
        nodes.put(SCHEMA_ITEMS, node.get(k));
        map.put(k, nodes);
    }

    private static void mergeArray(Object k, Map node, ArrayList<Object> obj) {
        if (obj.size() > 1) {
            Map nodeObj = new LinkedHashMap();
            Map nodeObjs = new LinkedHashMap();
            obj.forEach((a) -> {
                Map maps = (Map) a;
                Map map1 = (Map) maps.get(SCHEMA_PROPERTIES);
                map1.forEach((m, n) -> {
                        nodeObj.put(m,n);
                });
            });
            nodeObjs.put(SCHEMA_TYPE, SCHEMA_OBJECT);
            nodeObjs.put(SCHEMA_PROPERTIES, nodeObj);
            node.put(k, nodeObjs);
        }
    }

    /**
     * 用于解析基础类型
     *
     * @param map
     * @param k
     * @param v
     */
    private static void parseBase(Map map, Object k, Object v) {
        Map node = new LinkedHashMap();
        if (v instanceof Integer) {
            node.put(SCHEMA_TYPE, SCHEMA_NUMBER);
        } else if (v instanceof Boolean) {
            node.put(SCHEMA_TYPE, SCHEMA_BOOLEAN);
        } else {
            node.put(SCHEMA_TYPE, SCHEMA_STRING);
        }
        map.put(k, node);
    }
}
