package aaj.springreactiveexample.handler;

import aaj.springreactiveexample.document.User;
import aaj.springreactiveexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandlerImpl implements UserHandler {
  private final UserRepository userRepository;

  @Autowired
  public UserHandlerImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Mono<ServerResponse> getUser(ServerRequest request) {
    String id = request.queryParam("id").isPresent() ? request.queryParam("id").get() : "";
    Mono<User> userMono = userRepository.findFirstById(id);
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userMono, User.class);
  }

  @Override
  public Mono<ServerResponse> postUser(ServerRequest request) {
    Mono<User> userMono = request.bodyToMono(User.class);
    Flux<User> inserted = userRepository.insert(userMono);
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(inserted, User.class);
  }
}
 
