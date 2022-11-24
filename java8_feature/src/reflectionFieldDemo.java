import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class reflectionFieldDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("-------------------class-----------------");
        getStdClass();
        System.out.println("-------------------method-----------------");
        getMethod();
        exampleForInvokeMethod();
        System.out.println("-------------------superclass-----------------");
        getSuperClass();
        System.out.println("-------------------interface-----------------");
        getInterface();
    }

    private static void getInterface() {
        Class superclass = Integer.class.getSuperclass();
        Class[] interfaces = superclass.getInterfaces();
        for (Class i: interfaces) {
            System.out.println(i);
        }
    }

    private static void getSuperClass() {
        Class superclass = Integer.class.getSuperclass();
        System.out.println(superclass);
        System.out.println(superclass.getSuperclass());
    }

    private static void getStdClass() throws Exception {
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass.getField("score"));
        System.out.println(studentClass.getField("grade"));
        System.out.println(studentClass.getField("name"));
        System.out.println(studentClass.getField("score").getName());
        System.out.println(studentClass.getField("score").getType());
        int modifier = studentClass.getField("score").getModifiers();
        System.out.println(Modifier.isFinal(modifier));
        System.out.println(Modifier.isPublic(modifier));
        System.out.println(Modifier.isStatic(modifier));
    }

    private static void getMethod() throws Exception {
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass.getMethod("getScore", String.class));
    }

    private static void exampleForInvokeMethod() throws Exception {
        String s = "Hello world";
        Method method = String.class.getMethod("substring", int.class);
        System.out.println(method.invoke(s, 6));
        System.out.println(s.substring(6));
    }
}

class Student extends Person {
    public int score;
    public int grade;

    public int getScore(String type) {
        return 99;
    }
}

class Person {
    public String name;
}
