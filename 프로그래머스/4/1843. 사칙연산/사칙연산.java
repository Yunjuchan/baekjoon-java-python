import java.util.*;

class Solution {
    public int solution(String[] arr) {
        int n = (arr.length + 1) / 2;
        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i * 2]);
        }
        
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    String op = arr[2 * k + 1];

                    int a = dpMax[i][k];
                    int b = dpMin[i][k];
                    int c = dpMax[k + 1][j];
                    int d = dpMin[k + 1][j];

                    if (op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], a + c);
                        dpMin[i][j] = Math.min(dpMin[i][j], b + d);
                    } else if (op.equals("-")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], a - d);
                        dpMin[i][j] = Math.min(dpMin[i][j], b - c);
                    }
                }
            }
        }

        return dpMax[0][n - 1];
    }
}
