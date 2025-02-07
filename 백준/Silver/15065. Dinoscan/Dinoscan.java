import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C1 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());
        int lastLeft = 0;
        int firstRight = 20;

        int[][] left = new int[R][C1];
        int[][] right = new int[R][C2];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C1; j++) {
                left[i][j] = line.charAt(j) - '0';
                if (left[i][j] == 1) {
                    lastLeft = Math.max(lastLeft, j);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C2; j++) {
                right[i][j] = line.charAt(j) - '0';
                if (right[i][j] == 1) {
                    firstRight = Math.min(firstRight, j);
                }
            }
        }

        C1 = lastLeft + 1;
        C2 -= firstRight;

        int[][] left2 = new int[R][C1];
        int[][] right2 = new int[R][C2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j <= lastLeft; j++) {
                left2[i][j] = left[i][j];
            }

            for (int j = firstRight; j < C2 + firstRight; j++) {
                right2[i][j - firstRight] = right[i][j];
            }
        }


        for (int size = Math.max(C1, C2) + 1; size <= C1 + C2; size++) {
            boolean isValid = true;
//            System.out.println("size가 " + size + "일 때");
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < size; j++) {
                    int value = 0;
                    if (j < C1) {
                        value += left2[i][j];
                    }

                    if (j >= size - C2) {
                        value += right2[i][j - size + C2];
                    }

                    if (value != 1) {
                        isValid = false;
                        break;
                    }
//                    System.out.print(value + " ");
                }
//                System.out.println();
                if (!isValid) {
                    break;
                }
            }

            if (isValid) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}