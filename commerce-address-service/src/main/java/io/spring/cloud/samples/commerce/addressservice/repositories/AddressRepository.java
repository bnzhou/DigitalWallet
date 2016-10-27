package io.spring.cloud.samples.commerce.addressservice.repositories;

import io.spring.cloud.samples.commerce.addressservice.domain.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, String> {

    Iterable<Address> findByUsername(String username);
}
