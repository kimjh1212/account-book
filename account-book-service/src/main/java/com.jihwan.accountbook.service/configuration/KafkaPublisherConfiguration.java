package com.jihwan.accountbook.service.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Properties;

@Slf4j
@Configuration
public class KafkaPublisherConfiguration {

    @Bean("kafkaProducer")
    public KafkaProducer kafkaProducer(@Value("${kafka.bootstrap.servers}") String kafkaBrokerList) {
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokerList);
        config.put(ProducerConfig.ACKS_CONFIG, "all");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        log.info("- kafkaProducer initialized...");

        return new KafkaProducer(new HashMap<>(config));
    }
}
