import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] cakes = new int[2][3];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cakes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sb.append(cakes[1][0] - cakes[0][2]).append(" ");
        sb.append(cakes[1][1] / cakes[0][1]).append(" ");
        sb.append(cakes[1][2] - cakes[0][0]).append(" ");
        System.out.println(sb);
    }
}
