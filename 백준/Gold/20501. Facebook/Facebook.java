import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        BitSet[] friends = new BitSet[N + 1];

        for (int i = 1; i <= N; i++) {
            friends[i] = new BitSet(N + 1);
            String status = br.readLine();
            for (int j = 1; j <= N; j++) {
                if (status.charAt(j - 1) == '1') {
                    friends[i].set(j);
                }
            }
        }

        int Q = Integer.parseInt(br.readLine());

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            BitSet friendA = (BitSet) friends[A].clone();
            friendA.and(friends[B]);
            sb.append(friendA.cardinality()).append("\n");
        }
        
        System.out.println(sb);
    }
}