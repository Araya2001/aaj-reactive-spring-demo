package aaj.springreactiveexample.router;

import aaj.springreactiveexample.handler.WaitHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class WaitRouter {
  @Bean
  public RouterFunction<ServerResponse> routeWait(WaitHandler waitHandler) {
    return RouterFunctions.route(GET("/wait").and(accept(MediaType.APPLICATION_JSON)), waitHandler::getWait);
  }
}
