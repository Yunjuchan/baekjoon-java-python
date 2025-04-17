import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] rank = new int[N + 1];

        int[][] nations = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                nations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(nations, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
        });

        rank[nations[0][0]] = 1;
        for (int i = 1; i < N; i++) {
            if (nations[i - 1][1] == nations[i][1] && nations[i - 1][2] == nations[i][2] && nations[i - 1][3] == nations[i][3]) {
                rank[nations[i][0]] = rank[nations[i - 1][0]];
            } else {
                rank[nations[i][0]] = i + 1;
            }
        }

        System.out.println(rank[K]);
    }
}