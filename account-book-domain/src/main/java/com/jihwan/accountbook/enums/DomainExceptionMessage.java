package com.jihwan.accountbook.enums;

public enum DomainExceptionMessage {

    // account type

    // general
    PARAMETER_IS_NULL("[%s] 파라미터가 비어있습니다.")
    ;

    private final String message;

    DomainExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getMessage(String... params){
        return String.format(message, params);
    }
}
