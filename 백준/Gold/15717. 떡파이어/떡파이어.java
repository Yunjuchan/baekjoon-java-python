import java.io.*;
import java.util.*;
public class Main {


    static final long MOD = 1_000_000_007;

    public static long aging(long year) {
        if (year <= 0) {
            return 1;
        }

        long half = aging(year / 2);
        long result = (half * half) % MOD;
        if (year % 2 == 1) {
            result = result * 2 % MOD;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long result = aging(N - 1);
        System.out.println(result);
    }
}