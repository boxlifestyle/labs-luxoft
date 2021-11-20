package com.bykov.testspec.repository;

import com.bykov.testspec.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
