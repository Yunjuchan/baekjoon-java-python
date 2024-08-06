import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] building = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i=0; i<N; i++) {
            int cnt1 = 0;
            double minS = Integer.MAX_VALUE;
            for (int j=i-1; j>=0; j--) {
                double s = (double) (building[i] - building[j]) / (i-j);
                if (minS > s) {
                    cnt1++;
                    minS = s;
                }
            }

            int cnt2 = 0;
            double maxS = Integer.MIN_VALUE;
            for (int j=i+1; j<N; j++) {
                double s = (double) (building[j] - building[i]) / (j-i);
                if (maxS < s) {
                    cnt2++;
                    maxS = s;
                }
            }
            result = Math.max(result, cnt1+cnt2);
        }
        System.out.println(result);
    }
}