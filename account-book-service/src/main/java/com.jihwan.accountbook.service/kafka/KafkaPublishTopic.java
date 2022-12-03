package com.jihwan.accountbook.service.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KafkaPublishTopic {
    ACCOUNT_BOOK_TRANSACTION_LOG("account-book-transaction-log.1");

    private final String topicName;
}
