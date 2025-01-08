import java.io.*;
import java.util.*;

public class Main {

    public static long gcd(long a, long b) {

        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static long lcd(long a, long b, long g) {
        return a * b / g;
    }

    public static int countDivisors(long n) {
        int count = 0;
        int divisors = 1;

        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        divisors *= (count + 1);

        for (long i=3; i*i<=n; i+=2) {
            count = 0;
            while (n%i == 0) {
                count++;
                n /= i;
            }
            divisors *= (count + 1);
        }

        if (n > 1) {
            divisors *= 2;
        }

        return divisors;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long g = gcd(A, B);
        long l = lcd(A, B, g);

        if (g != A) {
            System.out.println(0);
            return;
        }

        long res = l / A;
        int divisorCount = countDivisors(res);
        System.out.println(divisorCount);
    }
}