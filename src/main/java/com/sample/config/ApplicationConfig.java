package com.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
@EnableAsync
public class ApplicationConfig {
  @Autowired private Environment env;

  @Bean
  public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public CacheManager cacheManager() {
    return new ConcurrentMapCacheManager();
  }
}
