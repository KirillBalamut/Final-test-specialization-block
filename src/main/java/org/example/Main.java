package org.example;

public class Main {
    // Родительский класс Животное
    public class Animal {
        protected String name;
        protected int age;
        protected String birthDate;

        public Animal(String name, int age, String birthDate) {
            this.name = name;
            this.age = age;
            this.birthDate = birthDate;
        }

        public void makeSound() {
            System.out.println("Животное издает звук");
        }
    }

    // Классы домашних животных
    public class Pet extends Animal {
        public Pet(String name, int age, String birthDate) {
            super(name, age, birthDate);
        }

        public void play() {
            System.out.println("Животное играет");
        }
    }

    public class Dog extends Pet {
        public Dog(String name, int age, String birthDate) {
            super(name, age, birthDate);
        }

        public void bark() {
            System.out.println("Собака лает");
        }
    }

    public class Cat extends Pet {
        public Cat(String name, int age, String birthDate) {
            super(name, age, birthDate);
        }

        public void meow() {
            System.out.println("Кошка мяукает");
        }
    }

    public class Hamster extends Pet {
        public Hamster(String name, int age, String birthDate) {
            super(name, age, birthDate);
        }

        public void runInWheel() {
            System.out.println("Хомяк бегает в колесе");
        }
    }

    // Классы вьючных животных
    public class PackAnimal extends Animal {
        public PackAnimal(String name, int age, String birthDate) {
            super(name, age, birthDate);
        }

        public void work() {
            System.out.println("Животное работает");
        }
    }

    public class Horse extends PackAnimal {
        public Horse(String name, int age, String birthDate) {
            super(name, age, birthDate);
        }

        public void pullPlow() {
            System.out.println("Лошадь тянет плуг");
        }
    }

    public class Camel extends PackAnimal {
        public Camel(String name, int age, String birthDate) {
            super(name, age, birthDate);
        }

        public void carryLoad() {
            System.out.println("Верблюд несет грузы");
        }
    }

    public class Donkey extends PackAnimal {
        public Donkey(String name, int age, String birthDate) {
            super(name, age, birthDate);
        }

        public void carryLoad() {
            System.out.println("Осел несет грузы");
        }
    }
}