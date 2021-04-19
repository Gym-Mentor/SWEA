package SWEA_5607;

import java.util.Scanner;

public class Solution {

	static final int MOD=1234567891;
	static int T,N,R;
	static long fact[]=new long[1000000+1];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		T=sc.nextInt();
		fact[0]=1;
		for(int i=1;i<=1000000;i++)
		{
			fact[i]=(fact[i-1]*i)%MOD;
		}
		
		for(int tc=1;tc<=T;tc++)
		{
			N=sc.nextInt();
			R=sc.nextInt();
			
			fact[0]=1;
			
			long top=fact[N]%MOD;
			long bottom=((fact[N-R]%MOD)*(fact[R]%MOD))%MOD;
			
			long bottomToTheTop=fermat(bottom,MOD-2);
			System.out.println("#"+tc+" "+(top*bottomToTheTop)%MOD);
		}
		
	}
	private static long fermat(long n, int x) {
        if (x == 0) return 1;
        long tmp = fermat(n, x / 2);
        long ret = (tmp * tmp) % MOD;
        if (x % 2 == 0) return ret;
        else return (ret * n) % MOD;
    }
}
