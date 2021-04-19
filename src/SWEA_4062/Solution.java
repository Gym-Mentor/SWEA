package SWEA_4062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int T,N,max=0;
	static int arr[][],DP[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			N=Integer.parseInt(br.readLine());
			arr=new int[N+1][N+1];
			DP=new int[N+1][N+1];
			max=0;
			for(int i=1;i<=N;i++)
			{
				String str=br.readLine();
				for(int j=1;j<=N;j++)
				{
					arr[i][j]=str.charAt(j-1)-'0';
				}
			}
			
			for(int i=1;i<=N;i++)
			{
				for(int j=1;j<=N;j++)
				{
					if(arr[i][j]==1)
					{
						DP[i][j]=0;
					}
					else
					{
						DP[i][j]=Math.min(DP[i-1][j]+1, DP[i][j-1]+1);
						DP[i][j]=Math.min(DP[i-1][j-1]+1, DP[i][j]);
					}
					max=Math.max(DP[i][j], max);
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

}
