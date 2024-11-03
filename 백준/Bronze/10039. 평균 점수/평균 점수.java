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
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            sum += Math.max(x, 40);
        }
        System.out.println(sum / 5);
    }
}