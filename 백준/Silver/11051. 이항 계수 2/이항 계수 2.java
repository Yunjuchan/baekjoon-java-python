import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        final int MOD = 10007;

        int[][] bin = new int[1001][1001];

        for (int i = 0; i <= 1000; i++) {
            bin[i][0] = bin[i][i] = 1;
        }

        for (int i = 2; i <= 1000; i++) {
            for (int j = 1; j < i; j++) {
                bin[i][j] = (bin[i - 1][j - 1] + bin[i - 1][j]) % MOD;
            }
        }
        
        System.out.println(bin[N][K]);
    }
}