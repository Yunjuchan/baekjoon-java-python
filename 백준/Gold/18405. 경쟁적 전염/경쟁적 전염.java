import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[] {1, 0, -1, 0};
    static int[] dx = new int[] {0, -1, 0, 1};

    public static class Virus {
        int t;
        int idx;
        int y;
        int x;

        public Virus(int t, int idx, int y, int x) {
            this.t = t;
            this.idx = idx;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        Queue<Virus> que = new LinkedList<>();
        List<List<Virus>> virusList = new ArrayList<>();

        for (int i = 0; i <= K; i++) {
            virusList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    continue;
                }
                virusList.get(arr[i][j]).add(new Virus(0, arr[i][j], i, j));
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 1; i <= K; i++) {
            for (Virus virus : virusList.get(i)) {
                que.offer(virus);
            }
        }

        while (!que.isEmpty()) {
            Virus cur = que.poll();
            if (cur.t == S) {
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || arr[ny][nx] != 0) {
                    continue;
                }
                arr[ny][nx] = cur.idx;
                if (cur.t == S - 1) {
                    continue;
                }
                que.offer(new Virus(cur.t + 1, cur.idx, ny, nx));
            }
        }

        System.out.println(arr[X][Y]);
    }
}


