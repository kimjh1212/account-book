package com.jihwan.accountbook.domain.entity;

import com.jihwan.accountbook.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "account_book_item_put_log")
public class AccountBookItemPutLog extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountBookId", referencedColumnName = "id")
    private AccountBook accountBook;

    @NonNull
    private String workType;

    @NonNull
    private String putPriceSum;


}
