import java.io.*;
import java.util.*;

public class Main {
    static int result = 0;
    static int[] parents;
    public static int find(int x) {
        if (parents[x] == -1) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union (int a, int b, int w) {
        int fa = find(a);
        int fb = find(b);

        if (fa > fb) {
            int tmp = fa;
            fa = fb;
            fb = tmp;
        }

        if (fa == fb) {
            return;
        }

        parents[fb] = fa;
        result += w;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        Arrays.fill(parents, -1);

        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int[] edge : edges) {
            union(edge[0], edge[1], edge[2]);
        }

        System.out.println(result);
    }
}