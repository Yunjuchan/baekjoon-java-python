import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int N = word.length();
            int l = 0, r = N-1;
            int cnt = 0;
            while (l < r) {
                if (word.charAt(l) == word.charAt(r)) {
                    l++; r--;
                } else {
                    cnt++;
                    int tmpl = l+1;
                    int tmpr = r;
                    boolean flagl = true;
                    while (tmpl < tmpr) {
                        if (word.charAt(tmpl) == word.charAt(tmpr)) {
                            tmpl++; tmpr--;
                        } else {
                            flagl = false;
                            break;
                        }
                    }

                    tmpl = l;
                    tmpr = r-1;
                    boolean flagr = true;
                    while (tmpl < tmpr) {
                        if (word.charAt(tmpl) == word.charAt(tmpr)) {
                            tmpl++; tmpr--;
                        } else {
                            flagr = false;
                            break;
                        }
                    }

                    if (!(flagl || flagr)) {
                        cnt++;
                        break;
                    }

                    break;
                }
            }

            System.out.println(cnt);
        }
    }
}