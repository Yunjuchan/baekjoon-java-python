import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dist = new int[N];
        int[] oil = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N-1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }
        
        int Min = oil[0];
        long result = (long) Min * dist[0];
        for (int i=1; i<N-1; i++) {
            Min = Math.min(Min, oil[i]);
            result += (long) Min * dist[i];
        }

        System.out.println(result);
    }
}