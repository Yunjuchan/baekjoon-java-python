import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;

    static void dfs(int start, int level, int[] arr, int[] now) {
        if (level == 6) {
            for (int i=0; i<6; i++) {
                sb.append(now[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<arr.length; i++) {
            now[level] = arr[i];
            dfs(i+1, level+1, arr, now);
            now[level] = 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                System.out.println(sb.toString());
                return;
            }
            int[] arr = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0, arr, new int[6]);
            sb.append("\n");
        }
    }
}