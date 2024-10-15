package com.scorsaro.hellowebagain.service;

import com.scorsaro.hellowebagain.dto.ModifyQuantityRequest;
import com.scorsaro.hellowebagain.dto.QuantityOperationType;
import com.scorsaro.hellowebagain.model.Seed;
import com.scorsaro.hellowebagain.repository.SeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeedService {

    private final SeedRepository seedRepository;
    @Transactional
    public Seed createSeed(Seed seed) {
        return seedRepository.save(seed);
    }

    public List<Seed> findAll() {
        return seedRepository.findAll();
    }

    public Seed findById(Long id) {
        return seedRepository.findById(id).orElse(null);
    }

    @Transactional
    public Seed updateSeed(Seed seedToUpdate, Long id) {
        var seed = seedRepository.findById(id);

        if (seed.isEmpty()) {
            return null;
        }
        seedToUpdate.setId(id);
        return seedRepository.save(seedToUpdate);
    }


    @Transactional
    public Seed updateQuantity(ModifyQuantityRequest modifyQuantityRequest, Long id) {
        var seed = seedRepository.findById(id);
        if (seed.isEmpty()) {
            return null;
        }
        var actualQuantity = seed.get().getQuantityInGramsStocked();

        if (modifyQuantityRequest.operation() == QuantityOperationType.ADD) {
            seed.get().setQuantityInGramsStocked(actualQuantity + modifyQuantityRequest.quantity());
        } else {
            if ((actualQuantity - modifyQuantityRequest.quantity()) < 0) {
                seed.get().setQuantityInGramsStocked(0L);
            }
            seed.get().setQuantityInGramsStocked(actualQuantity - modifyQuantityRequest.quantity());
        }

        return seedRepository.save(seed.get());
    }

    @Transactional
    public void deleteSeedById(Long id) {
        seedRepository.deleteById(id);
    }
}
