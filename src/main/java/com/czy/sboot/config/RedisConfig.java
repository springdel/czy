package com.czy.sboot.config;

import com.czy.sboot.redis.uitl.FastJson2JsonRedisSerializer;
import com.czy.sboot.redis.uitl.RedisTemplate;
import com.czy.sboot.redis.uitl.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
   @PropertySource("classpath:redis.properties")
   @Slf4j //日志处理
   public class RedisConfig {
   
       @Value("${redis.hostName}")
       private String hostName;
   
   //  @Value("${redis.password}")
   //  private String password;
   
       @Value("${redis.port}")
       private Integer port;
   
       @Value("${redis.maxIdle}")
       private Integer maxIdle;
   
       @Value("${redis.timeout}")
       private Integer timeout;
   
       @Value("${redis.maxTotal}")
       private Integer maxTotal;
   
       @Value("${redis.maxWaitMillis}")
       private Integer maxWaitMillis;
   
       @Value("${redis.minEvictableIdleTimeMillis}")
       private Integer minEvictableIdleTimeMillis;
   
       @Value("${redis.numTestsPerEvictionRun}")
       private Integer numTestsPerEvictionRun;
   
       @Value("${redis.timeBetweenEvictionRunsMillis}")
       private long timeBetweenEvictionRunsMillis;
   
       @Value("${redis.testOnBorrow}")
       private boolean testOnBorrow;
   
       @Value("${redis.testWhileIdle}")
       private boolean testWhileIdle;

    @Bean
    public JedisConnectionFactory JedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration ();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        //由于我们使用了动态配置库,所以此处省略
        //redisStandaloneConfiguration.setDatabase(database);
        //没有密码所以注释掉了
        //redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));
        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());
        return factory;
    }
    /**
     * @Description: 注册自定义序列化组件
     */
    @Bean
    public RedisSerializer fastJson2JsonRedisSerializer() {
        return new FastJson2JsonRedisSerializer<Object>(Object.class);
    }
    private void initDomainRedisTemplate(RedisTemplate redisTemplate, RedisConnectionFactory factory) {
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new    GenericJackson2JsonRedisSerializer());

        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * @Description: 实例化 RedisTemplate 对象
     */
    @Bean
    public RedisTemplate functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }
    /**
     * @Description: 注入封装RedisTemplate
     */
    @Bean(name = "redisUtil")
    public RedisUtil redisUtil(RedisTemplate redisTemplate) {
        RedisUtil redisUtil = new RedisUtil();
        return redisUtil;
    }
   }
