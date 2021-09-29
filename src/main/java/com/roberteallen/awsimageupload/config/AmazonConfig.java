package com.roberteallen.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    //For environment variables
    Dotenv dotenv = Dotenv.load();

    //Spring instantiates and instance of AmazonS3 with these configurations
    // ,so we can inject other classes
    @Bean
    public AmazonS3 s3(){

        //Constructs a new BasicAWSCredentials object, with the specified
        // AWS access key and AWS secret key.
        String AWS_SECRET_ACCESS_KEY = dotenv.get("AWS_SECRET_ACCESS_KEY");
        String AWS_ACCESS_KEY_ID = dotenv.get("AWS_ACCESS_KEY_ID");

        AWSCredentials awsCredentials = new BasicAWSCredentials(
                AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);

        //Specifying a Credential Provider or Provider Chain
        return AmazonS3Client.builder()
                .withRegion("us-east-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        //AWS api requires region
        /*
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
        */
    }

}
