import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        List<int[]> B = new ArrayList<>();
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (i>0) {
                B.add(new int[]{i, A[i] - A[i-1]});
            }
        }
        B.sort((a, b) -> (b[1] - a[1]));

        List<Integer> C = new ArrayList<>();
        for (int i=0; i<M-1; i++) {
            C.add(B.get(i)[0]);
        }
        C.sort((a, b) -> (a - b));
        int start = 0;
        long result = 0;
        for (int idx : C) {
            result += A[idx-1] - A[start];
            start = idx;
        }
        result += A[N-1] - A[start];

        System.out.println(result);
    }
}