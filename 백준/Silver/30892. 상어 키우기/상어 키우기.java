import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());
        Stack<Integer> small = new Stack<>();
        Deque<Integer> large = new ArrayDeque<>();
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        for (int i=0; i<N; i++) {
            if (A[i] < T) {
                small.push(A[i]);
            } else {
                large.push(A[i]);
            }
        }
        for (int i=0; i<K; i++) {
            if (!small.isEmpty()) {
                T += small.pop();
                while (!large.isEmpty()) {
//                    System.out.println("first element: " + large.peekLast());
//                    System.out.println("T: " + T);
                    if (large.peekLast() < T) {
                        small.push(large.pollLast());
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        System.out.println(T);
    }
}