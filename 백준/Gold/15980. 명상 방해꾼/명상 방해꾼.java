import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] rl = new char[N+1];
        String[] noise = new String[N+1];
        int[] L = new int[M];
        int[] R = new int[M];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            rl[i] = st.nextToken().charAt(0);
            noise[i] = st.nextToken();
            int cnt = 0;
            for (int j=0; j<M; j++) {
                cnt += noise[i].charAt(j) - '0';
                if (rl[i] == 'L') {
                    L[j] += cnt;
                } else {
                    R[j] += cnt;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int n = -1;
        for (int i=1; i<=N; i++) {
            int cnt = 0;
            int tmp = 0;
            for (int j=0; j<M; j++) {
                cnt += noise[i].charAt(j) - '0';
                if (rl[i] == 'L') {
                    tmp = Math.max(tmp, Math.abs(L[j] - cnt - R[j]));
                } else {
                    tmp = Math.max(tmp, Math.abs(L[j] + cnt - R[j]));
                }
            }
            if (tmp < result) {
                result = tmp;
                n = i;
            }
        }
        System.out.println(n);
        System.out.println(result);

    }
}