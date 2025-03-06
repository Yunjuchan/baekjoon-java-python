import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] Q = new int[M];

        for (int i = 0; i < M; i++) {
            Q[i] = Integer.parseInt(st.nextToken());
        }
        int diffY = Math.abs(c1 - c2);
        int diffX = Integer.MAX_VALUE;
        int cnt = 0;

        Arrays.sort(P);
        Arrays.sort(Q);

        for (int i = 0; i < N; i++) {
            int p = P[i];
            int s = 0;
            int e = M - 1;
            while (s <= e) {
                int mid = (s + e) / 2;
                int tmp = Q[mid] - p;
                if (tmp > 0) {
                    e = mid - 1;
                    if (diffX > Math.abs(tmp)) {
                        diffX = Math.abs(tmp);
                        cnt = 1;
                    } else if (diffX == Math.abs(tmp)) {
                        cnt++;
                    }
                } else if (tmp == 0) {
                    if (diffX == 0) {
                        cnt++;
                    } else {
                        diffX = 0;
                        cnt = 1;
                    }
                    break;
                } else {
                    s = mid + 1;
                    if (diffX > Math.abs(tmp)) {
                        diffX = Math.abs(tmp);
                        cnt = 1;
                    } else if (diffX == Math.abs(tmp)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println((diffX + diffY) + " " + cnt);

    }
}
