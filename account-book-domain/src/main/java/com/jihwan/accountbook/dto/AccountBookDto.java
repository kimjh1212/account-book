package com.jihwan.accountbook.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountBookDto {
    private Long accountBookTypeId;
    private String name;
    private String updatedAtString;
}
