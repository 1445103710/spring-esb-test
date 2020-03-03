package com.yao.handle.ability;

import com.yao.handle.postman.PostmanCollection;
import com.yao.handle.postman.PostmanItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @className ParseAbilityList
 * @description: 创建能力list合集
 * @author: yaoyao
 * @create: 2020/03/03 16:13
 */
public class ParseAbilityList {

    private List list = new ArrayList();

    public void addAbility(AbilityModel abilityModel) {
        this.list.add(abilityModel);
    }

    public List getAbilityList() {
        return list;
    }

    public void parsePostMan(PostmanItem postmanItem) {
        if (postmanItem.getRequest() != null) {
            AbilityModel build = AbilityModel.builder().abilityName(postmanItem.getName()).build();
            addAbility(build);
        }
        if (postmanItem.getItems().size() > 0) {
            postmanItem.getItems().forEach(a -> parsePostMan(a));
        }
    }

    public void parsePostmanCollection(PostmanCollection postmanCollection) {
        postmanCollection.getItems().forEach(a -> parsePostMan(a));
    }


}
