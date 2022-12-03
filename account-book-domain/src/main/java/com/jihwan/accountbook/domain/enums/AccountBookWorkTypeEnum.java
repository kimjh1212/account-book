package com.jihwan.accountbook.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountBookWorkTypeEnum {
    DEPOSIT("입금"),
    WITHDRAW("출금"),
    INTEREST("이자"),
    ;

    private final String kor;
}