package SWEA_1247;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int N,T;
	static int min=Integer.MAX_VALUE;
	static pair arr[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		T=Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			min=Integer.MAX_VALUE;
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			arr=new pair[N+2];
			st= new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N+2;i++)
			{		
				int num1=Integer.parseInt(st.nextToken());
				int num2=Integer.parseInt(st.nextToken());
				arr[i]=new pair(num1,num2);

			}
			dfs(0,0,arr[0].first,arr[0].second,0);
			System.out.println("#"+tc+" "+min);
		}
	}

	static void dfs(int cnt,int flag,int Y,int X,int sum)
	{
		if(cnt==N)
		{
			sum+=calc(new pair(Y,X),new pair(arr[1].first,arr[1].second));
			if(sum<min)
			{
				min=sum;
			}
			return;
		}
		
		for(int i=2;i<N+2;i++)
		{
			if((flag&1<<i)==0)
			{
				if(sum+calc(new pair(Y,X),new pair(arr[i].first,arr[i].second))<min)
				dfs(cnt+1,flag|1<<i,arr[i].first,arr[i].second,sum+calc(new pair(Y,X),new pair(arr[i].first,arr[i].second)));
			}
		}
	}
	static int calc(pair p1, pair p2)
	{
		return Math.abs(p1.first-p2.first)+Math.abs(p1.second-p2.second);
	}
	static class pair
	{
		int first;
		int second;
		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
