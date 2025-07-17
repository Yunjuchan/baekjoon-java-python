import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[119];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= 11; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = 2 * i; j <= 118; j += i) {
                if (!isPrime[j]) {
                    continue;
                }
                isPrime[j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            boolean possible = false;
            for (int j = 2; j < a; j++) {
                if (isPrime[j] && isPrime[a - j]) {
                    possible = true;
                    break;
                }
            }
            if (possible) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb);
    }
}