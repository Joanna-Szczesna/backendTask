package pl.szczesnaj.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lam {
    void consumerExample() {
        Car carO = new Car("Ford", "Red");
        Consumer<String> consumer2 = s -> System.out.println(s);

        Consumer<String> consumer = System.out::println;
        consumer.accept(carO.getColor());
    }

    void functionExample() {
        Function<Integer, String> fun = String::valueOf;
        String applied = fun.apply(5);
        System.out.println(applied);
    }

    void biFunctionExample() {
        BiFunction<String, String, Integer> findIndex = (s1, s2) -> s1.indexOf(s2);

        BiFunction<String, String, Integer> findIndexMethodRef = String::indexOf;
        System.out.println("Index: " + findIndex.apply("Ford", "or"));
    }

    void sumReduceExample() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = list.stream().reduce(0, (n1, n2) -> n1 + n2);
        int sum2 = list.stream().reduce(0, Integer::sum);

    }

    void upperCaseReduceExample() {
        List<String> listSt = Arrays.asList("a", "b", "c", "d", "e");

        String result = listSt
                .stream()
                .reduce("", (part, element) -> part + element.toUpperCase());
        System.out.println(result); //result: ABCDE
    }

    void flatMapExample() {
        List<Person> personList = List.of(
                new Person("Jhon", List.of(
                        new Car("Ford", "Black"), new Car("Toyota", "Red"))
                ),
                new Person("Paul", List.of(
                        new Car("Kia", "Red"), new Car("Seat", "Yellow"))
                ),
                new Person("Sam", List.of(
                        new Car("Ford", "Black"))
                )
        );

        List<String> collect = personList.stream()
                .flatMap(person -> person.getCars().stream())
                .map(car -> car.getName())
                .distinct()
                .toList();
    }

    class Person {
        private String name;
        private List<Car> cars;

        public Person(String name, List<Car> cars) {
            this.name = name;
            this.cars = cars;
        }

        public String getName() {
            return name;
        }

        public List<Car> getCars() {
            return cars;
        }
    }

    class Car {
        private String name;
        private String color;

        public Car(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public String changeColor(String color) {
            this.color = color;
            return "New color is " + color;
        }
    }
}
//String[] pets = {"cat", "dog", "fish"};
//        System.out.println(Arrays.toString(pets));