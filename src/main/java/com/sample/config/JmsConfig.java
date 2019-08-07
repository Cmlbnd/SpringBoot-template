package com.sample.config;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import java.util.Optional;

/*
 * Sets up connections between server and AWS
 *
 */
@Configuration
@EnableJms
public class JmsConfig {
  @Value("${queue.clientId:#{null}}") private String queueClientId;

  @Value("${queue.clientSecret:#{null}}") private String queueClientSecret;

  @Value("${queue.destination}") private String queueUpdate;

  @Value("${aws.region:#{null}}") private String awsRegion;

  @Bean
  public SQSConnectionFactory sqsConnectionFactory(Optional<BasicAWSCredentials> awsCredentials) {
    AmazonSQSClientBuilder awAmazonSQSClientBuilder = AmazonSQSClientBuilder.standard();

    if (awsRegion == null) {
      awAmazonSQSClientBuilder = awAmazonSQSClientBuilder.withRegion(Regions.getCurrentRegion()
          .getName());
    } else {
      awAmazonSQSClientBuilder = awAmazonSQSClientBuilder.withRegion(awsRegion);
    }

    if (awsCredentials.isPresent()) {
      awAmazonSQSClientBuilder =
          awAmazonSQSClientBuilder.withCredentials(
              new AWSStaticCredentialsProvider(awsCredentials.get()));
    }

    return new SQSConnectionFactory(new ProviderConfiguration(), awAmazonSQSClientBuilder);
  }

  @Bean
  public Optional<BasicAWSCredentials> awsCredentials() {
    if (queueClientId == null) {
      return Optional.empty();
    }

    return Optional.of(new BasicAWSCredentials(queueClientId, queueClientSecret));
  }

  @Bean
  public JmsTemplate defaultJmsTemplate(SQSConnectionFactory sqsConnectionFactory) {
    JmsTemplate jmsTemplate = new JmsTemplate(sqsConnectionFactory);
    jmsTemplate.setDefaultDestinationName(queueUpdate);
    return jmsTemplate;
  }
}