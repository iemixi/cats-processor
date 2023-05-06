package ru.netology;

import java.util.List;

public class DataProcessor {
    public List<Pet> getUpvotedCats(List<Pet> pets) {
        return pets.stream()
                .filter(pet -> pet.getUpvotes() != null &&
                        pet.getUpvotes() != 0)
                .toList();
    }
}
