package org.lg.nutritionboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ComponentScan("com")
public class NutritionbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutritionbootApplication.class, args);
    }

}
