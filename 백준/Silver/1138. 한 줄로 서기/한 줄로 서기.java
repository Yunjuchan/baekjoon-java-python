import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] order = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            int o = Integer.parseInt(st.nextToken());
            order[i] = o;
        }
        int[] result = new int[N+1];
        for (int i=N; i>0; i--) {
            for (int j=N-1; j>=order[i]; j--) {
                result[j+1] = result[j];
            }
            result[order[i]] = i;
        }
        for (int i=0; i<N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}