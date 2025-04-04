import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] prev;
    static int[][] X;

    public static int binarySearch(int target, int idx) {
        int s = 0, e = idx;
        int x = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (mid >= N) {
                break;
            }

            if (X[mid][0] < target) {
                s = mid + 1;
                x = mid;
            } else if (X[mid][0] >= target) {
                e = mid - 1;
            }
        }

        X[x + 1][0] = Math.min(X[x + 1][0], target);
        prev[idx] = X[x][1];
        X[x + 1][1] = idx;

        return x + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int max = 1;

        int[][] lines = new int[N][2];
        boolean[] used = new boolean[N];
        prev = new int[N];
        X = new int[N + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            X[i][0] = Integer.MAX_VALUE;
        }

        X[0][0] = Integer.MIN_VALUE;
        X[0][1] = -1;



        for (int i = 0; i < N; i++) {
            max = Math.max(max, binarySearch(lines[i][1], i));
        }
        sb.append(N - max).append("\n");

        int now = X[max][1];
        while (now != -1) {
            used[now] = true;
            now = prev[now];
        }

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                lst.add(lines[i][0]);
            }
        }

        Collections.sort(lst);

        for (int x : lst) {
            sb.append(x).append("\n");
        }

        System.out.println(sb);
    }
}
