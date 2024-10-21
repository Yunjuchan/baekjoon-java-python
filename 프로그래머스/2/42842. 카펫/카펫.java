class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = {};
        int total = brown + yellow;
        
        for (int i=2000000; i>0; i--) {
            if (yellow % i == 0) {
                int r = i;
                int c = yellow / i;
                if ((r+2) * (c+2) == total) {
                    answer = new int[] {r+2, c+2};
                    break;
                } 
            }
        }
        
        return answer;
    }
}