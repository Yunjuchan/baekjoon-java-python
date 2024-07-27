import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            if (K >= N-1) {
                sb.append(N).append(" ");
                K -= N-1;
                N--;
            } else {
                for (int i=1; i<N-K; i++) {
                    sb.append(i).append(" ");
                }
                sb.append(N).append(" ");
                for (int i=N-K; i<N; i++) {
                    sb.append(i).append(" ");
                }
                N = 0;
            }
        }

        if (N!=0) {
            for (int i=1; i<=N; i++) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}