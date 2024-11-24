import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] isPrime = new boolean[246913];
        isPrime[0] = isPrime[1] = true;
        int[] sum = new int[246913];
        for (int i=2; i<246913; i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j=2; i*j<=246912; j++) {
                isPrime[i*j] = true;
            }
        }
        for (int i=1; i<246913; i++) {
            sum[i] = sum[i-1];
            if (!isPrime[i]) {
                sum[i]++;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) {
                return;
            }
            System.out.println(sum[2*x] - sum[x]);
        }
    }
}