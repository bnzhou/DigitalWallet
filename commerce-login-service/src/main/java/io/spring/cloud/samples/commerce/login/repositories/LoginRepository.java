package io.spring.cloud.samples.commerce.login.repositories;

import io.spring.cloud.samples.commerce.login.domain.Login;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoginRepository extends PagingAndSortingRepository<Login, String> {

    Iterable<Login> findByUsername(String username);
}
