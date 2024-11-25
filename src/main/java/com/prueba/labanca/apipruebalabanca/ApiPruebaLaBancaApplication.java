package com.prueba.labanca.apipruebalabanca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "com.prueba.labanca.apipruebalabanca.*")
@EnableCaching
public class ApiPruebaLaBancaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPruebaLaBancaApplication.class, args);
    }

}
