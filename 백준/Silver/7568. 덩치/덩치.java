import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people[i][0] = x;
            people[i][1] = y;
        }

        int[] rank = new int[N];
        Arrays.fill(rank, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank[i]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(rank[i]).append(" ");
        }
        System.out.println(sb);
    }
}