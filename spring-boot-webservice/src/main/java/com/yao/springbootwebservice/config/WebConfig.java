package com.yao.springbootwebservice.config;

import com.yao.springbootwebservice.service.CommonService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 * @className WebConfig
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/10/22 15:35
 */
@Configuration
public class WebConfig {
    @Autowired
    private Bus bus;

    @Autowired
    CommonService service;

    /*jax-ws*/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, service);
        endpoint.publish("/CommonService");
        return endpoint;
    }
}