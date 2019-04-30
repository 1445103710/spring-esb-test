//package com.yao.springbootwebflux.filter;
//
//import com.yao.springbootwebflux.util.GsonUtils;
//
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//
//import java.util.Map;
//
//import reactor.core.publisher.Mono;
//
///**
// * @author yaoyao
// * @version 1.0
// * @createDate 2019/04/19 9:26
// * @Description:
// * @see com.yao.springbootwebflux.filter
// */
//public class BodyWebFilter implements WebFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        ServerRequest serverRequest = new DefaultServerRequest(exchange);
//        return serverRequest.bodyToMono(String.class).flatMap(body -> {
//            System.out.println(body);
//            return chain.filter(exchange);
//        });
//
////        return serverRequest.bodyToMono(String.class)
////                .flatMap(body -> {
////                    final Map<String, Object> paramMap = GsonUtils.getInstance().toObjectMap(body);
////                    return Mono.just("1233");
////                });
//        }
//}
//
