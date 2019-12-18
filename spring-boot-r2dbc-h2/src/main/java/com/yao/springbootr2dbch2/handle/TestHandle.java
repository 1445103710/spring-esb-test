package com.yao.springbootr2dbch2.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
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

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        log.info(serverRequest.methodName());
//        ConnectionFactory connectionFactory = ConnectionFactories.get(ConnectionFactoryOptions.builder()
//                .option(DRIVER, "h2")
////                .option(PROTOCOL, "...")  // file, mem
////                .option(DATABASE, "...")
//                .build());
        ConnectionFactory connectionFactory = new H2ConnectionFactory(H2ConnectionConfiguration.builder()
                .inMemory("...")
                .option(H2ConnectionOption.DB_CLOSE_DELAY, "-1")
                .build());
        Mono<Connection> connection = connectionFactory.create();
        connection.createStatement("INSERT INTO person (id, first_name, last_name) VALUES ($1, $2, $3)")
                .bind("$1", 1)
                .bind("$2", "Walter")
                .bind("$3", "White")
                .execute()
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("hello dadi"));
    }
}
