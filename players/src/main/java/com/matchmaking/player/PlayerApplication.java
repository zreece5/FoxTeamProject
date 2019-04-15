package com.matchmaking.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication(scanBasePackages = {"com.matchmaking.player"})
@EnableSwagger2
@EnableAsync
public class PlayerApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlayerApplication.class, args);
  }

  @Bean
  public Docket newsApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("v1")
        .apiInfo(apiInfo("1.0"))
        .select()
        .paths(regex("/player.*|/matchmaking/players/v1/.*"))
        .build();
  }

  @Bean
  public Docket swaggerV2() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("v2")
        .apiInfo(apiInfo("2.0"))
        .select()
        .paths(regex("/matchmaking/players/v2/.*"))
        .build();
  }

  private ApiInfo apiInfo(String version) {
    return new ApiInfoBuilder()
        .title("Matchmaking Player Service")
        .description(
            "This API contains the list of Players from the Kennesaw State University Company!")
        .contact("Contact")
        .licenseUrl("license")
        .version(version)
        .build();
  }
}
