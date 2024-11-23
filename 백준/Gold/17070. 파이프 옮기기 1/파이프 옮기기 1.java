import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] directY = {1,1,0};
        int[] directX = {1,0,1};
        int[][] arr = new int[N][N];
        int[][][] dp = new int[N][N][3];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][2] = 1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1) {
                    continue;
                }
                for (int k=0; k<3; k++) {
                    for (int l=0; l<3; l++) {

                        if (l == 0) {
                            boolean flag = false;
                            for (int ii=0; ii<3; ii++) {
                                if (i+directY[ii] >= N || j+directX[ii] >= N || arr[i+directY[ii]][j+directX[ii]] == 1) {
                                    flag = true;
                                }
                            }
                            if (flag) {
                                continue;
                            }
                        }

                        if (i+directY[l] >= N || j+directX[l] >= N || arr[i+directY[l]][j+directX[l]] == 1) {
                            continue;
                        }

                        if (k != 0 && l !=0 && k != l) {
                            continue;
                        }

                        dp[i+directY[l]][j+directX[l]][l] += dp[i][j][k];
                    }
                }
            }
        }

        int result = 0;
        for (int i=0; i<3; i++) {
            result += dp[N-1][N-1][i];
        }

//        for (int i=0; i<3; i++) {
//            System.out.println("방향: " + i);
//            for (int j=0; j<N; j++) {
//                for (int k=0; k<N; k++) {
//                    System.out.print(dp[j][k][i] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        System.out.println(result);

    }
}