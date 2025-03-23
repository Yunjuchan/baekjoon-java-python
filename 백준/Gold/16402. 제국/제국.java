import java.io.*;
import java.util.*;

public class Main {

    static Map<String, String> kingdoms;

    public static String find(String x) {
        if (kingdoms.get(x).equals(x)) {
            return x;
        }
        kingdoms.replace(x, find(kingdoms.get(x)));
        return kingdoms.get(x);
    }

    public static void union(String a, String b, String win) {
        String fa = find(a);
        String fb = find(b);
//        System.out.println("a: " + a + " fa: " + fa + " b: " + b + " fb: " + fb);

        if (win.equals("1")) {
            if (fa.equals(fb)) {
                kingdoms.replace(a, a);
                kingdoms.replace(fb, a);
            } else {
                kingdoms.replace(fb, fa);
            }
        } else {
            if (fa.equals(fb)) {
                kingdoms.replace(b, b);
                kingdoms.replace(fa, b);
            } else {
                kingdoms.replace(fa, fb);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        kingdoms = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String kingdom = br.readLine();
            kingdoms.put(kingdom, kingdom);
        }

        for (int j = 0; j < M; j++) {
            String[] war = br.readLine().split(",");
            union(war[0], war[1], war[2]);

//            System.out.println("war: " + war[0] + " " + war[1] + " " + war[2]);
//            for (String key : kingdoms.keySet()) {
//                System.out.println(key + " " + kingdoms.get(key));
//            }
        }

        List<String> originKingdoms  = new ArrayList<>();

        for (String key : kingdoms.keySet()) {
            if (kingdoms.get(key).equals(key)) {
                originKingdoms.add(key);
            }
        }

        originKingdoms.sort(String::compareTo);

        for (String originKingdom : originKingdoms) {
            sb.append(originKingdom).append("\n");
        }

        System.out.println(originKingdoms.size());
        System.out.println(sb);
    }
}
