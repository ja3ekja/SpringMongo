package com.epam.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;
import java.util.Collections;

/**
 * Created by HP on 2016-02-14.
 */

@Configuration
//@EnableMongoRepositories
@EnableAutoConfiguration(exclude = {
        MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class
        //, MongoRepositoriesAutoConfiguration.class// one more
         })
public class MongoConfiguration {

    @Value("${database.host}")
    String databaseHost;
    @Value("${database.port}")
    int databasePort;
    @Value("${database.database}")
    String database;
    @Value("${database.username}")
    String databaseUsername;
    @Value("${database.password}")
    String databasePassword;

    @Bean
    public MongoOperations mongoOperations() throws Exception {
        MongoDbFactory dbfactory = new SimpleMongoDbFactory(getMongo(), database);
        return new MongoTemplate(dbfactory);
    }

    private ServerAddress getServerAddress() throws UnknownHostException {
        return new ServerAddress(databaseHost, databasePort);
    }

    protected MongoClient getMongo() throws Exception {
        final MongoCredential credential = MongoCredential.createCredential(databaseUsername, database,
                databasePassword.toCharArray());
        return new MongoClient(getServerAddress(), Collections.singletonList(credential));
    }

}
