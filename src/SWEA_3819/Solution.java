package SWEA_3819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static int T,N,max;
	static int[] arr,DP;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc= new Scanner(System.in);
		T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++)
		{
			N=sc.nextInt();
			arr=new int[N];
			DP=new int[N];
			for(int i=0;i<N;i++)
			{
				arr[i]=sc.nextInt();
			}
			DP[0]=arr[0];
			max=DP[0];
			for(int i=1;i<N;i++)
			{
				if(DP[i-1]>=0)
				{
					DP[i]=DP[i-1]+arr[i];
					if(DP[i]>max)
						max=DP[i];
				}
				else
				{
					DP[i]=arr[i];
					if(DP[i]>max)
						max=DP[i];
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

}
