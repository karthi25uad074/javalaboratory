import java.util.*;

public class GenericMaximum {

    // Generic method to find maximum element
    public static <T extends Comparable<T>> T findMax(Collection<T> collection) {
        T max = collection.iterator().next();

        for (T element : collection) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Integer input
        System.out.print("Enter number of integers: ");
        int n = sc.nextInt();

        List<Integer> integers = new ArrayList<>();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            integers.add(sc.nextInt());
        }

        System.out.println("Maximum Integer: " + findMax(integers));

        // Float input
        System.out.print("\nEnter number of floats: ");
        int m = sc.nextInt();

        List<Float> floats = new ArrayList<>();

        System.out.println("Enter " + m + " float values:");
        for (int i = 0; i < m; i++) {
            floats.add(sc.nextFloat());
        }

        System.out.println("Maximum Float: " + findMax(floats));

        // String input
        System.out.print("\nEnter number of strings: ");
        int s = sc.nextInt();

        List<String> strings = new ArrayList<>();

        System.out.println("Enter " + s + " strings:");
        for (int i = 0; i < s; i++) {
            strings.add(sc.next());
        }

        System.out.println("Maximum String: " + findMax(strings));

        sc.close();
    }
}