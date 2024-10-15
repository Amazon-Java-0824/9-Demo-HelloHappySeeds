package com.scorsaro.hellowebagain.controller;

import com.scorsaro.hellowebagain.dto.ModifyQuantityRequest;
import com.scorsaro.hellowebagain.model.Seed;
import com.scorsaro.hellowebagain.service.SeedService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seeds")
@RequiredArgsConstructor
public class SeedController {

    private final SeedService seedService;


    @GetMapping
    public List<Seed> findAll() {
        return seedService.findAll();
    }

    @GetMapping("/{id}")
    public Seed findById(@PathVariable Long id) {
        return seedService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seed create(@RequestBody Seed seed) {
        return seedService.createSeed(seed);
    }

    @PutMapping("/{id}")
    public Seed update(@RequestBody Seed seed, @PathVariable Long id) {
        return seedService.updateSeed(seed, id);
    }


    @PatchMapping("/{id}")
    public Seed updateQuantity(@RequestBody @Valid ModifyQuantityRequest modifyQuantityRequest, @PathVariable Long id) {
        return seedService.updateQuantity(modifyQuantityRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        seedService.deleteSeedById(id);
    }

}
