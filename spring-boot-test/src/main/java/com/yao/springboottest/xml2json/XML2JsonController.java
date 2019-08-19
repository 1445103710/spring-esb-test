package com.yao.springboottest.xml2json;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className XML2JsonController
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/08/19 15:57
 */
@RestController
@RequestMapping("/xml2json")
@Slf4j
public class XML2JsonController {

    @RequestMapping("test")
    public String xml2json(@RequestBody String xml){
        log.info("请求》》》"+xml);
        String json = DataFormatUtil.XmlToJson(xml);
        log.info("返回《《《"+json);
        return json;
    }
}
