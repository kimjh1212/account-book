package com.jihwan.accountbook.service.enums;

public enum ServiceExceptionMessage {

    // account type

    // general
    KAFKA_PUBLISH_FAILURE("카프카 메시지 발행에 실패했습니다. [topic:%s, key:%s, message:%s]");

    private final String message;

    ServiceExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String... params) {
        return String.format(message, (Object[]) params);
    }
}
