//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int T = Integer.parseInt(st.nextToken());
//        for (int t=0; t<T; t++) {
//            st = new StringTokenizer(br.readLine());
//            int A = Integer.parseInt(st.nextToken());
//            int B = Integer.parseInt(st.nextToken());
//            if (A == 0) {
//                if (B == 0) {
//                    System.out.println(0);
//                    return;
//                }
//                System.out.println((B+2) / 3 + 3 - (B % 3));
//                return;
//            }
//            if (B < 3 * A) {
//                System.out.println(3 * A - B);
//            } else if (B <= 4 * A) {
//                System.out.println(0);
//            } else {
//                System.out.println((B - 4 * A + 3) / 4);
//            }
//        }
//    }
//}


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            int minCnt = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            for (int i=A; i<=1000; i++) {
                if (B < 3 * i) {
                    minCnt = Math.min(minCnt, i - A + i * 3 - B);
                    break;
                } else if (B >= 3 * i && B <= 4 * i) {
                    minCnt = Math.min(minCnt, i - A);
                } else {
                    continue;
                }
            }
            System.out.println(minCnt);
        }
    }
}