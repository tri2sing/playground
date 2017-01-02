package name.adhikari.sameer.playground.generics.animals;

import java.util.ArrayList;

public class GenericPolymorphism {
    public void processAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    public void processAnimalsSubtypes(ArrayList<? extends  Animal> animals) {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    public void createGroupAndProcess() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Cat());
        processAnimals(animals);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        // The following is not allowed.
        // processAnimals(dogs);
        // But, this one is.
        processAnimalsSubtypes(dogs);
    }

    public static void main(String[] args) {
        new GenericPolymorphism().createGroupAndProcess();
    }
}
