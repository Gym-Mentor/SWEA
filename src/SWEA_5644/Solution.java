package SWEA_5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T,M,A,result,range,user1X,user1Y,user2X,user2Y;
	static int dir[][],map[][][];
	static int dy[]= {0,-1,0,1,0};
	static int dx[]= {0,0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
			M=Integer.parseInt(st.nextToken());
			A=Integer.parseInt(st.nextToken());
			
			map=new int[11][11][A];
			dir=new int[2][M+1];
			result=0;
			user1X=1;
			user1Y=1;
			user2X=10;
			user2Y=10;
			for(int i=0;i<2;i++)
			{
				st= new StringTokenizer(br.readLine()," ");
				for(int j=1;j<=M;j++)
				{
					dir[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<A;i++)
			{
				st= new StringTokenizer(br.readLine()," ");
				int Y=Integer.parseInt(st.nextToken());
				int X=Integer.parseInt(st.nextToken());
				range=Integer.parseInt(st.nextToken());
				int n=Integer.parseInt(st.nextToken());
				fill(Y,X,0,n,i);
			}

			for(int i=0;i<=M;i++)
			{
				//다음 유저 위치
				user1X+=dx[dir[0][i]];
				user1Y+=dy[dir[0][i]];
				user2X+=dx[dir[1][i]];
				user2Y+=dy[dir[1][i]];
				int max=0;
				for(int j=0;j<A;j++)
				{
					int num1=map[user1X][user1Y][j];
					
					for(int k=0;k<A;k++)
					{
						int num2=map[user2X][user2Y][k];
						if(j==k&&num1==num2)
						{
							max=Math.max(max, num1);
						}
						else
						{
							max=Math.max(max, num1+num2);
						}
					}
				}
				result+=max;
				
				
				
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void fill(int Y,int X,int cnt,int num,int idx)
	{
		if(range==cnt-1)
		{
			return;
		}
		
		map[Y][X][idx]=num;
		for(int i=1;i<5;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			if(1<=nextY&&nextY<11&&1<=nextX&&nextX<11)
			fill(Y+dy[i],X+dx[i],cnt+1,num,idx);
		}
	}
}
