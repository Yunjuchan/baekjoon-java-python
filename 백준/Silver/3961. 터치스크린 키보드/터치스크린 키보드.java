import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
//    class Data implements Comparable<Data> {
//        int d;
//        String word;
//
//        @Override
//        public int compareTo(Data o) {
//            if (this.d != o.d) {
//                return Integer.compare(this.d, o.d);
//            } else {
//                return this.word.compareTo(o.word);
//            }
//        }
//    }

    static class Data {
        int d;
        String word;

        public Data(int d, String word) {
            this.d = d;
            this.word = word;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Map<Character, int[]> H = new HashMap<>();
        String[] A = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i=0; i<3; i++) {
            for (int j=0; j<A[i].length(); j++) {
                H.put(A[i].charAt(j), new int[]{i, j});
            }
        }
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            int N = Integer.parseInt(st.nextToken());
            List<Data> B = new ArrayList<>();

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                String word = st.nextToken();
                int y1, y2, x1, x2;
                int distance = 0;
                for (int j=0; j<target.length(); j++) {
                    y1 = H.get(target.charAt(j))[0];
                    x1 = H.get(target.charAt(j))[1];
                    y2 = H.get(word.charAt(j))[0];
                    x2 = H.get(word.charAt(j))[1];
//                    System.out.println(target.charAt(j) + " " + word.charAt(j) + " " + Math.abs(y1 - y2) + Math.abs(x1 - x2));
//                    System.out.println(y1 + " " + y2 + " " + x1 + " " + x2);
                    distance += Math.abs(y1 - y2) + Math.abs(x1 - x2);
                }
                B.add(new Data(distance, word));
            }
            B.sort(new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    if (o1.d != o2.d) {
                        return Integer.compare(o1.d, o2.d);
                    } else {
                        return o1.word.compareTo(o2.word);
                    }
                }
            });
            for (int i=0; i<N; i++) {
                System.out.println(B.get(i).word + " " +  B.get(i).d);
            }
        }
    }
}