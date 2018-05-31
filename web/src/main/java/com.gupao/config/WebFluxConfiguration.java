package com.gupao.config;


import com.gupao.domain.User;
import com.gupao.repository.UserRepository;
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
import java.util.stream.Collector;


@Configuration
public class WebFluxConfiguration {


    @Bean
    @Autowired
    public RouterFunction<ServerResponse>routeFunctionUsers(UserRepository userRepository){

        Collection<User> users = userRepository.findAll();
        Flux<User>userFlux = Flux.fromIterable(users);

        Mono<Collection<User>> mono = Mono.just( users );
        return RouterFunctions.route(  RequestPredicates.path("/users"),
                     serverRequest -> ServerResponse.ok().body(
                             userFlux,User.class
                     )
        );

    }


}
