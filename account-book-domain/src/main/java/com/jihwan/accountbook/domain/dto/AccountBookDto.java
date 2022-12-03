package com.jihwan.accountbook.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountBookDto {
    private Long accountBookTypeId;
    private String name;
    private String updatedAtString;
}
