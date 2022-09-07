package aaj.springreactiveexample.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.connection.SocketSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class MongoConfig {
  @Bean
  public MongoClient mongoClient() {
    ConnectionString connectionString = new ConnectionString("mongodb+srv://aaj:TCmhPcU4eyzz24B4@aaj-cluster.pxqyot9.mongodb.net/reactive?w=majority");
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
        .applyToSslSettings(builder -> builder.enabled(true).invalidHostNameAllowed(true))
        .applyToConnectionPoolSettings(builder -> builder.minSize(5).maxSize(20).maxWaitTime(5, TimeUnit.MINUTES))
        .applyToSocketSettings(builder -> builder.applySettings(SocketSettings.builder().connectTimeout(5, TimeUnit.MINUTES).readTimeout(10, TimeUnit.MINUTES).build()))
        .applyConnectionString(connectionString).retryWrites(true).build();
    return MongoClients.create(mongoClientSettings);
  }
}
