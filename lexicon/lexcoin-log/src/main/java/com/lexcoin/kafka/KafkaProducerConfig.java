package com.lexcoin.kafka;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka生产者配置
 */
@Configuration
@EnableKafka
public class KafkaProducerConfig {

    @Value("${kafka.producer.servers}")
    private String servers;
    @Value("${kafka.producer.retries}")
    private int retries;
    @Value("${kafka.producer.batch.size}")
    private int batchSize;
    @Value("${kafka.producer.linger}")
    private int linger;
    @Value("${kafka.producer.buffer.memory}")
    private int bufferMemory;
    @Value("${kafka.producer.sasl.laintext}")
    private String saslPlaintext;
    @Value("${kafka.producer.sasl.mechanism}")
    private String saslMechanism;
    @Value("${kafka.producer.username}")
    private String username;
    @Value("${kafka.producer.password}")
    private String password;
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


    private Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        System.out.println("servers = " + servers);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 300);
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        props.put(ProducerConfig.LINGER_MS_CONFIG, linger);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        setIsUseSSL(props);
        return props;
    }

    private void setIsUseSSL(Map<String, Object> props) {
        if (isUseSSL) {
            props.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, sslalgorithm);
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, this.getClass().getClassLoader().getResource(sslTruststoreLocation).getPath());
            props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, sslTruststorePassword);
            props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, this.getClass().getClassLoader().getResource(sslKeystoreLocation).getPath());
            props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, sslKeystorePassword);
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, saslPlaintext);
            props.put(SaslConfigs.SASL_MECHANISM, saslMechanism);
            props.put("sasl.jaas.config",
                    "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + username + "\" password = \"" + password + "\";");
        }
    }

    private ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }
}

