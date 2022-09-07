package aaj.springreactiveexample.repository;

import aaj.springreactiveexample.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
  Flux<User> findAllByLastName(String lastname);

  Flux<User> findAllByName(String name);

  Mono<User> findFirstById(String id);

  Mono<User> findFirstByName(String name);
}
