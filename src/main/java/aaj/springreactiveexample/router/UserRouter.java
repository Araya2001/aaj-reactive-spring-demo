package aaj.springreactiveexample.router;

import aaj.springreactiveexample.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class UserRouter {
  @Bean
  public RouterFunction<ServerResponse> route(UserHandler userHandler) {
    return RouterFunctions.route(GET("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUser).andRoute(POST("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::postUser);
  }
}
