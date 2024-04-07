package com.belstu.collections;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaxiPark taxiPark = new TaxiPark();

        // Создаем тестовый автопарк
        taxiPark.addCar(new SUV("Model X", 34, 180, 60000));
        taxiPark.addCar(new Sedan("Model S", 19, 200, 50000, true));
        taxiPark.addCar(new SUV("Model Y", 44, 190, 55000));
        taxiPark.addCar(new Sedan("Model 3", 38, 220, 40000, false));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Добавить автомобиль");
                System.out.println("2. Сортировать автомобили по расходу топлива");
                System.out.println("3. Подсчитать стоимость автопарка");
                System.out.println("4. Найти автомобиль по диапазону скорости");
                System.out.println("5. Обзор таксопарка");
                System.out.println("6. Выход");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Scanner scanner2 = new Scanner(System.in);
                        // Добавить автомобиль
                        System.out.println("Введите тип автомобиля (1 - Sedan, 2 - SUV):");
                        int type = scanner2.nextInt();
                        System.out.println("Введите модель:");
                        String model = scanner2.next();
                        System.out.println("Введите расход топлива:");
                        double fuelConsumption = scanner2.nextDouble();
                        System.out.println("Введите максимальную скорость:");
                        double maxSpeed = scanner2.nextDouble();
                        System.out.println("Введите цену:");
                        double price = scanner2.nextDouble();
                        if (type == 1) {
                            System.out.println("Это электрокар? (true/false)");
                            boolean isElectrical = scanner2.nextBoolean();
                            taxiPark.addCar(new Sedan(model, fuelConsumption, maxSpeed, price, isElectrical));
                        } else if (type == 2) {
                            taxiPark.addCar(new SUV(model, fuelConsumption, maxSpeed, price));
                        }
                        break;
                    case 2:
                        // Сортировать автомобили по расходу топлива
                        taxiPark.sortCarsByFuelConsumption();
                        break;
                    case 3:
                        // Подсчитать стоимость автопарка
                        System.out.println("Стоимость автопарка: " + taxiPark.calculateTotalPrice());
                        break;
                    case 4:
                        // Найти автомобиль по диапазону скорости
                        System.out.println("Введите минимальную скорость:");
                        double minSpeed = scanner.nextDouble();
                        System.out.println("Введите максимальную скорость:");
                        double maxSpeed1 = scanner.nextDouble();
                        Car car = taxiPark.findCarBySpeedRange(minSpeed, maxSpeed1);
                        if (car != null) {
                            System.out.println("Найденный автомобиль: " + car.getModel());
                        } else {
                            System.out.println("Автомобиль не найден");
                        }
                        break;
                    case 5:
                        taxiPark.getElements();
                        break;
                    case 6:
                        // Выход
                        return;
                    default:
                        System.out.println("Некорректный ввод");
                        break;
                }
            } catch (InputMismatchException e) {
            System.out.println("Пожалуйста, введите число");
            scanner.next(); // очистить некорректный ввод
                }
            }
        }
}