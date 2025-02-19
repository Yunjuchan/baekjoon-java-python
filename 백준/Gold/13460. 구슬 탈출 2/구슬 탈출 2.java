import java.io.*;
import java.util.*;

public class Main {
    public static class Status {
        int cnt;
        int[][] position = new int[2][2];

        public Status(int cnt, int[][] position) {
            this.cnt = cnt;
            for (int i = 0; i < 2; i ++) {
                this.position[i] = position[i].clone();
            }
        }
    }

    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        int[][] position = new int[2][2];
        boolean[][][][] visited = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);

                if (arr[i][j] == 'R') {
                    position[0][0] = i;
                    position[0][1] = j;
                    arr[i][j] = '.';
                } else if (arr[i][j] == 'B') {
                    position[1][0] = i;
                    position[1][1] = j;
                    arr[i][j] = '.';
                }
            }
        }

//        System.out.println("빨간 공: " + position[0][0] + " " + position[0][1]);
//        System.out.println("파란 공: " + position[1][0] + " " + position[1][1]);

        Queue<Status> que = new LinkedList<>();
        que.offer(new Status(0, position));
        visited[position[0][0]][position[0][1]][position[1][0]][position[1][1]] = true;
        while (!que.isEmpty()) {
            Status status = que.poll();

            if (status.cnt == 10) {
                System.out.println(-1);
                return;
            }

//            System.out.println("현재까지 이동 횟수: " + status.cnt);
//            System.out.println("빨간 공: " + status.position[0][0] + " " + status.position[0][1]);
//            System.out.println("파란 공: " + status.position[1][0] + " " + status.position[1][1]);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int[] ball = status.position[i];
                    if (i == 0) {
                        arr[ball[0]][ball[1]] = 'R';
                    } else {
                        arr[ball[0]][ball[1]] = 'B';
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int[][] nextPostion = new int[2][2];
                int[][] goal = new int[2][2];

                for (int j = 0; j < 2; j++) {
                    int[] ball = status.position[j];
                    if (j == 0) {
                        arr[ball[0]][ball[1]] = 'R';
                    } else {
                        arr[ball[0]][ball[1]] = 'B';
                    }
                }

                for (int j = 0; j < 3; j++) { // 파란색이 먼저 이동해야하는 경우 고려 빨강을 한 번 더 이동

                    if (j == 2 && goal[j % 2][0] == 1) {
                        break;
                    }
                    int y = status.position[j % 2][0];
                    int x = status.position[j % 2][1];

                    if (j == 2) {
                        arr[nextPostion[0][0]][nextPostion[0][1]] = '.';
                        y = nextPostion[0][0];
                        x = nextPostion[0][1];
                    } else {
                        arr[y][x] = '.';
                    }

                    while (true) {
                        if (y + dy[i] < 0 || x + dx[i] < 0 || y + dy[i] >= N || x + dx[i] >= M || arr[y + dy[i]][x + dx[i]] != '.') {
                            break;
                        }
                        y += dy[i];
                        x += dx[i];
                    }

                    if (y + dy[i] < 0 || x + dx[i] < 0 || y + dy[i] >= N || x + dx[i] >= M || arr[y + dy[i]][x + dx[i]] == 'O') {
                        y += dy[i];
                        x += dx[i];
                        goal[j % 2][0] = 1;
                        goal[j % 2][1] = Math.abs(status.position[j % 2][0] - y) + Math.abs(status.position[j % 2][1] - x);
                    }

                    if (j % 2 == 0) {
                        if (goal[j % 2][0] == 0) {
                            arr[y][x] = 'R';
                        } else {
                            arr[y][x] = 'O';
                        }
                        nextPostion[0][0] = y;
                        nextPostion[0][1] = x;
                    } else {
                        if (goal[j % 2][0] == 0) {
                            arr[y][x] = 'B';
                        } else {
                            arr[y][x] = 'O';
                        }
                        nextPostion[1][0] = y;
                        nextPostion[1][1] = x;
                    }
                }
//                System.out.println(i + "방향으로 이동한 뒤");
//                System.out.println("이동한 뒤 빨간 공: " + nextPostion[0][0] + " " + nextPostion[0][1]);
//                System.out.println("이동한 뒤 파란 공: " + nextPostion[1][0] + " " + nextPostion[1][1]);

                if ((goal[0][0] == 1 && goal[1][0] == 0)) {
                    System.out.println(status.cnt + 1);
                    return;
                } else if (goal[0][0] == 0 && goal[1][0] == 1 || goal[0][0] == 1 && goal[1][0] == 1) {
                    arr[nextPostion[0][0]][nextPostion[0][1]] = '.';
                    arr[nextPostion[1][0]][nextPostion[1][1]] = 'O';
                    continue;
                }

                arr[nextPostion[0][0]][nextPostion[0][1]] = '.';
                arr[nextPostion[1][0]][nextPostion[1][1]] = '.';
                if (visited[nextPostion[0][0]][nextPostion[0][1]][nextPostion[1][0]][nextPostion[1][1]]) {
                    continue;
                }

                visited[nextPostion[0][0]][nextPostion[0][1]][nextPostion[1][0]][nextPostion[1][1]] = true;
                que.offer(new Status(status.cnt + 1, nextPostion));
            }
        }
        System.out.println(-1);
    }
}