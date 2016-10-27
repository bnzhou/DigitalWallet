package io.spring.cloud.samples.commerce.addressservice.repositories;

import io.spring.cloud.samples.commerce.addressservice.domain.Login;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoginRepository extends PagingAndSortingRepository<Login, String> {

    Iterable<Login> findByUsername(String username);
}
