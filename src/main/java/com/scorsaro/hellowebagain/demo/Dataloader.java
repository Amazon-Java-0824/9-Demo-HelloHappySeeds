package com.scorsaro.hellowebagain.demo;

import com.scorsaro.hellowebagain.model.Seed;
import com.scorsaro.hellowebagain.repository.SeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Dataloader implements CommandLineRunner {

    private final SeedRepository seedRepository;

    @Override
    public void run(String... args) throws Exception {

        seedRepository.saveAll(List.of(
                new Seed("Chia", "Chia seeds are the edible seeds of Salvia hispanica, a flowering plant in the mint family native to Central America. They are oval and gray with black and white spots, having a diameter around 1 millimeter. The seeds are hydrophilic, absorbing up to 12 times their weight in liquid when soaked and developing a mucilaginous coating that gives chia-based foods and beverages a distinctive gel texture.", 500L),
                new Seed("Flax", "Flax, also known as common flax or linseed, is a flowering plant, Linum usitatissimum, in the family Linaceae. It is cultivated as a food and fiber crop in regions of the world with temperate climate. Textiles made from flax are known in Western countries as linen, and are traditionally used for bed sheets, underclothes, and table linen.", 300L),
                new Seed("Sunflower", "Sunflower seeds are the fruit of the sunflower (Helianthus annuus). The seeds are usually pressed to extract their oil, which is used in cooking and in the production of margarine and biodiesel.", 200L),
                new Seed("Pumpkin", "Pumpkin seeds, also known as pepitas, are edible seeds of a pumpkin or certain other cultivars of squash. They are typically flat and asymmetrically oval, and light green in color.", 150L)
        ));
    }
}
