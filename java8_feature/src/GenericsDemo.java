import java.util.Arrays;

/*
E - Element (在集合中使用，因为集合中存放的是元素)
T - Type（Java 类）
K - Key（键）
V - Value（值）
N - Number（数值类型）
？ - 表示不确定的 java 类型
 */
public class GenericsDemo<T> {

    private T first;

    private T last;

    public GenericsDemo(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    @SafeVarargs
    private static <T> T[] asArrays(T... objs) {
        return objs;
    }

    public static void main(String[] args) {
        System.out.println("-------------basic-----------------");
        basic();
        System.out.println("-------------advance-----------------");
        String[] arr = asArrays("one", "two", "three");
        System.out.println(Arrays.toString(arr));
        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));

    }

    private static <K> K[] pickTwo(K one, K two,K three) {
        return asArrays(one, two);
    }

    private static void basic() {
        GenericsDemo<? super Integer> demo1 = new GenericsDemo<>(122, 12);
        GenericsDemo<?> demo2 = new GenericsDemo<>("name", 123);
        System.out.println("first: " + demo1.getFirst());
        System.out.println("last: " + demo1.getLast());
        System.out.println("first: " + demo2.getFirst());
        System.out.println("last: " + demo2.getLast());
    }
}
