package com.yao.springboottest.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className AbilityJsonController
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/11/04 15:07
 */
@Slf4j
@RestController
@RequestMapping(value = "/json")
public class AbilityJsonController {

    @RequestMapping("validateJson")
    @ResponseBody
    public String ValidateJson(@RequestBody String json) {
        log.info("请求报文>>>" + json);
        JSONObject.parseObject(json);
        log.info("返回报文<<<" + json);
        return "";
    }

    @RequestMapping("validateGsonJson")
    @ResponseBody
    public String ValudateGsonJson(@RequestBody String json) {
        Object parse = JSON.parse(json);
        Object o = parseObject(parse);
        return JSON.toJSONString(o);
    }

    public static JSONObject parseJsonObject(JSONObject json) {
        JSONObject jsonObject = new JSONObject();
        json.forEach((k, v) -> {
            jsonObject.put(k,parseObject(v));
        });
        return jsonObject;
    }

    public static JSONArray parseJsonArray(JSONArray json) {
        JSONArray jsonArray = new JSONArray();
        if (json.size()<1){
            json.add("无");
        }
        //默认只添加一个数组值
//        json.forEach((a)->{
//            jsonArray.add(parseObject(a));
//        });
        jsonArray.add(parseObject(json.get(0)));
        return jsonArray;
    }

    public static Object parseObject(Object json) {
        if (StringUtils.isEmpty(json)) {
            return "无";
        }else if (json instanceof JSONObject){
            return parseJsonObject((JSONObject)json);
        }else if (json instanceof JSONArray){
            return parseJsonArray((JSONArray)json);
        }else if (json instanceof String){
            if ("null".equalsIgnoreCase(String.valueOf(json))){
                return "无";
            }
            return json;
        }else if (json instanceof Long){
            return json;
        }else if (json instanceof Integer){
            return json;
        }else if (json instanceof Boolean){
            return json;
        }
        return "暂不支持类型";
    }

    public static final String XML_PRE = "<xml>";
    public static final String XML_END = "</xml>";

    @RequestMapping("validateXml")
    @ResponseBody
    public String validateXml(@RequestBody String xml) {
        return fomateXml(xml);
    }

    public static String fomateXml(String xml){
        String replace = xml.replace(XML_PRE, "");
        return replace.replace(XML_END,"");
    }
}
