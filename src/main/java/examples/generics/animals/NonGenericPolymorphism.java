package examples.generics.animals;

public class NonGenericPolymorphism {
    public void processAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    public void createGroupAndProcess() {
        Animal [] animals = {new Dog(), new Cat(), new Cat()};
        Dog [] dogs = {new Dog(), new Dog(), new Dog()};
        processAnimals(animals);
        processAnimals(dogs);
    }

    public static void main(String[] args) {
        new NonGenericPolymorphism().createGroupAndProcess();
    }
}
