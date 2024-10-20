import java.io.*;
import java.util.*;

public class Main {
    public static class Sangho {
        int y;
        int x;

        public Sangho(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] campus = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] directY = new int[]{1,0,-1,0};
        int[] directX = new int[]{0,1,0,-1};

        Sangho s = new Sangho(0, 0);
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            campus[i] = st.nextToken().toCharArray();
            for (int j=0; j<M; j++) {
                if (campus[i][j] == 'I') {
                    s = new Sangho(i, j);
                    visited[i][j] = true;
                }
            }
        }

        int result = 0;
        Queue<Sangho> que = new LinkedList<>();
        que.offer(s);


        while (!que.isEmpty()) {
            Sangho sangho = que.poll();
            for (int i=0; i<4; i++) {
                int dy = sangho.y + directY[i];
                int dx = sangho.x + directX[i];
                if (dy < 0 || dx < 0 || dy >= N || dx >= M || visited[dy][dx] || campus[dy][dx] == 'X') {
                    continue;
                }
                visited[dy][dx] = true;
                que.offer(new Sangho(dy, dx));
                if (campus[dy][dx] == 'P') {
                    result++;
                }
            }
        }
        if (result != 0) {
            System.out.println(result);
        } else {
            System.out.println("TT");
        }

    }
}