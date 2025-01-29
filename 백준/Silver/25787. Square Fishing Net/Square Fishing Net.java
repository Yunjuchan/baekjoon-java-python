import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        boolean[][] fish = new boolean[102][102];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            fish[x][y] = true;
        }
        for (int i = 1; i+s <= 101; i++) {
            for (int j = 1; j+s <= 101; j++) {
                int tmp = 0;
                for (int x = 0; x <= s; x++) {
                    for (int y = 0; y <= s; y++) {
                        if (fish[i+x][j+y]) {
                            tmp++;
                        }
                    }
                }
                result = Math.max(result, tmp);
            }
        }
        System.out.println(result);
    }
}