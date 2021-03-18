package SWEA_7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T,N,M,result;
	static int parents[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			result=0;
			parents=new int[N+1];
			boolean cnt[]=new boolean[N+1];
			for(int i=1;i<=N;i++)
			{
				parents[i]=i;
			}
			
			for(int i=0;i<M;i++)
			{
				st= new StringTokenizer(br.readLine()," ");
				int num1=Integer.parseInt(st.nextToken());
				int num2;
				if(st.hasMoreTokens())
				num2=Integer.parseInt(st.nextToken());
				else
					num2=num1;
				if(union(num1,num2));
			}
			
			for(int i=1;i<=N;i++)
			{
				int A=findSet(i);
				if(!cnt[A])result++;
				cnt[A]=true;
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	static int findSet(int a)
	{
		if(parents[a]==a)return a;
		return parents[a]=findSet(parents[a]);
	}
	
	static boolean union(int a, int b)
	{
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		
		if(aRoot==bRoot)return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
}
