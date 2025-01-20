import java.io.*;
import java.util.*;

public class Main {
    static int result = Integer.MAX_VALUE;


    public static int[][] fill(int[][] arr, int y, int x, int n, int num) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[y+i][x+j] = num;
            }
        }
        return arr;
    }

    public static void dfs(int c, int cnt, int res, int[] papers, int[][] arr) {
        if (c == 100 || cnt >= result) {
            return;
        }
        if (res == 0) {
            result = cnt;
            return;
        }

        for (int k=c; k<100; k++) {
            int i = k / 10;
            int j = k % 10;
            if (arr[i][j] == 0) {
                continue;
            }


            for (int n=5; n>0; n--) {
                if (i+n > 10 || j+n > 10 || papers[n] == 0) {
                    continue;
                }

                boolean isPossible = true;

                for (int y=0; y<n; y++) {
                    for (int x=0; x<n; x++) {
                        if (arr[i+y][j+x] == 0) {
                            isPossible = false;
                            break;
                        }
                    }
                    if (!isPossible) {
                        break;
                    }
                }

                if (isPossible) {
                    arr = fill(arr, i, j, n, 0);
                    papers[n]--;
                    res -= n*n;
                    if (res == 0) {
                        result = Math.min(result, cnt+1);
                    }
                    dfs(i*10+j+1, cnt+1, res, papers, arr);
                    res += n*n;
                    papers[n]++;
                    arr = fill(arr, i, j, n, 1);
                }
            }
            // 여기 return을 하고 말고의 차이가 무엇인지
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[10][10];
        int[] papers = new int[6];
        int res = 0;
        for (int i=1; i<=5; i++) {
            papers[i] = 5;
        }

        for (int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                res += arr[i][j];
            }
        }

        dfs(0, 0, res, papers, arr);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}