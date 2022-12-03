package com.jihwan.accountbook.entity;

import com.jihwan.accountbook.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "account_book")
public class AccountBook extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private Long accountBookTypeId;
    @NonNull
    private String name;
}
