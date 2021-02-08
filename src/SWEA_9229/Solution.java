package SWEA_9229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int arr[];
	static int max=-1;
	static int N,M;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			max=-1;
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			arr=new int[N];
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());
			}
			comb(0,0,0);
			System.out.println("#"+test_case+" "+max);
			
		}
	}
	
	static void comb(int cnt,int start,int sum)
	{
		if(cnt==2)
		{
			if(max<sum&&sum<=M)
			{
				max=sum;
			}
			return;
		}
		for(int i=start;i<N;i++)
		{
			comb(cnt+1,i+1,sum+arr[i]);
		}
	}
}