package com.possible.user.core.config;

import com.mongodb.client.MongoClient;
import org.axonframework.extensions.mongo.DefaultMongoTemplate;
import org.axonframework.extensions.mongo.MongoTemplate;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoFactory;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoSettingsFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
    @Value("${spring.data.mongodb.host}")
    private String mongoHost;
    @Value("${spring.data.mongodb.port}")
    private int mongoPort;
    @Value("${spring.data.mongodb.host}")
    private String mongoDatabase;


    @Bean
    public MongoClient mongoClient(){
        var mongoFactory = new MongoFactory();
        var mongoSettingFactory = new MongoSettingsFactory();

    }

    @Bean
    public MongoTemplate axonMongoTemplate(){
        return DefaultMongoTemplate.builder()
                .mongoDatabase(mongoClient)
                .build();

    }
}
