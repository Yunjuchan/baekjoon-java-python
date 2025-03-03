import java.io.*;
import java.util.*;

public class Main {

    static int[] par;

    public static int find(int x) {
        if (par[x] == x) {
            return par[x];
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa == fb) {
            return;
        } else if (fa < fb) {
            par[fb] = fa;
        } else {
            par[fa] = fb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int result = 0;
        par = new int[C + 1];

        for (int i = 1; i <= C; i++) {
            par[i] = i;
        }


        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            int[] road = new int[3];
            for (int i = 0; i < 3; i++) {
                road[i] = Integer.parseInt(st.nextToken());
            }
            que.offer(road.clone());
        }

        Queue<Integer> destination = new LinkedList<>();
        for (int d = 0; d < D; d++) {
            destination.offer(Integer.parseInt(br.readLine()));
        }

        while (!que.isEmpty() && !destination.isEmpty()) {
            int[] road = que.poll();
            union(road[0], road[1]);
            result = road[2];
            int dSize = destination.size();

            for (int i = 0; i < dSize; i++) {
                int dest = destination.poll();
                if (find(dest) != 1) {
                    destination.offer(dest);
                }
            }
        }

        System.out.println(result);
    }
}