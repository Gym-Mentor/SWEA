package SWEA_1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int arr[][];
	static boolean isReachable;
	static int T,startX,startY,endX,endY;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int tc=1;tc<=10;tc++)
		{
			T=Integer.parseInt(br.readLine());
			arr=new int[100][100];
			isReachable=false;
			for(int i=0;i<100;i++)
			{
				String str=br.readLine();
				for(int j=0;j<100;j++)
				{
					arr[i][j]=str.charAt(j)-'0';
					if(arr[i][j]==2)
					{
						startY=i;
						startX=j;
					}
					else if(arr[i][j]==3)
					{
						endY=i;
						endX=j;
					}
				}
			}
			DFS(startY,startX);
			if(isReachable)
			{
				System.out.println("#"+tc+" 1");
			}
			else
			{
				System.out.println("#"+tc+" 0");
			}
			
		}
	}
	static void DFS(int Y,int X)
	{
		for(int i=0;i<4;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			
			if(0<=nextY&&nextY<100&&0<=nextX&&nextX<100)
			{
				if(arr[nextY][nextX]==0)
				{
					arr[nextY][nextX]=1;
					DFS(nextY,nextX);
				}
				else if(arr[nextY][nextX]==3)
				{
					isReachable=true;
					return;
				}
			}
		}
		return;
	}
}
