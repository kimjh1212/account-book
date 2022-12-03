package com.jihwan.accountbook.service.kafka;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KafkaPublishDto<T> {

    private final String key;
    private final T value;
}
