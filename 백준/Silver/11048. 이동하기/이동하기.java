import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dy = new int[]{-1,-1,0};
        int[] dx = new int[]{-1,0,-1};

        int[][] arr = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                int max = 0;
                for (int i = 0; i < 3; i++) {
                    int py = y + dy[i];
                    int px = x + dx[i];
                    if (py < 0 || px < 0) {
                        continue;
                    }
                    max = Math.max(max, arr[py][px]);
                }
                arr[y][x] = max + Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(arr[N - 1][M - 1]);
    }
}
