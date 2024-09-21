import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Position {
        int x;
        int y;
        int cnt;

        public Position(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int X, Y;
    static int[] directX = {1,0,-1,0};
    static int[] directY = {0,1,0,-1};
    static boolean[][] visited;
    public static int bfs() {
        Queue<Position> que = new LinkedList<>();
        que.add(new Position(500,500,0));
        visited[500][500] = true;
        while (!que.isEmpty()) {
            Position now = que.poll();
//            System.out.println("x: " + now.x + " y: " + now.y + " cnt: " + now.cnt);
            if (now.x == X && now.y == Y) {
                return now.cnt;
            }
            for (int i=0; i<4; i++) {
                int nextX = now.x + directX[i];
                int nextY = now.y + directY[i];
                if (nextX < 0 || nextY < 0 || nextX > 1000 || nextY > 1000 || visited[nextX][nextY]) {
                    continue;
                }
                visited[nextX][nextY] = true;
                que.add(new Position(nextX, nextY, now.cnt+1));
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()) + 500;
        Y = Integer.parseInt(st.nextToken()) + 500;
        int N = Integer.parseInt(st.nextToken());
        visited = new boolean[1001][1001];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 500;
            int y = Integer.parseInt(st.nextToken()) + 500;
            visited[x][y] = true;
        }
        int result = bfs();
        System.out.println(result);

    }
}