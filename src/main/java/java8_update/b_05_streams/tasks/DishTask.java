package java8_update.b_05_streams.tasks;

import static java.util.Comparator.comparing;

public class DishTask {
    public static void main(String[] args) {

        //Print all dish's name that has less than 400 calories
        System.out.println("***********************");
        DishData.getAll().stream()
                .filter(dish -> dish.getCalories() < 400)
                .map(Dish::getName)
             //   .forEach(s -> System.out.println(s))
                .forEach(System.out::println);


        System.out.println("********* Print the length of the name of each dish **************");

        //Print the length of the name of each dish
        DishData.getAll().stream()          // 1. option
                .map(dish -> dish.getName().length())
                .forEach(System.out::println);

        System.out.println("***********************");
        DishData.getAll().stream()   // 2. option
                .map(Dish::getName)
                .map(String::length)
                .forEach(System.out::println);

        //Print Three High Caloric Dish Name(>300)
        System.out.println("********* Print Three High Caloric Dish Name(>300) **************");
        DishData.getAll().stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .forEach(System.out::println);

        //Print all dish name that are below 400 calories in sorted
        System.out.println("********** Print all dish name that are below 400 calories in sorted from high to low *************");

        DishData.getAll().stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .forEach(System.out::println);

    }
}
