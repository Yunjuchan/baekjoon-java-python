import java.io.*;
import java.util.*;

public class Main {

    public static double combination(double N, double K) {
        if (K > N) {
            return 0;
        }

        K = Math.min(K, N - K);

        double result = 1;

        for (int i = 1; i <= K; i++) {
            result *= (N - K + i) / (double) i;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        double N = 0;
        double[] stones = new double[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stones[i] = Double.parseDouble(st.nextToken());
            N += stones[i];
        }

        double K = Double.parseDouble(br.readLine());
        double total = combination(N, K);
        double possible = 0;
        for (int i = 0; i < M; i++) {
            possible += combination(stones[i], K);
        }

        System.out.println(possible / total);
    }
}
