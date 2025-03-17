import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    static int[] dy, dx;
    static int[][][] arr;
    static int[][] fishes;
    static Shark shark;

    public static class Shark {
        int y;
        int x;
        int d;

        public Shark(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    public static void dfs(int sum) {
        result = Math.max(result, sum);

        int iy = shark.y;
        int ix = shark.x;
        int id = shark.d;

        int y = iy;
        int x = ix;

        move();

        while (true) {
            int[][] prevFishes = new int[17][3];
            for (int i = 0; i <= 16; i++) {
                prevFishes[i] = fishes[i].clone();
            }

            int[][][] prevArr = new int[4][4][2];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    prevArr[i][j] = arr[i][j].clone();
                }
            }

            y += dy[id];
            x += dx[id];

            if (y < 0 || x < 0 || y >= 4 || x >= 4) {
                return;
            }

            if (arr[y][x][0] == -1) {
                continue;
            }

            int k  = arr[y][x][0];

            fishes[k] = new int[]{-1, -1, -1};

            shark.y = y;
            shark.x = x;
            shark.d = arr[y][x][1];

            int[] prev = arr[y][x].clone();
            arr[iy][ix] = new int[]{-1, -1};
            arr[y][x] = new int[]{0, 0};

            dfs(sum + prev[0]);

            for (int i = 0; i <= 16; i++) {
                fishes[i] = prevFishes[i].clone();
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = prevArr[i][j].clone();
                }
            }

            shark.y = iy;
            shark.x = ix;
            shark.d = id;
        }
    }

    public static void move() {
        for (int i = 1; i <= 16; i++) {
            int[] fish = fishes[i].clone();
            int y = fish[0];
            int x = fish[1];

            if (y == -1 && x == -1) {
                continue;
            }

            int id = fish[2];

            while (true) {
                int ny = y + dy[fish[2]];
                int nx = x + dx[fish[2]];
                if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4 || arr[ny][nx][0] == 0) {
                    fish[2] = (fish[2] + 1) % 8;
                    if (fish[2] == id) {
                        break;
                    }
                    continue;
                }
                fishes[i][2] = fish[2];

                int cf = arr[ny][nx][0];

                if (cf != -1) {
                    int tempY = fishes[i][0], tempX = fishes[i][1];
                    fishes[i][0] = fishes[cf][0];
                    fishes[i][1] = fishes[cf][1];
                    fishes[cf][0] = tempY;
                    fishes[cf][1] = tempX;


                    int[] fishA = fishes[i].clone();
                    int[] fishB = fishes[cf].clone();

                    arr[fishA[0]][fishA[1]] = new int[]{i, fishA[2]};
                    arr[fishB[0]][fishB[1]] = new int[]{cf, fishB[2]};

                } else {
                    fishes[i] = new int[]{ny, nx, fish[2]};
                    arr[fish[0]][fish[1]] = new int[]{-1, -1};
                    arr[ny][nx] = new int[]{i, fishes[i][2]};
                }
                break;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dy = new int[]{-1,-1,0,1,1,1,0,-1};
        dx = new int[]{0,-1,-1,-1,0,1,1,1};
        fishes = new int[17][3];

        arr = new int[4][4][2];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j][0] = Integer.parseInt(st.nextToken());
                arr[i][j][1] = Integer.parseInt(st.nextToken()) - 1;
                fishes[arr[i][j][0]] = new int[]{i, j, arr[i][j][1]};
            }
        }
        int n = arr[0][0][0];
        shark = new Shark(0, 0, fishes[n][2]);
        fishes[n] = new int[]{-1, -1};
        fishes[n][1] = -1;
        arr[0][0] = new int[]{0, 0};
        
        dfs(n);

        System.out.println(result);
    }
}