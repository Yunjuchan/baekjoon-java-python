import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] dy, dx;
    static int[][] arr, space, sharkNum;

    public static class Shark {
        int d;
        int y;
        int x;

        public Shark(int d, int y, int x) {
            this.d = d;
            this.y = y;
            this.x = x;
        }
    }

    public static boolean isDead(Shark shark) {
        if (shark.y == -1 && shark.x == -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int killCnt = 0;

        dy = new int[]{-1,1,0,0};
        dx = new int[]{0,0,-1,1};

        arr = new int[N][N];
        space = new int[N][N];
        sharkNum = new int[N][N];
        List<Shark> sharks = new ArrayList<>();
        List<int[][]> sharksMove = new ArrayList<>();

        sharks.add(new Shark(-1, -1, -1));

        for (int i = 0; i <= M; i++) {
            sharksMove.add(new int[4][4]);
            sharks.add(new Shark( -1, -1, -1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(space[i], -K);
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    Shark shark = sharks.get(arr[i][j]);
                    shark.y = i;
                    shark.x = j;
                    space[i][j] = 0;
                    sharkNum[i][j] = arr[i][j];
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sharks.get(i).d = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    sharksMove.get(i)[j][k] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        int t = 0;
        while (t < 1000) {
            t++;

            int[][] next = new int[M + 1][3];

            // 상어 다음 위치 계산
            for (int i = 1; i <= M; i++) {
                Shark shark = sharks.get(i);
                if (isDead(shark)) {
                    continue;
                }
                boolean isSpare = false;
                for (int d : sharksMove.get(i)[sharks.get(i).d]) {
                    int ny = shark.y + dy[d];
                    int nx = shark.x + dx[d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                        continue;
                    } else if ((t - space[ny][nx] <= K) && sharkNum[ny][nx] != i) {
                        continue;
                    }

                    if (t - space[ny][nx] > K) {
                        next[i] = new int[]{ny, nx, d};
                        break;
                    } else if ((t - space[ny][nx] <= K) && sharkNum[ny][nx] == i) {
                        if (isSpare) {
                            continue;
                        }
                        next[i] = new int[]{ny, nx, d};
                        isSpare = true;
                    }
                }
            }

            // 상어 쫓아내기
            for (int i = 1; i <= M; i++) {
                Shark shark = sharks.get(i);
                if (isDead(shark)) {
                    continue;
                }
                int y = next[i][0];
                int x = next[i][1];
                int d = next[i][2];
                if (space[y][x] == t) {
                    shark.y = -1;
                    shark.x = -1;
                    killCnt++;
                } else {
                    shark.y = y;
                    shark.x = x;
                    shark.d = d;
                    sharkNum[y][x] = i;
                    space[y][x] = t;
                }
            }

            if (killCnt == M - 1) {
                System.out.println(t);
                return;
            }
        }
        System.out.println(-1);
    }
}