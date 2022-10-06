package aaj.springreactiveexample.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface WaitHandler {
  Mono<ServerResponse> getWait(ServerRequest request);
}
