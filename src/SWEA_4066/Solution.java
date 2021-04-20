package SWEA_4066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,M;
	static long arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			arr=new long[N+1][N+1];
			for(long[] rows: arr)
			{
				Arrays.fill(rows, 1000000);
			}
			for(int i=1;i<=N;i++)
			{
				arr[i][i]=0;
			}
			for(int i=0;i<M;i++)
			{
				st= new StringTokenizer(br.readLine());
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				long weight=Integer.parseInt(st.nextToken());
				
				arr[from][to]=Math.min(arr[from][to], weight);
			}
			
			for(int k=1;k<=N;k++)
			{
				for(int i=1;i<=N;i++)
				{
					if(i==k)continue;
					for(int j=1;j<=N;j++)
					{
						if(k==j||j==i)continue;
						arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=1;i<=N;i++)
			{
				for(int j=1;j<=N;j++)
				{
					if(arr[i][j]<1000000)
						System.out.print(arr[i][j]+" ");
					else
						System.out.print("-1 ");
						
				}
			}
			System.out.println();
		}
		
	}

}
