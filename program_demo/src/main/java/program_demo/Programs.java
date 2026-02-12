package program_demo;

public class Programs {
	public static void main(String[]args) {
		System.out.println(checkPrime(15));
	}
	public static boolean checkPalindrome(String s1) {
		String s2 = new StringBuilder(s1).reverse().toString();
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkPrime(int n) {
		if(n<=1)return false;
		if(n==2 || n==3) return true;
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkArmstrong(int n) {
		int temp = n;
		int sum = 0;
		int length = String.valueOf(n).length();
		while(temp!=0) {
			int dig = temp%10;
			sum+=Math.powExact(dig, length);
			temp= temp/10;
		}
		if(sum == n) {
			return true;
		}
		return false;
	}
}
