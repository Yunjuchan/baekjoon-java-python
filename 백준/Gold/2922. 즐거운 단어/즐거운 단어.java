import java.io.*;

import java.util.StringTokenizer;

public class Main {

    public static class Case {

        int cV;
        int cC;
        int nV;
        int nC;

        public Case(int cV, int cC, int nV, int nC) {
            this.cV = cV;
            this.cC = cC;
            this.nV = nV;
            this.nC = nC;
        }
    }

    public static long result = 0;

    public static boolean isVowel (char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static void dfs(int level, String word, Case c, boolean flag) {

        if (c.cV >= 3 || c.cC >= 3) {
            return;
        }

//        System.out.println(level + " " + c.cV + " " + c.cC + " " + c.nV + " " + c.nC);

        if (level == word.length()) {
            long countV = (long) Math.pow (5, c.nV);
            long countC;

            if (flag) {
                countC = (long) Math.pow(21, c.nC);
            } else {
                if (c.nC == 0) {
                    return;
                }
                countC = (long) Math.pow(21, c.nC) - (long) Math.pow(20, c.nC);
            }

//            System.out.println(c.cV + " " + c.cC + " " + c.nV + " " + c.nC);

            result += countV * countC;
            return;
        }

        char now = word.charAt(level);
        if (now == '_') {
            if (c.cV != 0) {
                Case c1 = new Case(c.cV+1, 0, c.nV+1, c.nC);
                dfs(level+1, word, c1, flag);
                Case c2 = new Case(0, 1, c.nV, c.nC+1);
                dfs(level+1, word, c2, flag);
            } else {
                Case c1 = new Case(1, 0, c.nV+1, c.nC);
                dfs(level+1, word, c1, flag);
                Case c2 = new Case(0, c.cC+1, c.nV, c.nC+1);
                dfs(level+1, word, c2, flag);
            }
        } else if (isVowel(now)){
            Case c1 = new Case(c.cV+1, 0, c.nV, c.nC);
            dfs(level+1, word, c1, flag);
        } else {
            if (now == 'L') {
                flag = true;
            }
            Case c1 = new Case(0, c.cC+1, c.nV, c.nC);
            dfs(level+1, word, c1, flag);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();
        Case c = new Case(0, 0, 0, 0);
        dfs(0, word, c, false);
        System.out.println(result);
    }
}