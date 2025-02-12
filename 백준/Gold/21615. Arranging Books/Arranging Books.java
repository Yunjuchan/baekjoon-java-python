import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String books = br.readLine();
        int N = books.length();
        int[] LMS = new int[3];
        int[] original = new int[3];
        int cnt = 0;
        int[][] status = new int[3][3];

        for (int i = 0; i < N; i++) {
            if (books.charAt(i) == 'L') {
                LMS[0]++;
            } else if (books.charAt(i) == 'M') {
                LMS[1]++;
            } else {
                LMS[2]++;
            }
        }

        for (int i = 0; i < 2; i++) {
            original[i + 1] = original[i] + LMS[i];
        }


        for (int i = 0; i < N; i++) {
            if (books.charAt(i) == 'L') {
                if (i >= original[2]) {
                    status[0][2]++;
                } else if (i >= original[1]) {
                    status[0][1]++;
                } else {
                    status[0][0]++;
                }

            } else if (books.charAt(i) == 'M') {
                if (i < original[1]) {
                    status[1][0]++;
                } else if (i >= original[2]) {
                    status[1][2]++;
                } else {
                    status[1][1]++;
                }
            } else {
                if (i < original[1]) {
                    status[2][0]++;
                } else if (i < original[2]) {
                    status[2][1]++;
                } else {
                    status[2][2]++;
                }
            }
        }

//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(status[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                int min = Math.min(status[i][j], status[j][i]);
                status[i][j] -= min;
                status[j][i] -= min;
                cnt += min;
            }
        }
        
        int res = 0;
        for (int i = 0 ; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                res += status[i][j];
            }
        }

        res /= 3;
        cnt += res * 2;
        System.out.println(cnt);
    }
}