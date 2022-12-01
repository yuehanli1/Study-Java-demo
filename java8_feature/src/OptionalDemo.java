import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Integer values1 = null;
        Integer values2 = new Integer(10);

        //Optional.ofNullable 可以传递为null的参数
        Optional<Integer> a = Optional.ofNullable(values1);
        Optional<Integer> b = Optional.of(values2);
        System.out.println(sum(a, b));
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("第一个参数值是否存在: " + a.isPresent());
        System.out.println("第二个参数值是否存在: " + b.isPresent());

        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();
        return value1 + value2;
    }
}
