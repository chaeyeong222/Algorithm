import java.util.Scanner;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        System.out.println(fib(n)[0]);
    }

    static long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};

        long[] ab = fib(n / 2);
        long a = ab[0]; // F(k)
        long b = ab[1]; // F(k+1)

        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD; // F(2k)
        long d = (a * a % MOD + b * b % MOD) % MOD;           // F(2k+1)

        if (n % 2 == 0) {
            return new long[]{c, d};
        } else {
            return new long[]{d, (c + d) % MOD};
        }
    }
}
