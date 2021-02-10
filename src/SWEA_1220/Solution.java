package SWEA_1220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		
		for(int tc=1;tc<=T;tc++)
		{
			int result=0;
			int now=0;
			int N=Integer.parseInt(br.readLine());
			int [][]arr =new int[N][N];
			for(int i=0;i<N;i++)
			{
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			

			for(int col=0;col<N;col++)
			{
				now=0;
				for(int row=0;row<N;row++)
				{
					if(now==0) // 현재 찾는 중일 때
					{
						if(arr[row][col]==1)
						{
							now=1;
						}
					}
					
					else if(now==1)
					{
						if(arr[row][col]==2)
						{
							result++;
							now=0;
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
