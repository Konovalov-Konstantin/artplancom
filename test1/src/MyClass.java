import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the line:");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
        System.out.println("Your reversed string: " + reverseString(input));
        long start = System.currentTimeMillis();

        int i;
        for(i = 0; i < 1000; ++i) {
            reverseString(input);
        }

        System.out.println("execution time after 1000 repetitions: " + (System.currentTimeMillis() - start) + " mc");

        for(i = 0; i < 10000; ++i) {
            reverseString(input);
        }

        System.out.println("execution time after 10000 repetitions: " + (System.currentTimeMillis() - start) + " mc");

        for(i = 0; i < 100000; ++i) {
            reverseString(input);
        }

        System.out.println("execution time after 100000 repetitions: " + (System.currentTimeMillis() - start) + " mc");
        scanner.close();
    }

    public static String reverseString(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }
}
