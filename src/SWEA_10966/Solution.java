package SWEA_10966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N,M,T,result;
	static int visited[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			visited=new int[N][M];
			result=0;
			
			for(int i=0;i<N;i++)
			{
				String str=br.readLine();
				for(int j=0;j<M;j++)
				{
					visited[i][j]=Integer.MAX_VALUE;
					if('W'==str.charAt(j)) 
					{	
						q.offer(new int[] {i,j,0});
						visited[i][j]=0;
					}
				}
			}
			bfs();
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					result+=visited[i][j];
				}
			}
			System.out.println("#"+tc+" "+result);
		}
		return;
	}
	static void bfs()
	{
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int dist=q.peek()[2];
			q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M)
				{
					if(visited[nextY][nextX]>dist+1)
					{
						visited[nextY][nextX]=dist+1;
						q.offer(new int[] {nextY,nextX,dist+1});
					}
				}
			}
		}
	}
}
