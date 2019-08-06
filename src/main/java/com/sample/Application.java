package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

import java.util.TimeZone;

@SpringBootApplication
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {

    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

    String environment = System.getenv()
        .getOrDefault("ENV_NAME", "default");

    LOGGER.info("ENV_NAME is : " + environment);

    System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, environment);

    SpringApplication.run(Application.class, args);
  }
}
