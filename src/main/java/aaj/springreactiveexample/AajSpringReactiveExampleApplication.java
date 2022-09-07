package aaj.springreactiveexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@PropertySource("classpath:${PROPERTY_FILE}.properties")
@EnableReactiveMongoRepositories
public class AajSpringReactiveExampleApplication {
  public static void main(String[] args) {
    SpringApplication.run(AajSpringReactiveExampleApplication.class, args);
  }
}
