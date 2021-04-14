package SWEA_5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,W,H,result,min;
	static int arr[][],temp[][],container[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			result=Integer.MAX_VALUE;
			arr=new int[H][W];
			temp=new int[H][W];
			container=new int[N];
			for(int i=0;i<H;i++)
			{
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			perm(0,container);
			System.out.println("#"+tc+" "+result);
		}
	}

	static void perm(int cnt,int[] container)
	{
		if(cnt==N)
		{
			solve();
			if(result>min)
			{
				result=min;
			}
			return;
		}
		for(int i=0;i<W;i++)
		{
			container[cnt]=i;
			perm(cnt+1,container);
		}
	}
	static void solve()
	{
		for(int i=0;i<H;i++)
		{
			for(int j=0;j<W;j++)
			{
				temp[i][j]=arr[i][j];
			}
		}
		for(int i=0;i<N;i++)
		{
			int X=container[i];
			int Y=0;
			while(Y<H)
			{
				if(temp[Y][X]!=0)
				{
					break;
				}
				else
				{
					Y++;
				}
			}
			//부수기
			if(Y!=H)
			b(Y,X);
			//내리기
			sort();
		}
		check();
	}
	static void b(int Y,int X) // 재귀로 구현
	{
		int num=temp[Y][X]-1;
		
		if(num<=0)
		{
			temp[Y][X]=0;
			return;
		}
		
		while(num>0)
		{
			temp[Y][X]=0;
			if(Y-num>=0&&temp[Y-num][X]>0)
			b(Y-num,X);
			if(Y+num<H&&temp[Y+num][X]>0)
			b(Y+num,X);
			if(X-num>=0&&temp[Y][X-num]>0)
			b(Y,X-num);
			if(X+num<W&&temp[Y][X+num]>0)
			b(Y,X+num);
			num--;
		}
		
	}
	static void sort() // 스택으로 구현
	{
		for(int i=0;i<W;i++)
		{
			Stack<Integer> s=new Stack<>();
			for(int j=0;j<H;j++)
			{
				if(temp[j][i]!=0)
					s.add(temp[j][i]);
			}
			for(int j=H-1;j>=0;j--)
			{
				if(!s.isEmpty())
				temp[j][i]=s.pop();
				else
				temp[j][i]=0;
			}
		}
	}
	static void check()
	{
		min=0;
		for(int i=0;i<H;i++)
		{
			for(int j=0;j<W;j++)
			{
				if(temp[i][j]!=0)
					min++;
			}
		}
	}
}
