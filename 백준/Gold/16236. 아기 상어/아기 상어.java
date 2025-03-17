import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static int[] dy, dx;
    static int[][] arr;

    static Shark shark;

    public static class Move {
        int y;
        int x;
        int t;

        public Move(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }
    public static class Shark {

        int y;
        int x;
        int size;
        int sizeUp;

        public Shark(int y, int x, int size, int sizeUp) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.sizeUp = sizeUp;
        }
    }

    public static boolean bfs() {
        int[][] moveArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(moveArr[i], Integer.MAX_VALUE);
        }

        Queue<Move> que = new LinkedList<>();
        que.offer(new Move(shark.y, shark.x, 0));
        moveArr[shark.y][shark.x] = 0;
        Move feed = new Move(-1, -1, Integer.MAX_VALUE);

        while (!que.isEmpty()) {
            Move move = que.poll();
            if (move.t >= feed.t) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = move.y + dy[i];
                int nx = move.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || arr[ny][nx] > shark.size || moveArr[ny][nx] <= move.t + 1) {
                    continue;
                }

                if (arr[ny][nx] == shark.size) {
                    moveArr[ny][nx] = move.t + 1;
                    que.offer(new Move(ny, nx, moveArr[ny][nx]));
                } else if (arr[ny][nx] != 0){
                    if (feed.t > move.t + 1) {
                        feed.y = ny;
                        feed.x = nx;
                        feed.t = move.t + 1;
                    } else {
                        if (feed.y > ny) {
                            feed.y = ny;
                            feed.x = nx;
                        } else if (feed.y == ny && feed.x > nx) {
                            feed.x = nx;
                        }
                    }
                } else {
                    moveArr[ny][nx] = move.t + 1;
                    que.offer(new Move(ny, nx, moveArr[ny][nx]));
                }
            }
        }

        if (feed.y == -1 && feed.x == -1) {
            return false;
        }

        arr[feed.y][feed.x] = 0;
        shark.y = feed.y;
        shark.x = feed.x;
        result += feed.t;
        if (--shark.sizeUp == 0) {
            shark.size++;
            shark.sizeUp = shark.size;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        dy = new int[]{1,0,-1,0};
        dx = new int[]{0,1,0,-1};

        arr = new int[N][N];

        shark = new Shark(-1, -1, -1, -1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Shark(i, j, 2, 2);
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            if (!bfs()) {
                System.out.println(result);
                return;
            }
        }


    }
}