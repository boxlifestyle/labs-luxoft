package com.bykov.testspec.repository;

import com.bykov.testspec.model.Booze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BoozeRepository extends JpaRepository<Booze, Long>, JpaSpecificationExecutor<Booze> {
}
