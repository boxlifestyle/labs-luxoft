package com.bykov.testspec.service;

import com.bykov.testspec.model.Booze;
import com.bykov.testspec.repository.BoozeRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoozeServiceImpl implements BoozeService {

    private final BoozeRepository boozeRepository;

    public BoozeServiceImpl(BoozeRepository boozeRepository) {
        this.boozeRepository = boozeRepository;
    }

    @Override
    public Booze save(Booze booze) {
        return boozeRepository.save(booze);
    }

    @Override
    public List<Booze> findAll(Specification<Booze> spec) {
        return boozeRepository.findAll(spec);
    }
}
