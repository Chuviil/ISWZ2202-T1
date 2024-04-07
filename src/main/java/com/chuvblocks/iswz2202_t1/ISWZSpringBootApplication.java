package com.chuvblocks.iswz2202_t1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ISWZSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ISWZSpringBootApplication.class, args);
    }

}
