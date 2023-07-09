package code_optimization;

public class Factorial {

    // creates an optimized version of the factorial function
    public static void main(String[] args) {
        long a = System.nanoTime();
        System.out.println(factorial5(20));
        long b = System.nanoTime();

        System.out.println("Time taken: " + (b - a) + "ms");

        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Used memory is bytes: " + memory);
    }

    public static long factorial1(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial1(n - 1);

    }

    // optimized version of factorial

    public static long factorial2(int n) {
        long fact = 1;

        for (int i = 1; i < n + 1; i++) {
            fact *= i;
        }

        return fact;
    }

    // optimized version of factorial

    public static int factorial3(int n) {
        int fact = 1;

        for (int i = n; i > 0; i--) {
            fact *= i;
        }

        return fact;
    }

    // optimized version of factorial

    public static int factorial4(int n) {
        int fact = 1;

        while (n > 0) {
            fact *= n;
            n--;
        }

        return fact;
    }

    // optimized version of factorial

    public static long factorial5(int n) {
       long factorial[] = new long[n + 1];
       factorial[0] = 1;
       factorial[1] = 1;
       factorial[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            factorial[i] = i * factorial[i - 1];
        }

        return factorial[n];
        
    }
    
}
