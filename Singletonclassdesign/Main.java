//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Ensure that only one instance of the Singleton class is created
        if (singleton1 == singleton2) {
            System.out.println("Both instances are the same,which means that only one instance is created.");
        } else {
            System.out.println("Error: Different instances were created.");
        }

        // Demonstrate that multiple calls to the static method return the same instance
        System.out.println("First instance: " + singleton1);
        System.out.println("Second instance: " + singleton2);
    }
}
