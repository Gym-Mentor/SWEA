package SWEA_3289;

import java.util.Scanner;

public class Solution {

	static int T,N,M;
	static int parents[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++)
		{
			N=sc.nextInt();
			M=sc.nextInt();
			
			parents=new int[N+1];
			for(int i=0;i<=N;i++)
			{
				parents[i]=i;
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<M;i++)
			{
				int cmd=sc.nextInt();
				int num1=sc.nextInt();
				int num2=sc.nextInt();
				
				if(cmd==0)
				{
					union(num1,num2);
				}
				else
				{
					if(findSet(num1)==findSet(num2))
					{
						System.out.print("1");
					}
					else
					{
						System.out.print("0");
					}
			
				}
			}
			System.out.println();
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
		return false;
	}
}
