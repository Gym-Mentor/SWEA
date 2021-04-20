package SWEA_5604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static long T,A,B,mul;
	static long arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			arr=new long[10];
			long sum=0;
			mul=1;
			StringTokenizer st= new StringTokenizer(br.readLine());
			A=Long.parseLong(st.nextToken());
			B=Long.parseLong(st.nextToken());
			while(A<=B)
			{
				while(B%10!=9&&A<=B)
				{
					calc(B);
					B--;
				}
				if(B<A)
				{
					break;
				}
				while(A%10!=0&&A<=B)
				{
					calc(A);
					A++;
				}
				A/=10;
				B/=10;
				for(int i=0;i<10;i++)
				{
					arr[i]+=(B-A+1)*mul;
				}
				mul*=10;
			}
			for(int i=0;i<10;i++)
			{
				sum+=(arr[i]*i);
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
	static void calc(long num)
	{
		
		while(num>0)
		{
			String str=String.valueOf(num);
			int idx=str.charAt(str.length()-1)-'0';
			arr[idx]+=mul;
			num/=10;
		}
	}

}
