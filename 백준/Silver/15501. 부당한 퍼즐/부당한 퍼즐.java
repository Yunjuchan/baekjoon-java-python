import java.io.*;
import java.util.*;

public class Main {

    public static boolean check(int[] arr1, int[] arr2, int N, int k, int direct) {

        for (int i=0; i<N; i++) {
            int idx = (N + k + direct * i) % N;
            if (arr1[i] != arr2[idx]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arr2 = new int[N];
        int k = -1;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
            if (arr2[i] == arr[0]) {
                k = i;
            }
        }

        boolean flag = false;
        for (int i=-1; i<2; i+=2) {
            flag |= check(arr, arr2, N, k, i);
        }
        if (flag) {
            System.out.println("good puzzle");
        } else {
            System.out.println("bad puzzle");
        }
    }
}