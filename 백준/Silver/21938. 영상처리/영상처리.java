import java.io.*;
import java.util.*;

class Coordinate {
    int y;
    int x;
    Coordinate (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Coordinate> que;
        int[] directY = {1,0,-1,0};
        int[] directX = {0,-1,0,1};

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int sum = 0;
                for (int k=0; k<3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                A[i][j] = sum/3;
            }
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (A[i][j] >= T && !visited[i][j]) {
                    result++;
                    visited[i][j] = true;
//                    System.out.println("i: " + i + " j: " + j);
                    que = new LinkedList<>();
                    que.add(new Coordinate(i, j));
                    while (!que.isEmpty()) {
                        Coordinate c = que.poll();
//                        System.out.println("c.x: " + c.x + " c.y: " + c.y);
                        for (int k=0; k<4; k++) {
                            int ny = directY[k] + c.y;
                            int nx = directX[k] + c.x;
                            if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || A[ny][nx] < T) {
                                continue;
                            }
                            visited[ny][nx] = true;
                            que.offer(new Coordinate(ny, nx));
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}