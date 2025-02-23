import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = "";
                String s2 = "";

                for (int i = 0; i < o1.length(); i++) {
                    char c = o1.charAt(i);
                    if (c >= 'A' && c <= 'Z') {
                        s1 = o1.substring(i);
                        break;
                    }
                }

                for (int i = 0; i < o2.length(); i++) {
                    char c = o2.charAt(i);
                    if (c >= 'A' && c <= 'Z') {
                        s2 = o2.substring(i);
                        break;
                    }
                }

                return s1.compareTo(s2);
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(names[i] + "\n");
        }

        System.out.println(sb);
    }
}