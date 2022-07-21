package com.dkb.codechallenge.urlshortener.config

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class AppConfig {
    @Bean
    fun cacheManager(): CacheManager =
        CaffeineCacheManager("Url")
            .apply {
                isAllowNullValues = false
                setCaffeine(
                    Caffeine.newBuilder()
                        .maximumSize(100)
                        .expireAfterAccess(1, TimeUnit.HOURS))
            }
}