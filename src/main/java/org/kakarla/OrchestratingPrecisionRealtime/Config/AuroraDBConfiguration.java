package org.kakarla.OrchestratingPrecisionRealtime.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.awscore.defaultsmode.DefaultsMode;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class AuroraDBConfiguration {

    // Create a DynamoDbClient US_EAST_1
    @Bean("US_EAST_1_DynamoDB")
    public DynamoDbClient East1Connect() {
        DynamoDbClient dynamoDbClientEast = DynamoDbClient.builder()
                .region(Region.US_EAST_1).defaultsMode(DefaultsMode.AUTO).// Specify the region you're working with
                        credentialsProvider(ProfileCredentialsProvider.create("default"))  // Specify AWS credentials profile
                .build();
        return dynamoDbClientEast;
    }

    // Create a DynamoDbClient US_EAST_1
    @Bean("US_EAST_2_DynamoDB")
    public DynamoDbClient East2Connect() {
        DynamoDbClient dynamoDbClientEast = DynamoDbClient.builder()
                .region(Region.US_EAST_2).defaultsMode(DefaultsMode.AUTO).// Specify the region you're working with
                        credentialsProvider(ProfileCredentialsProvider.create("default"))  // Specify AWS credentials profile
                .build();
        return dynamoDbClientEast;
    }

}
