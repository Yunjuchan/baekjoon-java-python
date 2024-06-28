import java.io.*;
import java.util.*;

public class Main {

    private static char[][] A;
    private static boolean[][][] visited;
    private static int R, C;

    public static String bfs(int startY, int startX) {
        int[] directY = {1, 0, -1, 0};
        int[] directX = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        
        visited[0][startY][startX] = true;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == '*') {
                    visited[1][i][j] = true;
                    q.offer(new int[]{0, i, j, 1});
                }
            }
        }
        q.offer(new int[]{0, startY, startX, 0});
        

        while (!q.isEmpty()) {
            int[] F = q.poll();
            int currentDist = F[0];
            int currentY = F[1];
            int currentX = F[2];
            int currentType = F[3];
            // System.out.println(currentDist + " " + currentY + " " + currentX + " " + currentType);
            for (int i = 0; i < 4; i++) {
                int dy = directY[i] + currentY;
                int dx = directX[i] + currentX;

                if (dy < 0 || dx < 0 || dy >= R || dx >= C || visited[currentType][dy][dx]) {
                    continue;
                }
                if (currentType == 0 && visited[1][dy][dx]) {
                    continue;
                }

                if (A[dy][dx] == 'D' && currentType == 1) {
                    continue;
                } else if (A[dy][dx] == 'D' && currentType == 0) {
                    return Integer.toString(currentDist + 1);
                }

                visited[currentType][dy][dx] = true;
                q.offer(new int[]{currentDist + 1, dy, dx, currentType});
            }
        }

        return "KAKTUS";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new char[R][C];
        visited = new boolean[2][R][C];

        int startY = -1;
        int startX = -1;
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                A[i][j] = str.charAt(j);
                if (A[i][j] == 'S') {
                    startY = i;
                    startX = j;
                } else if (A[i][j] == 'X') {
                    visited[0][i][j] = true;
                    visited[1][i][j] = true;
                }
            }
        }
        String result = bfs(startY, startX);
        System.out.println(result);
        // for (boolean[][] A : visited) {
        //     for (boolean[] B : A) {
        //         for (boolean C : B) {
        //             System.out.print(C);
        //         }
        //         System.out.println();
        //     }
        // }
    }
}