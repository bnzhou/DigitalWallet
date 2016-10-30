package io.spring.cloud.samples.commerce.card.repositories;

import io.spring.cloud.samples.commerce.card.domain.Card;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CardRepository extends PagingAndSortingRepository<Card, String> {

    Iterable<Card> findByUsername(String username);
}
