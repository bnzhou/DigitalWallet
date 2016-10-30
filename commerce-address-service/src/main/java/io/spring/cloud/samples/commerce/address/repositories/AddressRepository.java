package io.spring.cloud.samples.commerce.address.repositories;

import io.spring.cloud.samples.commerce.address.domain.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, String> {

    Iterable<Address> findByUsername(String username);
}
