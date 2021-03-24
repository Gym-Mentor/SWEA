package SWEA_1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,arr[][];
	static boolean visited[];
	static long cost[];
	static double E;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			N=Integer.parseInt(br.readLine());
			arr=new int[N][2];
			visited=new boolean[N];
			cost=new long[N];
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				arr[i][1]=Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				arr[i][0]=Integer.parseInt(st.nextToken());
			}
			E=Double.parseDouble(br.readLine());
			Arrays.fill(cost, Long.MAX_VALUE);
			long result=0;
			cost[0]=0;
			for(int i=0;i<N;i++)
			{
				long dist=Long.MAX_VALUE;
				int idx=0;
				
				
				for(int j=0;j<N;j++)
				{
					if(!visited[j]&&dist>cost[j])
					{
						dist=cost[j];
						idx=j;
					}
				}
				result+=dist;
				visited[idx]=true;
				for(int j=0;j<N;j++)
				{
					if(!visited[j]&&distance(idx,j)!=0&&cost[j]>distance(idx,j))
					{
						cost[j]=distance(idx,j);
					}
				}
			}
			System.out.println("#"+tc+" "+Math.round(result*E));
		}
	}
	static long distance(int i,int j)
	{
		return (long)(Math.pow( Math.abs(arr[i][0]-arr[j][0]),2)+Math.pow( Math.abs(arr[i][1]-arr[j][1]),2));
	}
}
