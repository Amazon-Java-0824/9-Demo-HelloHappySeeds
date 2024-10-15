package com.scorsaro.hellowebagain.repository;

import com.scorsaro.hellowebagain.model.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Seed, Long> {
}
