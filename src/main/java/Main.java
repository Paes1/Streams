import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {

        List<String> cities = List.of(
                "Munich", "Berlin", "Hamburg", "Cologne", "Madrid", "Helsinki", "Milan"
        );

        List<String> names = List.of(
                "Alice", "Bob", "Anna", "Brian", "Charlie"
        );

        List<Double> numbers = List.of(
                10.5, 20.0, 30.5, 40.0
        );

        List<List<String>> nestedCities = List.of(
                List.of("Munich", "Berlin"),
                List.of("Hamburg", "Cologne"),
                List.of("Madrid", "Milan")
        );

        // Aufgabe 1
        filterCitiesWithM(cities);

        // Aufgabe 2
        capitaliseCityNames(cities);

        // Aufgabe 3
        reduceCities(cities);

        // Aufgabe 4
        findCityStartingWithH(cities);

        // Aufgabe 5
        flatMapCities(nestedCities);

        // Aufgabe 6
        averageNumbers(numbers);

        // Aufgabe 7
        nameLength(names);

        // Aufgabe 8
        longestCity(cities);

        // Aufgabe 9
        groupNames(names);

        // Aufgabe 10
        uniqueFirstLetters(cities);
    }


    // Aufgabe 1
    static void filterCitiesWithM(List<String> cities) {
        System.out.println(cities.stream().filter(s -> s.startsWith("M")).sorted().toList());
    }

    // Aufgabe 2
    static void capitaliseCityNames(List<String> cities) {
        cities.stream().map(String::toUpperCase).forEach(s -> System.out.println(s.length()));
    }

    // Aufgabe 3
    static void reduceCities(List<String> cities) {
        System.out.println(cities.stream().reduce("", (s, s2) -> s + " , " + s2));
    }

    // Aufgabe 4
    static void findCityStartingWithH(List<String> cities) {
        if (cities.stream().anyMatch(s -> s.startsWith("H"))) {
            System.out.println("Contains city start with H");
        }
        cities.stream().filter(s -> s.length() < 8).forEach(System.out::println);
    }

    // Aufgabe 5
    static void flatMapCities(List<List<String>> cities) {
        System.out.println(cities.stream().flatMap(Collection::stream).count());
    }

    // Aufgabe 6
    static void averageNumbers(List<Double> numbers) {
        System.out.println(numbers.stream().mapToDouble(Double::doubleValue).average());
    }

    // Aufgabe 7
    static void nameLength(List<String> names) {
        System.out.println(names.stream().map(String::length).toList());
    }

    // Aufgabe 8
    static void longestCity(List<String> cities) {
        cities.stream().sorted((o1, o2) -> o2.length() - o1.length()).findFirst().ifPresent(System.out::println);
    }

    // Aufgabe 9
    static void groupNames(List<String> names) {
        System.out.println(names.stream().collect(Collectors.groupingBy(s -> s.charAt(0))));
    }

    // Aufgabe 10
    static void uniqueFirstLetters(List<String> cities) {
        System.out.println(cities.stream().map(s -> s.charAt(0)).collect(Collectors.toUnmodifiableSet()));
    }
}
