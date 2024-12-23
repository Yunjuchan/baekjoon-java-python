import java.io.*;
import java.util.*;

public class Main {

    /*
    * 수열의 홀짝성 신기한 풀이
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                for (int j=0; j<i;j++) {
                    if (arr[j] > arr[i]) {
                        cnt++;
                    }
                }
            }
            if (cnt % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}