package com.mkyong.helloworld.system;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 180) // 3分
public class RedisHttpSessionConfig {

	// XMLで定義済みで他目的のRedisConnectionFactoryと
	// 接続先を分けるときの対応として名前付きでInjectする
	@Resource(name = "session.redisConnectionFactory")
	private RedisConnectionFactory redisConnectionFactory;

	@Bean
	public RedisConnectionFactory connectionFactory() {
		return redisConnectionFactory;
	}

	// セッションIDをCookieで管理する設定
	@Bean
	public CookieHttpSessionStrategy httpSessionStrategy() {
		CookieHttpSessionStrategy httpSessionStrategy = new CookieHttpSessionStrategy();
		httpSessionStrategy.setCookieName("JSESSIONID");

		return httpSessionStrategy;
	}
}