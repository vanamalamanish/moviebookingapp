package com.moviebookingapp.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  //Swagger Config for API Documentation
  @Bean
    public Docket restApi(){
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.moviebookingapp"))
        .paths(PathSelectors.any())
        .build();
      
    }

    private ApiInfo apiInfo(){
        return new ApiInfo("Movie Booking App",
        "The Movie Booking App is a user-friendly application designed to facilitate user registration, login, and movie searches. Users can easily reserve tickets for their preferred films, while administrators can efficiently manage ticket bookings and update the system's pending ticket"
           ,"v1.0",
           null,
           new Contact("Sinchana Chandrashekar","https://www.linkedin.com/in/sinchana-chandrashekar/", "sinchanashettyc@gmail.com"),
           null,
           null,
           Collections.emptyList()
           );
    }
     

  
}
