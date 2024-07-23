import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N+k];

        Map<Integer, Integer> M = new HashMap<>();
        M.put(c, 1);

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            sushi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<k; i++) {
            int now = sushi[i];
            sushi[N+i] = now;
            if (M.containsKey(now)) {
                M.replace(now, M.get(now)+1);
            } else {
                M.put(now, 1);
            }
        }
        int cnt = M.size();
        for (int i=0; i<N; i++) {
            M.replace(sushi[i], M.get(sushi[i])-1);
            if (M.get(sushi[i]) == 0) {
                M.remove(sushi[i]);
            }

            if (M.containsKey(sushi[i+k])) {
                M.replace(sushi[i+k], M.get(sushi[i+k])+1);
            } else {
                M.put(sushi[i+k], 1);
            }
            cnt = Math.max(cnt, M.size());
        }
        System.out.println(cnt);

    }
}