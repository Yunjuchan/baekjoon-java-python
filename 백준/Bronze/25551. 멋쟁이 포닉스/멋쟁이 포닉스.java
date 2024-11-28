import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[3][2];
        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int a = Math.min(arr[0][0], arr[1][1]);
        a = Math.min(arr[2][0], a);
        int b = Math.min(arr[0][1], arr[1][0]);
        b = Math.min(arr[2][1], b);

        if (a == b) {
            System.out.println(a * 2);
        } else {
            System.out.println(Math.min(a, b) * 2 + 1);
        }
    }
}