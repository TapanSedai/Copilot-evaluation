package code_optimization;

// creates an optimized version of the fibonacci function

public class Fibonacci {

    public static void main(String[] args) {
        long a = System.nanoTime();
        System.out.println(fibonacci3(30));
        long b = System.nanoTime();

        System.out.println("Time taken: " + (b - a) + "ms");

        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Used memory is bytes: " + memory);
    }

    public static int fibonacci1(int n) {

        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    // optimized version of fibonacci
    public static int fibonacci2(int n) {
        int[] fib = new int[n + 1];

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    // optimized version of fibonacci 
    // (uses less memory than fibonacci2)
    public static int fibonacci3(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i < n + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
    
}
