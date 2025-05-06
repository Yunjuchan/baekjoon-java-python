import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, S, E;
    public static int[] par;
    public static int[][] adj;

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int A, int B) {
        int fa = find(A);
        int fb = find(B);

        if (fa == fb) {
            return;
        }

        par[fb] = fa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[M][3];
        par = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            par[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (A > B) {
                int tmp = A;
                A = B;
                B = tmp;
            }
            adj[i] = new int[] {A, B, C};
        }

        Arrays.sort(adj, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        if (S > E) {
            int tmp = S;
            S = E;
            E = tmp;
        }
        int result = 0;

        for (int i = 0; i < M; i++) {
//            System.out.println(par[S] + " " + par[E]);
//            System.out.println(adj[i][0] + " " + adj[i][1] + " " + adj[i][2]);
            if (find(S) == find(E)) {
                System.out.println(result);
                return;
            }
            union(adj[i][0], adj[i][1]);
            result = adj[i][2];
        }

        System.out.println(result);
    }
}
