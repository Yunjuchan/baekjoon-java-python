import java.io.*;
import java.util.*;
class Position {
    int y;
    int x;

    Position (int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    static int N, M;
    static int[][] A;
    static int[] directY = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] directX = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Position> B = new ArrayList<>();
        B.add(new Position(N - 1, 0));
        B.add(new Position(N - 1, 1));
        B.add(new Position(N - 2, 0));
        B.add(new Position(N - 2, 1));
        for (int m=0; m<M; m++) {
            boolean[][] visited = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            for (Position p : B) {
                p.y = (p.y + directY[d-1] * s) % N;
                p.x = (p.x + directX[d-1] * s) % N;
                // 음수일 경우 처리
                if (p.y < 0) p.y += N;
                if (p.x < 0) p.x += N;

                A[p.y][p.x]++;
                visited[p.y][p.x] = true;
            }
            for (Position p : B) {
                int cnt = 0;
                for (int j = 1; j < 8; j += 2) {
                    int dy = p.y + directY[j];
                    int dx = p.x + directX[j];
                    if (dy < 0 || dx < 0 || dy >= N || dx >= N || A[dy][dx] == 0) {
                        continue;
                    }
                    cnt++;
                }
                A[p.y][p.x] += cnt;
            }

            B = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] < 2 || visited[i][j]) {
                        continue;
                    }
                    A[i][j] -= 2;
                    B.add(new Position(i, j));
                }
            }
        }
        int result = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                result += A[i][j];
            }
        }
        System.out.println(result);
    }
}