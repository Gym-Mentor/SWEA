package SWEA_3282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T;
	static int N,K;
	static int DP[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			DP=new int[N+1][K+1];
			for(int i=1;i<=N;i++)
			{
				st=new StringTokenizer(br.readLine()," ");
				int V=Integer.parseInt(st.nextToken());
				int C=Integer.parseInt(st.nextToken());
				for(int j=1;j<=K;j++)
				{
					DP[i][j]=Math.max(DP[i][j-1], DP[i-1][j]);
					if(j>=V)
					DP[i][j]=Math.max(DP[i][j], DP[i-1][j-V]+C);
				}
			}
			
			System.out.println("#"+tc+" "+DP[N][K]);
		}
	}

}
