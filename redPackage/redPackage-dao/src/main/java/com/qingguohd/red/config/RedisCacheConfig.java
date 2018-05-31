package com.qingguohd.red.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: YuGenHai
 * @name: RedisCacheConfig.java
 * @creation: 2018年5月31日 下午5:50:15
 * @notes:  Redis缓存设置
 */
@Configuration
@EnableCaching
public class RedisCacheConfig {
	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
		return cacheManager;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(factory);
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(redisSerializer);
		redisTemplate.setHashKeySerializer(redisSerializer);
		return redisTemplate;
	}
}
