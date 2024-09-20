import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] cross = new int[N];
        long[] left = new long[N];
        long[] right = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            cross[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
            left[i] += left[i-1];
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N-1; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=N-1; i>0; i--) {
            right[i-1] += right[i];
        }

        int idx = 0;
        long Min = Long.MAX_VALUE;

        for (int i=0; i<N; i++) {
            long tmp = left[i] + cross[i] + right[i];
            if (Min > tmp) {
                Min = tmp;
                idx = i+1;
            }
        }
        System.out.println(idx + " " + Min);
    }
}