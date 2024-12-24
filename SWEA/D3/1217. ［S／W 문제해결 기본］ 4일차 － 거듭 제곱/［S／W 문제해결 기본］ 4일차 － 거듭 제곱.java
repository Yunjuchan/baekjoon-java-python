import java.util.Scanner;

class Solution {
    
    public static int pow(int a, int b) {
    	if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        }
        return pow(a, b/2) * pow(a, b/2+b%2);
    }
    
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
			int a = sc.nextInt();
            int b = sc.nextInt();
            int result = pow(a, b);
            System.out.println("#" + tc + " " + result);
		}
	}
}