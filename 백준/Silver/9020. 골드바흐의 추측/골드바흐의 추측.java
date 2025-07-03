import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[10001];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= 100; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = 2 * i; j <= 10000; j += i) {
                isNotPrime[j] = true;
            }
        }

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int left = 1;
            int right = N - 1;
            for (int i = 2; i <= N / 2; i++) {
                if (!isNotPrime[i] & !isNotPrime[N - i]) {
                    left = i;
                    right = N - i;
                }
            }
            sb.append(left).append(" ").append(right).append("\n");
        }
        System.out.println(sb);
    }
}