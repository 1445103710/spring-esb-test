//package com.yao.springbootwebserviceclient.test;
//
//import com.yao.springbootwebserviceclient.service.CommonService;
//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
//import org.junit.jupiter.api.Test;
//
///**
// * @className TestWebserviceClient
// * @description: TODO
// * @author: yaoyao
// * @create: 2019/10/22 16:49
// */
////@SpringBootTest
//public class TestWebserviceClient {
//
//    /**
//     * 方式1.代理类工厂的方式,需要拿到对方的接口
//     */
//    @Test
//    public void cl1() {
//        try {
//            System.out.println("开始调用:");
//            // 接口地址
//            String address = "http://localhost:8081/yaoyao/CommonService?wsdl";
//            // 代理工厂
//            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
//            // 设置代理地址
//            jaxWsProxyFactoryBean.setAddress(address);
//            // 设置接口类型
//            jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
//            // 创建一个代理接口实现
//            CommonService cs = (CommonService) jaxWsProxyFactoryBean.create();
//            // 数据准备
//            String userName = "Leftso";
//            // 调用代理接口的方法调用并返回结果
//            String result = cs.HelloWorld(userName);
//            System.out.println("返回结果:" + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 动态调用方式
//     */
//    @Test
//    public void cl2() {
//        // 创建动态客户端
//        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//        Client client = dcf.createClient("http://localhost:8081/yaoyao/CommonService?wsdl");
//        // 需要密码的情况需要加上用户名和密码
//        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
//        // PASS_WORD));
//        Object[] objects = new Object[0];
//        try {
//            // invoke("方法名",参数1,参数2,参数3....);
//            objects = client.invoke("HelloWorld", "Leftso");
//            System.out.println("返回数据:" + objects[0]);
//        } catch (java.lang.Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
