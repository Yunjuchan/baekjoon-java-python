import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int n1 = 0;
                    int n2 = 0;

                    for (char c1 : o1.toCharArray()) {
                        int tmp = c1 - '0';
                        if (tmp < 10) {
                            n1 += tmp;
                        }
                    }

                    for (char c2 : o2.toCharArray()) {
                        int tmp = c2 - '0';
                        if (tmp < 10) {
                            n2 += tmp;
                        }
                    }
                    if (n1 == n2) {
                        return o1.compareTo(o2);
                    }
                    return n1 - n2;
                }
                return o1.length() - o2.length();
            }
        });
        for (String serialNum : arr) {
            System.out.println(serialNum);
        }
    }
}