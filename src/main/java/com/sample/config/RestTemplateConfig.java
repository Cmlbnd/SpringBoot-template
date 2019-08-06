package com.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

  @Bean
  public RestTemplate restTemplate() {
    HttpComponentsClientHttpRequestFactory httpRequestFactory =
        new HttpComponentsClientHttpRequestFactory();
    httpRequestFactory.setConnectionRequestTimeout(6000);
    httpRequestFactory.setConnectTimeout(6000);
    httpRequestFactory.setReadTimeout(2700000); //45 min

    RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
    return restTemplate;
  }
}
