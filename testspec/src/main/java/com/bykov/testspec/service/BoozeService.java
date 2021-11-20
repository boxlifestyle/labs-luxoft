package com.bykov.testspec.service;

import com.bykov.testspec.model.Booze;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BoozeService {

    Booze save(Booze booze);

    List<Booze> findAll(Specification<Booze> spec);
}
