import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] DP = new long[d + 1][d / 2 + 1];
        DP[1][1] = 1;
        int[] direct = new int[]{1,-1};

        for (int i=1; i<d; i++) {
            for (int j=1; j<=d/2; j++) {
                for (int k=0; k<2; k++) {
                    int h = j + direct[k];
                    if (h < 0 || h > d/2) { continue; }
                    DP[i+1][h] += DP[i][j];
                    DP[i+1][h] %= m;
                }
            }
        }
        System.out.println(DP[d][0] % m);
    }
}