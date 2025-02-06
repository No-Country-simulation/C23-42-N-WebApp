package org.nctry.server.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        List<CaffeineCache> caches = new ArrayList<>();
        caches.add(buildCache("presigned-urls", 3, TimeUnit.DAYS, 400));

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(caches);
        return manager;
    }

    private static CaffeineCache buildCache(String name, long ttl, TimeUnit ttlUnit, long size) {
        return new CaffeineCache(name, Caffeine.newBuilder()
                .expireAfterWrite(ttl, ttlUnit)
                //.expireAfterAccess(ttl, ttlUnit)
                .maximumSize(size) //maxima cantidad de elementos en el cache
                .build());
    }
}
