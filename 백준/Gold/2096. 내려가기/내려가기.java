import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] min = new int[3];
        int[] max = new int[3];
        int[] arr = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<3; i++) {
            int x = Integer.parseInt(st.nextToken());
            max[i] = x;
            min[i] = x;
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int[] tmpMaxArr = new int[3];
            int[] tmpMinArr = new int[3];
            for (int j=0; j<3; j++) {
                int tmpMax = 0;
                int tmpMin = Integer.MAX_VALUE;
                for (int k=-1; k<2; k++) {
                    if (j+k < 0 || j+k >= 3) {
                        continue;
                    }
                    tmpMax = Math.max(tmpMax, max[j+k] + arr[j]);
                    tmpMin = Math.min(tmpMin, min[j+k] + arr[j]);
                }
                tmpMaxArr[j] = tmpMax;
                tmpMinArr[j] = tmpMin;
            }
            max = tmpMaxArr.clone();
            min = tmpMinArr.clone();
        }

        int x = 0;
        int y = Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            x = Math.max(x, max[i]);
            y = Math.min(y, min[i]);
        }
        System.out.println(x + " " + y);
    }
}