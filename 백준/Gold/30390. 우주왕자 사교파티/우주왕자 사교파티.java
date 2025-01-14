import java.io.*;
import java.util.*;

public class Main {

    public static List<Long> getDivisors(long n) {
        List<Long> divisors = new ArrayList<>();
        for (long i=1; i*i<=n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        divisors.sort(Comparator.reverseOrder());
        return divisors;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long C = A + B;
        long result = 0;

        List<Long> divisors = getDivisors(C);
        for (long x : divisors) {
            long a = A % x;
            long b = B % x;
            if (Math.min(a, b) <= K) {
                result = x;
                break;
            }
        }

        System.out.println(result);
    }


}