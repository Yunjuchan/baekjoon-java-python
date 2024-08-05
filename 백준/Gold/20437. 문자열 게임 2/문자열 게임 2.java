import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t=0; t<T; t++) {
            int Max = 0;
            int Min = Integer.MAX_VALUE;
            List<List<Integer>> A = new ArrayList<>();
            String line = br.readLine();
            for (int i=0; i<26; i++) {
                A.add(new ArrayList<>());
            }
            for (int i=0; i< line.length(); i++) {
                A.get(line.charAt(i)-97).add(i);
            }

            int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            boolean flag = false;
            for (int i=0; i<26; i++) {
                List<Integer> B = A.get(i);
                if (B.size() >= N) {
                    flag = true;
                    for (int j=0; j<=B.size()-N; j++) {
                        int length = B.get(j+N-1) - B.get(j) + 1;
                        Max = Math.max(Max, length);
                        Min = Math.min(Min,length);
                    }
                }
            }
            if (flag) {
                System.out.println(Min + " " + Max);
            } else {
                System.out.println(-1);
            }
        }
    }
}