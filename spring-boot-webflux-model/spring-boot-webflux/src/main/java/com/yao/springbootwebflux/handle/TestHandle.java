package com.yao.springbootwebflux.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @ProjectName: spring-esb-test
 * @Package: com.yao.springbootwebflux.handle
 * @ClassName: TestHandle
 * @Description: java类作用描述
 * @Author: yaoyao
 * @CreateDate: 2019/4/13 0013 下午 11:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/4/13 0013 下午 11:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Component
@Slf4j
public class TestHandle {

    public Mono<ServerResponse> hello(ServerRequest serverRequest){
        log.info(serverRequest.methodName());
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("hello dadi"));
    }
}
