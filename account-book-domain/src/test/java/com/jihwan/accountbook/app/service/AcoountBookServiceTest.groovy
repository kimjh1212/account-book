package com.jihwan.accountbook.app.service

import com.jihwan.accountbook.domain.entity.AccountBook
import com.jihwan.accountbook.domain.repository.AccountBookRepository
import com.jihwan.accountbook.domain.service.AccountBookService
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

    def "create TEST success"() {
        given:
        def name = "부자 통장"
        def type_id = 243235
        and:
        accountBookRepository.save(_) >> new AccountBook(id: 13456, name: name, accountBookTypeId: type_id)

        when:
        def result = accountBookService.create(name, type_id)

        then:
        result != null
        result.getId() == 13456
        noExceptionThrown()
        result.getName() == name
        result.getAccountBookTypeId() == type_id
    }

    def "create FAILURE success"() {
        given:
        def name = null
        def type_id = 243235

        when:
        accountBookService.create(name, type_id)

        then:
        0 * accountBookRepository.save(_)
        def e = thrown(NullPointerException)
        e.getMessage() == "[name] 파라미터가 비어있습니다."
    }
}
