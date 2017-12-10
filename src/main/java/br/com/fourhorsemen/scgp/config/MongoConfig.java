package br.com.fourhorsemen.scgp.config;

import static java.util.Collections.singletonList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	
	@Value("${spring.data.mongodb.host}")
	private String mongoHost;
	
	@Value("${spring.data.mongodb.port}")
	private int mongoPort;
	
	@Value("${spring.data.mongodb.database}")
	private String mongoDb;
	
	@Value("${spring.data.mongodb.username}")
	private String mongoUsername;
	
	@Value("${spring.data.mongodb.password}")
	private String mongoPassword;
	
	@Override
	public MongoClient mongoClient() {
		return new MongoClient(singletonList(new ServerAddress(mongoHost, mongoPort)),
                singletonList(MongoCredential.createCredential(mongoUsername, mongoDb, mongoPassword.toCharArray())));
	}

	@Override
	protected String getDatabaseName() {
		return mongoDb;
	}
	
	@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), mongoDb);
    }
	
}
