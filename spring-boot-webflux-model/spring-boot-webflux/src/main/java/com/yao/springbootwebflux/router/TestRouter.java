package com.yao.springbootwebflux.router;

import com.yao.springbootwebflux.handle.TestHandle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * @ProjectName: spring-esb-test
 * @Package: com.yao.springbootwebflux.router
 * @ClassName: TestRouter
 * @Description: java类作用描述
 * @Author: yaoyao
 * @CreateDate: 2019/4/13 0013 下午 11:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/4/13 0013 下午 11:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
public class TestRouter {
    @Bean
    public RouterFunction<ServerResponse> routTest(TestHandle testHandle){
        return RouterFunctions
                .route(RequestPredicates.GET("/test")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        testHandle::hello);
    }
    @Bean
    public RouterFunction<ServerResponse> routTest2(TestHandle testHandle){
        return RouterFunctions
                .route(RequestPredicates.POST("/test")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        testHandle::hello);
    }
}
