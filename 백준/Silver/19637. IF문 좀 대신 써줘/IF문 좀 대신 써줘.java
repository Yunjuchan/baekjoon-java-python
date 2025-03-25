import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static List<Title> titles;

    public static class Title {
        String name;
        int n;

        public Title (String name, int n) {
            this.name = name;
            this.n = n;
        }
    }

    public static String binarySearch(int x) {
        String title = titles.get(0).name;
        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            Title tmp = titles.get(mid);
            if (tmp.n >= x) {
                title = tmp.name;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return title;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        titles = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            titles.add(new Title(name, n));
        }

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(binarySearch(x)).append("\n");
        }

        System.out.println(sb);
    }
}
