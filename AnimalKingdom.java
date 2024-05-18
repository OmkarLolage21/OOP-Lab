package FinalOOPLab;

abstract class Animal{

    abstract void eat();
    abstract void sleep();
    abstract void move();
}
class Mammals extends Animal{

    @Override
    void eat() {
        System.out.println("Mammals are both herbivorous and carnivorous");
    }

    @Override
    void sleep() {
        System.out.println("Mammals have varied sleep");
    }

    @Override
    void move() {
        System.out.println("Mammals walk on Ground, some can fly");
    }
}
class Fish extends Animal{

    @Override
    void eat() {
        System.out.println("Fish eat other fishes and small bugs");
    }

    @Override
    void sleep() {
        System.out.println("Fish doesn't sleep");
    }

    @Override
    void move() {
        System.out.println("Fish Swim");
    }
}
class Birds extends Animal{

    @Override
    void eat() {
        System.out.println("Birds eat worms");
    }

    @Override
    void sleep() {
        System.out.println("Birds sleep in nests");
    }

    @Override
    void move() {
        System.out.println("Birds Fly");
    }
}
public class AnimalKingdom {
    public static void main(String[] args) {
        Mammals mammal = new Mammals();
        mammal.eat();
        mammal.move();
        mammal.sleep();
        System.out.println();
        Birds bird = new Birds();
        bird.eat();
        bird.move();
        bird.sleep();
        System.out.println();
        Fish fish = new Fish();
        fish.eat();
        fish.move();
        fish.sleep();
        System.out.println();
    }
}
