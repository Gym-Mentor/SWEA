package SWEA_4070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {

	static int T,N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			BigInteger num1=new BigInteger("1");
			BigInteger num2=new BigInteger("3");
			BigInteger num3=new BigInteger("5");
			N=Integer.parseInt(br.readLine());
			if(N==1)
			{
				System.out.println("#"+tc+" "+num1);
				continue;
			}
			else if(N==2)
			{
				System.out.println("#"+tc+" "+num2);
				continue;
			}
			for(int i=2;i<N;i++)
			{
				num3=num2.add(num1).add(num1);
				num1=num2;
				num2=num3;
			}
			
			System.out.println("#"+tc+" "+num3);
		}
		
	}

}
