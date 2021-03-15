package SWEA_1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T,result=0;
	static int cost[];
	static int month[];
	static int DP[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			cost=new int[4];
			month=new int[13];
			DP=new int[13];
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for(int i=0;i<4;i++)
			{
				cost[i]=Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine()," ");
			for(int i=1;i<=12;i++)
			{
				month[i]=Integer.parseInt(st.nextToken());
			}
			
			DP[0]=0;
			for(int i=1;i<=12;i++)
			{
				if(month[i]>0)
				{
					DP[i]=DP[i-1]+cost[1];
					DP[i]=Math.min(DP[i], DP[i-1]+month[i]*cost[0]);
				}
				
				if(i>=3)
				{					
					if(month[i]>0||month[i-1]>0||month[i-2]>0)
					{
						DP[i]=Math.min(cost[2]+DP[i-3],DP[i]);
					}
				}
				
				if(month[i]==0)
				{
					DP[i]=DP[i-1];
				}
				
				if(i==12)
				{
					if(DP[i]==0)
					{
						break;
					}
					else
					{
						DP[i]=Math.min(DP[i], cost[3]);
					}
				}
			}
			System.out.println("#"+tc+" "+DP[12]);
		}
		
	}

}
