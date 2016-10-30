package io.spring.cloud.samples.commerce.transaction.repositories;

import io.spring.cloud.samples.commerce.transaction.domain.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Transaction, String> {

    Iterable<Transaction> findByUsername(String username);
}
