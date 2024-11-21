import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (s.contains(x)) {
                continue;
            }
            s.add(x);
            arr.add(x);
        }
        arr.sort((a,b) -> (a-b));

        List<Integer> dist = new ArrayList<>();
        for (int i=1; i<arr.size(); i++) {
            dist.add(arr.get(i) -arr.get(i-1));
        }
        dist.sort((a,b) -> (b-a));

        if (arr.size() <= K) {
            System.out.println(0);
        } else {
            long result = 0;
            for (int i=K-1; i<dist.size(); i++) {
                result += dist.get(i);
            }
            System.out.println(result);
        }
    }
}