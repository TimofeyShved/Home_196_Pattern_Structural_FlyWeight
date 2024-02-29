package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // В данном примере мы используем несколько переменных с одними и теми же данными
        // поэтому что бы не плодить одинаковые данные,
        // был применен паттерн(Легкости)

        GarageCars garageCars = new GarageCars();
        Car car = garageCars.getCar("green");
        Car car2 = garageCars.getCar("green");
        Car car3 = garageCars.getCar("green");
        System.out.println(car.color);

    }
}

// наш обычный класс
class Car{
    String color;
}

// но мы создаём место где хранятся все вариации его значений
// и если при выдачи данных он уже записан,
// то создавать и выделять под него места не надо
class GarageCars{
    Map<String, Car> carMap = new HashMap<>();

    public Car getCar(String color) {
        Car car = carMap.get(color);
        if (car!=null) {
            car = new Car();
            car.color = color;
            carMap.put(color, car);
        }
        return car;
    }
}