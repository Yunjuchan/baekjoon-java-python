import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i=0; i<N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<N-1; i++) {
            int diff = Integer.MAX_VALUE;
            int exception = -1;
            List<Integer> B = new ArrayList<>();
            for (int j=0; j<N-i; j++) {
                if (A.get(j) == N-i) {
                    exception = j;
                    if (j-1 >= 0) {
                        diff = Math.min(diff, Math.abs(A.get(j) - A.get(j-1)));
                    }
                    if (j+1 < N-i) {
                        diff = Math.min(diff, Math.abs(A.get(j) - A.get(j+1)));
                    }
                }
            }
            result += diff;
            for (int j=0; j<N-i; j++) {
                if (j == exception) {
                    continue;
                }
                B.add(A.get(j));
            }
            A = B;
        }
        System.out.println(result);
    }
}