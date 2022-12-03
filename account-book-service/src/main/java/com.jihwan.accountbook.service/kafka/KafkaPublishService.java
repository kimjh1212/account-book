package com.jihwan.accountbook.service.kafka;

import com.google.gson.Gson;
import com.jihwan.accountbook.service.enums.ServiceExceptionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaPublishService {

    @Qualifier("kafkaProducer")
    private final KafkaProducer producer;

    @Qualifier("gson")
    private final Gson gson;

    public void send(KafkaPublishTopic topic, KafkaPublishDto publishDto, boolean sync) {
        try {
            String message = gson.toJson(publishDto.getValue());
            ProducerRecord<String, String> record = createRecord(topic, publishDto.getKey(), message);
            if (sync) {
                sync(record);
                return;
            }
            async(record);
        } catch (Exception e) {
            log.error("Kafka publish has failed. ", e);
            throw new IllegalStateException(ServiceExceptionMessage.KAFKA_PUBLISH_FAILURE.getMessage(
                    topic.getTopicName(), publishDto.getKey(), gson.toJson(publishDto.getValue()))
            );
        }
    }

    private ProducerRecord<String, String> createRecord(KafkaPublishTopic topic, String key, String message) {
        return new ProducerRecord<>(topic.getTopicName(), key, message);
    }

    /**
     * publish message on the queue synchronously
     * <p>
     * - THROW an error when it fails
     */
    private void sync(ProducerRecord record) throws ExecutionException, InterruptedException {
        Future<RecordMetadata> future = producer.send(record);
        RecordMetadata metadata = future.get();
    }

    /**
     * publish message on the queue asynchronously
     * <p>
     * - NOT THROW an error when it fails
     */
    private void async(ProducerRecord record) {
        producer.send(record, (metadata, e) -> {
            if (e != null)
                log.error("Send failed for record {}", record, e);
        });
    }
}
