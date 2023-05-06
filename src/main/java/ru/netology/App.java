package ru.netology;


import java.util.List;

public class App {
    public static void main(String[] args) {
        PetGetter petGetter = new PetGetter(
                "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");

        List<Pet> pets = petGetter.get();

        DataProcessor dataProcessor = new DataProcessor();

        List<Pet> upvotedCats = dataProcessor.getUpvotedCats(pets);

        for (Pet pet : upvotedCats) {
            System.out.println(pet);
        }
    }
}
