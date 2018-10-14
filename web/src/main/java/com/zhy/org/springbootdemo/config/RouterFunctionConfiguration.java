package com.zhy.org.springbootdemo.config;

import com.zhy.org.springbootdemo.Repository.UserRepository;
import com.zhy.org.springbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * 路由器函数 配置
 */
@Configuration
public class RouterFunctionConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> userFindAll(UserRepository userRepository){

        RouterFunction<ServerResponse> route = RouterFunctions.route(RequestPredicates.GET("/user/findAll"), serverRequest -> {
            Collection<User> all = userRepository.findAll();
            Flux userFlux = Flux.fromIterable(all);
            Mono<ServerResponse> body = ServerResponse.ok().body(userFlux, User.class);
            return body;
        });

        return route;
    }

}
