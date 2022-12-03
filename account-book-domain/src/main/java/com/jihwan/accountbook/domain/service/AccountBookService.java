package com.jihwan.accountbook.domain.service;

import com.google.common.base.Preconditions;
import com.jihwan.accountbook.domain.entity.AccountBook;
import com.jihwan.accountbook.domain.enums.DomainExceptionMessage;
import com.jihwan.accountbook.domain.repository.AccountBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountBookService {

    private final AccountBookRepository accountBookRepository;

    @Transactional
    public AccountBook create(String name, long accountBookTypeId) {
        Preconditions.checkNotNull(name, DomainExceptionMessage.PARAMETER_IS_NULL.getMessage("name"));

        AccountBook tempBook = new AccountBook();
        tempBook.setName(name);
        tempBook.setAccountBookTypeId(accountBookTypeId);
        AccountBook book = accountBookRepository.save(tempBook);
        log.info("New book has been created. id:{}, name:{}", book.getId(), book.getName());
        return book;
    }

}
