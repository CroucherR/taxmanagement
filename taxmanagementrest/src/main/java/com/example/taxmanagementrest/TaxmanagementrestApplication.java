package com.example.taxmanagementrest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Import(SpringDataRestConfiguration.class)
public class TaxmanagementrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxmanagementrestApplication.class, args);
    }

}
