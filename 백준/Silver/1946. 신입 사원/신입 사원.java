import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int interviewLow = arr[0][1];
            int interviewCnt = 1;
            for (int i = 1; i < N; i++) {
                if (interviewLow > arr[i][1]) {
                    interviewLow = arr[i][1];
                    interviewCnt++;
                }
            }

//            Arrays.sort(arr, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o1[1] - o2[1];
//                }
//            });
//
//            int writtenLow = arr[0][0];
//            int writtenCnt = 1;
//            for (int i = 1; i < N; i++) {
//                if (writtenLow > arr[i][0]) {
//                    writtenLow = arr[i][0];
//                    writtenCnt++;
//                }
//            }

            System.out.println(interviewCnt);
        }
    }
}