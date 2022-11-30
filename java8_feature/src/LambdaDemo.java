import java.util.Arrays;

public class LambdaDemo {
    /**
     *可以用Lambda代替方法
     */
    public static void main(String[] args) {
        lambda();

        methodReference();
    }

    private static void methodReference() {
        String[] array = new String[] {"Apple", "Orange", "Banana", "Lemon"};
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(",", array));
    }

    private static void lambda() {
        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": Old Runnable");
            }
        };

        Runnable newRunnable = () -> {
          System.out.println(Thread.currentThread().getName() + ": New Lambda Runnable");
        };
        new Thread(oldRunnable).start();
        new Thread(newRunnable).start();
    }


}
