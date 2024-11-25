package com.prueba.labanca.apipruebalabanca.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("fibonacciCache");
        cacheManager.setCaffeine(
                com.github.benmanes.caffeine.cache.Caffeine.newBuilder()
                        .expireAfterWrite(10, TimeUnit.MINUTES)
                        .maximumSize(100)
        );
        return cacheManager;
    }
}
