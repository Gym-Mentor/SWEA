package SWEA_1949; 
// 등산로
// 2021 03 11

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,K,T,result=0,max=0;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	static int arr[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			visited=new boolean[N][N];
			arr=new int[N][N];
			result=0;
			max=0;
			
			for(int i=0;i<N;i++)
			{
				st= new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(max<arr[i][j])
						max=arr[i][j];
				}
			}
			for(int i=0;i<N;i++)
			{
				
				for(int j=0;j<N;j++)
				{
					if(arr[i][j]==max)
					{
						dfs(i,j,K,1,arr[i][j]);		
						visited[i][j]=false;
					}

				}
			}
			System.out.println("#"+tc+" "+result);
			
		}
	}

	static void dfs(int Y,int X,int mow,int cnt,int height) {
		
			visited[Y][X]=true;
			if(result<cnt)result=cnt;
			
			for(int i=0;i<4;i++)
			{
				int nextY=Y+dy[i];
				int nextX=X+dx[i];
				if(nextY<0||nextY>=N||0>nextX||nextX>=N)continue;
				if(visited[nextY][nextX])continue;
				
				if(arr[nextY][nextX]<height)
				{					
					visited[nextY][nextX]=true;
					dfs(nextY,nextX,mow,cnt+1,arr[nextY][nextX]);
				}else {
					if(mow!=0)
					{
						if(arr[nextY][nextX]-mow<height) {	
							visited[nextY][nextX]=true;
							dfs(nextY,nextX,0,cnt+1,height-1);
						}
					}
				}
				visited[nextY][nextX]=false;
			}
	}

}
