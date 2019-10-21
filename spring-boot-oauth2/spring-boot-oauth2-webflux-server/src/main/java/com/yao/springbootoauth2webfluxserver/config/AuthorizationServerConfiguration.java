//package com.yao.springbootoauth2webfluxserver.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
///**
// * @className AuthorizationServerConfiguration
// * @description: TODO
// * @author: yaoyao
// * @create: 2019/09/04 15:34
// */
//@Configuration
//@EnableWebFluxSecurity
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//    // 注入 WebSecurityConfiguration 中配置的 BCryptPasswordEncoder
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
//            throws Exception {
//        endpoints.authenticationManager(authenticationManager);
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        String finalSecret = passwordEncoder.encode("123456");
//
//        // 配置两个客户端，一个用于password认证一个用于client认证
//        clients.inMemory().withClient("client_1")
//                .authorizedGrantTypes("client_credentials", "refresh_token")
//                .scopes("select")
//                .authorities("oauth2")
//                .secret(finalSecret)
//                .and().withClient("client_2")
//                .authorizedGrantTypes("password", "refresh_token")
//                .scopes("server")
//                .authorities("oauth2")
//                .secret(finalSecret);
//    }
////    @Override
////    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
////        endpoints.tokenStore(new MyRedisTokenStore(redisConnectionFactory))
////                .authenticationManager(authenticationManager)
////                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
////    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        // 允许表单认证
//        security.allowFormAuthenticationForClients();
//    }
//}
