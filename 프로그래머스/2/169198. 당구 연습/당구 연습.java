import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        
        int l = balls.length;
        int[] answer = new int[l];
        Arrays.fill(answer, Integer.MAX_VALUE);
        
        int[][][] cusions = new int[l][4][2];
        boolean[][] impossible = new boolean[l][4];
        
        for (int i = 0; i < l; i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            
            if ((startX < x && startY == y) || x == m) {
                impossible[i][0] = true;
            } else if ((startX > x && startY == y) || x == 0) {
                impossible[i][1] = true;
            } else if ((startX == x && startY < y) || y == n) {
                impossible[i][2] = true;
            } else if ((startX == x && startY > y) || y == 0) {
                impossible[i][3] = true;
            }
            
            cusions[i][0] = new int[] {2 * m - x, y};
            cusions[i][1] = new int[] {-x, y};
            cusions[i][2] = new int[] {x, 2 * n - y};
            cusions[i][3] = new int[] {x, -y};
        }
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < 4; j++) {
                if (impossible[i][j]) {
                    continue;
                }
                int diffX = startX - cusions[i][j][0];
                int diffY = startY - cusions[i][j][1];
                answer[i] = Math.min(answer[i], diffX * diffX + diffY * diffY);
            }
        }
        
        return answer;
    }
}