import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] now = new int[N];

        int result = 0;
        int m = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            now[i] = Integer.parseInt(st.nextToken());
            m += now[i];
        }
        
        int planeNumber = m / N;
        int lessCount = 0;
        int moreCount = 0;


        for (int i = 0; i < N; i++) {
            if (now[i] > planeNumber + 1) {
                moreCount += now[i] - planeNumber - 1;
            }

            if (now[i] < planeNumber) {
                lessCount += planeNumber - now[i];
            }
        }
        System.out.println(Math.max(lessCount, moreCount));
    }
}
