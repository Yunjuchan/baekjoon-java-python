import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] P = new int[N];
        int [] DP = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        DP[0] = P[0];
        int result = P[0];
        for (int i=1; i<N; i++) {
            DP[i] = Integer.max(DP[i-1]+P[i], P[i]);
            if (result < DP[i]) {
                result = DP[i];
            }
        }

        System.out.println(result);
    }
}