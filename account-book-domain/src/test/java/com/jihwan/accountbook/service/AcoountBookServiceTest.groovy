package com.jihwan.accountbook.service

import com.jihwan.accountbook.repository.AccountBookRepository
import spock.lang.Specification

class AcoountBookServiceTest extends Specification {
    AccountBookService accountBookService

    def accountBookRepository

    void setup() {
        accountBookRepository = Mock(AccountBookRepository)

        accountBookService = new AccountBookService(
                accountBookRepository
        )
    }
}
