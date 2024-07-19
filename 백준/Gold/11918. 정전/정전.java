import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> A = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            A.add(new int[]{x-M, x+M});
        }
        A.sort((a, b) -> (a[0] - b[0]));
        int lastCover = Integer.MIN_VALUE;
        long result = 0;
        for (int i=0; i<N-1; i++) {
            if (A.get(i)[1] - A.get(i+1)[0] > 0) {
                result += A.get(i)[1] - Math.max(lastCover, A.get(i+1)[0]);
                lastCover = A.get(i)[1];
            }
        }
        System.out.println(result);
    }
}