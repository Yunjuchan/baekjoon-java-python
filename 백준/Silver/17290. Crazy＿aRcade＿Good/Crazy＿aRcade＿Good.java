import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int answer = Integer.MAX_VALUE;

        boolean[][] water = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                char w = line.charAt(j);
                if (w == 'x') {
                    continue;
                }
                for (int k = 0; k < 10; k++) {
                    water[i][k] = true;
                    water[k][j] = true;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (water[i][j]) {
                    continue;
                }
                int dist = Math.abs(r - i) + Math.abs(c - j);
                answer = Math.min(answer, dist);
            }
        }

        System.out.println(answer);
    }
}