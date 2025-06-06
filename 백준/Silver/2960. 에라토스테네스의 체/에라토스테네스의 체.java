import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[N + 1];
        int cnt = 1;


        for (int i = 2; i <= N; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i; j <= N; j += i) {
                if (isNotPrime[j]) {
                    continue;
                }
                isNotPrime[j] = true;
                if (cnt == K) {
                    System.out.println(j);
                    return;
                }
                cnt++;
            }
        }
    }
}