package com.yao.handle.ability;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.yao.handle.channel.FactoryForSchema;
import com.yao.handle.channel.GenerateSchemaService;
import com.yao.handle.postman.PostmanCollection;
import com.yao.handle.postman.PostmanItem;
import com.yao.handle.postman.PostmanQuery;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @className ParseAbilityList
 * @description: 创建能力list合集
 * @author: yaoyao
 * @create: 2020/03/03 16:13
 */
@Slf4j
public class ParseAbilityList {
    private final static String get = "GET";
    private final static String post = "POST";

    private List list = new ArrayList();

    public void addAbility(AbilityModel abilityModel) {
        this.list.add(abilityModel);
    }

    public List getAbilityList() {
        return list;
    }

    public void parsePostMan(PostmanItem postmanItem) {
        if (postmanItem.getRequest() != null) {
            try {
                AbilityModel abilityModel = new AbilityModel();
                if (get.equalsIgnoreCase(postmanItem.getRequest().getMethod())) {
                    paresGet(postmanItem, abilityModel);
                } else if (post.equalsIgnoreCase(postmanItem.getRequest().getMethod())) {
                    parePost(postmanItem, abilityModel);
                } else {
                    abilityModel.setFlag(false);
                    abilityModel.setMsg("请求方式不支持");
                }
            } catch (Exception e) {
                pareException(postmanItem, e);
            }
        }
        if (postmanItem.getItems().size() > 0) {
            postmanItem.getItems().forEach(a -> parsePostMan(a));
        }
    }

    private void pareException(PostmanItem postmanItem, Exception e) {
        log.error("服务部署失败：", e);
        AbilityModel abilityModel = new AbilityModel();
        abilityModel.setAbilityName(postmanItem.getName());
        abilityModel.setFlag(false);
        abilityModel.setMsg(e.getMessage());
        addAbility(abilityModel);
    }

    private void parePost(PostmanItem postmanItem, AbilityModel abilityModel) throws JsonProcessingException {
        GenerateSchemaService strategy = FactoryForSchema.getStrategy(postmanItem.getRequest().getBody().getMode());
        strategy.invokGeenerateSchema(abilityModel, postmanItem);
        abilityModel.setAbilityName(postmanItem.getName());
        generateUrl(abilityModel, postmanItem);
        abilityModel.setMode(postmanItem.getRequest().getBody().getMode());
        abilityModel.setRemark(postmanItem.getRequest().getDescription());
        addAbility(abilityModel);
    }

    private void paresGet(PostmanItem postmanItem, AbilityModel abilityModel) throws JsonProcessingException {
        List<PostmanQuery> queries = postmanItem.getRequest().getUrl().getQueries();
        if (queries.size() < 1) {
            log.error("获取请求参数异常");
        } else {
            Map map = new HashMap();
            JsonMapper jsonMapper = new JsonMapper();
            queries.forEach(a -> map.put(a.getKey(), a.getValue()));
            abilityModel.setReqJsonschema(jsonMapper.writeValueAsString(map));
        }
    }

    public void parsePostmanCollection(PostmanCollection postmanCollection) {
        postmanCollection.getItems().forEach(a -> parsePostMan(a));
    }

    private void generateUrl(AbilityModel abilityModel, PostmanItem postmanItem) {
        String raw = postmanItem.getRequest().getUrl().getRaw();
        if (raw.contains("?")) {
            System.out.println();
            raw = raw.substring(0, raw.indexOf("?"));
        }
        if (raw.startsWith("${url}")) {
            String replace = raw.replace("${url}", "");
            generatePath(abilityModel, replace);
        } else if (raw.startsWith("http:")) {
            String replace = raw.replace("http://", "");
            generatePath(abilityModel, replace);
        } else if (raw.startsWith("https:")) {
            String replace = raw.replace("https://", "");
            generatePath(abilityModel, replace);
        } else {
            abilityModel.setFlag(false);
            abilityModel.setMsg("服务地址错误：" + raw);
        }
    }

    private void generatePath(AbilityModel abilityModel, String replace) {
        abilityModel.setAbilityEname(Arrays.asList(replace.split("/")).stream().skip(1).collect(Collectors.joining("_")));
        abilityModel.setAppCodePath(Arrays.asList(replace.split("/")).stream().skip(1).collect(Collectors.joining("/", "/", "")));
    }
}
