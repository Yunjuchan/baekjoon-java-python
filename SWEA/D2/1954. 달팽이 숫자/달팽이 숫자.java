import java.util.*;
import java.io.*;

class Solution {
    static int N;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[][] arr;
        int[] dy = {0,1,0,-1};
        int[] dx = {1,0,-1,0};
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            arr[0][0] = 1;
            int num = 2;
            int y = 0;
            int x = 0;
            int d = 0;
            while (num <= N*N) {
                if (y+dy[d] >= N || y+dy[d] < 0 || x+dx[d] >= N || x+dx[d] < 0 || arr[y+dy[d]][x+dx[d]] != 0) {
                    d++;
                    d %= 4;
                }
                y += dy[d];
                x += dx[d];
                arr[y][x] = num;
                num++;
            }
            System.out.println("#" + tc);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}