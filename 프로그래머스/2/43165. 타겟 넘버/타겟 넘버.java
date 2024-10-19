class Solution {
    
    static int result = 0;
    
    public static void dfs(int level, int now, int target, int[] numbers, int[] Sum) {
        if (level == numbers.length) {
            if (target == now) {
                result++;
            }
            return;
        }
        
        int x = Sum[numbers.length] - Sum[level];
        
        if (now + x >= target) {
            dfs(level+1, now + numbers[level], target, numbers, Sum);
        }
            
        if (now - x <= target) {
            dfs(level+1, now - numbers[level], target, numbers, Sum);
        }    
    }
    
    public int solution(int[] numbers, int target) {
        int[] Sum = new int[numbers.length+1];
        for (int i=1; i<=numbers.length; i++) {
            Sum[i] = Sum[i-1] + numbers[i-1];
        }
        
        dfs(0, 0, target, numbers, Sum);
        
        return result;
    }
}