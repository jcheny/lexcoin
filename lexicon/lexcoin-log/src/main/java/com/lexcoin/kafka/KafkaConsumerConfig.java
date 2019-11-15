package com.lexcoin.kafka;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka 消费者配置
 */
@Configuration
@EnableKafka
@RefreshScope
public class KafkaConsumerConfig {

    @Value("${kafka.consumer.username}")
    private String username;
    @Value("${kafka.consumer.password}")
    private String password;
    @Value("${kafka.consumer.servers}")
    private String servers;
    @Value("${kafka.consumer.enable.auto.commit}")
    private boolean enableAutoCommit;
    @Value("${kafka.consumer.session.timeout}")
    private String sessionTimeout;
    @Value("${kafka.consumer.auto.commit.interval}")
    private String autoCommitInterval;
    @Value("${kafka.consumer.group.id}")
    private String groupId;
    @Value("${kafka.consumer.auto.offset.reset}")
    private String autoOffsetReset;
    @Value("${kafka.consumer.concurrency}")
    private int concurrency;
    @Value("${kafka.consumer.sasl.laintext}")
    private String saslPlaintext;
    @Value("${kafka.consumer.sasl.mechanism}")
    private String saslMechanism;
    @Value("${kafka.use-ssl}")
    private boolean isUseSSL;
    @Value("${kafka.ssl.truststore.location}")
    private String sslTruststoreLocation;
    @Value("${kafka.ssl.truststore.password}")
    private String sslTruststorePassword;
    @Value("${kafka.ssl.keystore.location}")
    private String sslKeystoreLocation;
    @Value("${kafka.ssl.keystore.password}")
    private String sslKeystorePassword;
    @Value("${kafka.ssl.endpoint.identification.algorithm}")
    private String sslalgorithm;


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(concurrency);
        factory.setBatchListener(true);
        factory.getContainerProperties().setPollTimeout(1500);
        return factory;
    }

    private ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }


    private Map<String, Object> consumerConfigs() {
        System.out.println("servers = " + servers);
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 5);
        setIsUseSSL(propsMap);
        return propsMap;
    }

    private void setIsUseSSL(Map<String, Object> propsMap) {
        if (isUseSSL) {
            propsMap.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, sslalgorithm);
            propsMap.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, this.getClass().getClassLoader().getResource(sslTruststoreLocation).getPath());
            propsMap.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, sslTruststorePassword);
            propsMap.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, this.getClass().getClassLoader().getResource(sslKeystoreLocation).getPath());
            propsMap.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, sslKeystorePassword);
            propsMap.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, saslPlaintext);
            propsMap.put(SaslConfigs.SASL_MECHANISM, saslMechanism);
            propsMap.put("sasl.jaas.config",
                    "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + username + "\" password = \"" + password + "\";");

        }
    }

}

