import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            int[] A = new int[12];
            for (int i=0; i<12; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            for (int i=1; i<11; i++) {
                int Min = A[i];
                int prev = A[i-1];
//                System.out.println("i, Min, i-1, prev: " + i + " " + Min + " " + prev);
                if (Min <= prev) {
                    continue;
                }
                for (int j=i+1; j<12; j++) {
                    if (A[j] <= prev) {
//                        System.out.println("break point: " + i + " " + j);
                        result++;
                        break;
                    } else if (A[j] < Min) {
                        Min = A[j];
//                        System.out.println("plus point: " + i + " " + j);
                        result++;
                    }
                }
            }
            System.out.println(tc + " " + result);
        }
    }
}