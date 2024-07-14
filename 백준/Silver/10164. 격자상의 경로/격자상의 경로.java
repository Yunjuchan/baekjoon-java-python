import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;
        long[] DP = new long[N*M];

        DP[0] = 1;

        for (int i=0; i<N*M; i++) {
            if (i+M == K) {
                DP[i+M] += DP[i];
            } else if (i+1 == K) {
                if ((i+1) % M == 0) {
                    continue;
                }
                DP[i+1] += DP[i];
            } else {
                if (i+M < N*M) {
                    DP[i+M] += DP[i];
                }
                if ((i+1) % M != 0 && i+1 < N*M ) {
                    DP[i+1] += DP[i];
                }
            }
        }
        if (K != -1) {
            for (int i=0; i<N*M; i++) {
                if (i != K) {
                    DP[i] = 0;
                }
            }

            for (int i=K; i<N*M; i++) {
                if (i+M < N*M) {
                    DP[i+M] += DP[i];
                }
                if ((i+1) % M != 0 && i+1 < N*M ) {
                    DP[i+1] += DP[i];
                }
            }
        }

        System.out.println(DP[N*M-1]);
    }
}