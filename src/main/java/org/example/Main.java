package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        registry.displayMenu();
    }
}

class Animal {
    private final String name;
    private final String birthDate;
    private final ArrayList<String> commands;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void listCommands() {
        System.out.println("Список команд для " + name + ":");
        for (String command : commands) {
            System.out.println(command);
        }
    }
}

// Класс для реестра животных
class AnimalRegistry {
    private final ArrayList<Animal> animals;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void trainAnimal(Animal animal, String newCommand) {
        animal.addCommand(newCommand);
        System.out.println(animal.getName() + " обучено новой команде: " + newCommand);
    }

    public void listAnimalsByBirthDate() {
        animals.sort(Comparator.comparing(Animal::getBirthDate));
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " - " + animal.getBirthDate());
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Вывести список команд животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Выйти из программы");

            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите дату рождения (гггг-мм-дд): ");
                    String birthDate = scanner.nextLine();
                    Animal newAnimal = new Animal(name, birthDate);
                    addAnimal(newAnimal);
                    break;
                case 2:
                    System.out.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    for (Animal animal : animals) {
                        if (animal.getName().equals(animalName)) {
                            animal.listCommands();
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Введите имя животного: ");
                    String animalName2 = scanner.nextLine();
                    System.out.print("Введите новую команду: ");
                    String newCommand = scanner.nextLine();
                    for (Animal animal : animals) {
                        if (animal.getName().equals(animalName2)) {
                            trainAnimal(animal, newCommand);
                            break;
                        }
                    }
                    break;
                case 4:
                    listAnimalsByBirthDate();
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный ввод. Повторите попытку.");
            }
        }
    }

    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        registry.displayMenu();
    }
}