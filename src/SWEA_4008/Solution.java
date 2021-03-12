package SWEA_4008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 만들기
//20210312
public class Solution {
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	static int T,N,result=0;
	static int[] op,input;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			
			N=Integer.parseInt(br.readLine());
			op=new int[4];
			input =new int[N];
			min=Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for(int i=0;i<4;i++)
			{
				op[i]=Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
			{
				input[i]=Integer.parseInt(st.nextToken());
			}
			dfs(1,input[0],op[0],op[1],op[2],op[3]);
			System.out.println("#"+tc+" "+Math.abs(min-max));
		}
	}

	static void dfs(int cnt, int num, int plus, int minus, int multiply, int divide)
	{
		if(cnt==N)
		{
			if(min>num)
				min=num;
			if(max<num)
				max=num;
			return;
		}
		for(int i=0;i<4;i++)
		{
			if(i==0)
			{
				if(plus>0)
				{
					dfs(cnt+1,num+input[cnt],plus-1,minus,multiply,divide);
					
				}
			}
			else if(i==1)
			{
				if(minus>0)
				{
					dfs(cnt+1,num-input[cnt],plus,minus-1,multiply,divide);
				}
			}
			else if(i==2)
			{
				if(multiply>0)
				{
					dfs(cnt+1,num*input[cnt],plus,minus,multiply-1,divide);
				}
			}
			else if(i==3)
			{
				if(divide>0)
				{
					dfs(cnt+1,num/input[cnt],plus,minus,multiply,divide-1);
				}
			}
		}
	}
}	
