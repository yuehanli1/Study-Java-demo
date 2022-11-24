import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        mapDemo();
        filterDemo();
        reduceDemo();
        groupByDemo();
    }

    private static void mapDemo() {
        List<String> list = Arrays.asList("  Apple","  Banana","Blackberry  ", "  Coconut", "Avocado", "Cherry", "Apricots");
        System.out.println("----------map--------------");
        list.stream().map(String::toLowerCase).map(String::trim).forEach(System.out::println);
    }

    private static void filterDemo() {
        List<String> list = Arrays.asList("Apple", null, "Banana", "", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        System.out.println("----------filter--------------");
        System.out.println(list.stream().filter(s -> s != null && !s.isEmpty()).collect(Collectors.toList()));
    }

    private static void reduceDemo() {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 10).reduce(0, (acc, n) -> acc + n);
        System.out.println("----------reduce--------------");
        System.out.println(sum);
    }

    private static void groupByDemo() {
        List<String> list = Arrays.asList("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        System.out.println("----------groupBy--------------");
        System.out.println(list.stream().collect(Collectors.groupingBy(s -> s.substring(0,1), Collectors.toList())));
    }


}
