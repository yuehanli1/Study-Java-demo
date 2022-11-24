import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class reflectionDynamicProxyDemo {
    public static void main(String[] args) throws Throwable {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("----------------proxy--------------");
                    System.out.println("Good morning," + args[0]);
                }
                return null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[] {Hello.class},
                handler
        );

        System.out.println("--------------implements----------");
        hello.morning("morning");
        HelloDynamicProxy dynamicProxy = new HelloDynamicProxy(handler);
        dynamicProxy.morning("morning");
    }
}

interface Hello {
    void morning(String name) throws Throwable;
}

class HelloDynamicProxy implements Hello {
    InvocationHandler handler;

    public HelloDynamicProxy(InvocationHandler handler) {
        this.handler = handler;
    }

    public void morning(String name) throws Throwable {
        handler.invoke(this, Hello.class.getMethod("morning", String.class), new Object[] {name});
    }
}
