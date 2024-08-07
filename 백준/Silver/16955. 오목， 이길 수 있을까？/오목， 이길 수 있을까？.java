import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] A = new char[10][10];
        for (int i=0; i<10; i++) {
            String s = br.readLine();
            for (int j=0; j<10; j++) {
                A[i][j] = s.charAt(j);
            }
        }

        int flag = 0;
        for (int i=0; i<10; i++) {
            for (int j=0; j<6; j++) {
                int[] B = new int[4];
                for (int k=0; k<5; k++) {
                    if (A[i][j+k] == 'X') {
                        B[0]++;
                    } else if (A[i][j+k] == 'O') {
                        B[1]++;
                    }

                    if (A[j+k][i] == 'X') {
                        B[2]++;
                    } else if (A[j+k][i] == 'O') {
                        B[3]++;
                    }
                }
//                System.out.println(B[0] + " " + B[1] + " " + B[2] + " " + B[3] + " ");
                if (B[0] - B[1] == 4 || B[2] - B[3] == 4) {
                    flag = 1;
                }
            }
        }

        for (int i=0; i<6; i++) {
            for (int j = 0; j < 6; j++) {
                int[] B = new int[4];
                for (int k = 0; k < 5; k++) {
                    if (A[i+k][j+k] == 'X') {
                        B[0]++;
                    } else if (A[i+k][j+k] == 'O') {
                        B[1]++;
                    }

                    if (A[i+k][j+4-k] == 'X') {
                        B[2]++;
                    } else if (A[i+k][j+4-k] == 'O') {
                        B[3]++;
                    }
                }

                if (B[0] - B[1] == 4 || B[2] - B[3] == 4) {
                    flag = 1;
                }
            }
        }


        System.out.println(flag);
    }
}