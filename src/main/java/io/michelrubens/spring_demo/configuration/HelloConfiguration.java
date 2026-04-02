package io.michelrubens.spring_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {

  @Bean
  public String helloWorldConfig() {
    return "Hello World from Configuration";
  }

}
