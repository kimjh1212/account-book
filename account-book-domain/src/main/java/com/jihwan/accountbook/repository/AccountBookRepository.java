package com.jihwan.accountbook.repository;

import com.jihwan.accountbook.entity.AccountBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBookRepository extends JpaRepository<AccountBook, Long> {
}
