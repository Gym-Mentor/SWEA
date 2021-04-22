package SWEA_1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int T,N,cnt;
	static char board[][];
	static boolean visited[][];
	static int dy[]= {1,1,1,0,0,-1,-1,-1};
	static int dx[]= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			cnt=0;
			N=Integer.parseInt(br.readLine());
			board=new char[N][N];
			visited=new boolean[N][N];
			for(int i=0;i<N;i++)
			{
				String str= br.readLine();
				for(int j=0;j<N;j++)
				{
					board[i][j]=str.charAt(j);
					if(board[i][j]=='*')visited[i][j]=true;
				}
			}
			solve();
			System.out.println("#"+tc+" "+cnt);
		}
		
		
		
	}
	static void solve()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				// 아직 방문을 안했고, 8방이 0일 때
				if(!visited[i][j]&&check(i,j)==0)
				{
					cnt++;
					bfs(i,j);
				}
			}
		}
		count();
	}
	static void count()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(!visited[i][j])cnt++;
			}
		}
	}
	
	static void bfs(int Y,int X)
	{
		Queue<int[]> q =new LinkedList<>();
		q.offer(new int[] {Y,X});
		visited[Y][X]=true;
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			q.poll();
			
			for(int i=0;i<8;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&!visited[nextY][nextX])
				{
					if(check(nextY,nextX)==0)
					{
						visited[nextY][nextX]=true;
						q.offer(new int[] {nextY,nextX});
					}
					else
					{
						visited[nextY][nextX]=true;
					}
				}
			}
		}
	}
	static int check(int Y,int X) 
	{
		int cnt=0;
		for(int i=0;i<8;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			
			//8방위중에 하나라도 지뢰가 있으면 cnt증가
			if((0<=nextY&&nextY<N&&0<=nextX&&nextX<N))
			{
				if(board[nextY][nextX]=='*')
					cnt++;
			}
		}
		
		return cnt;
	}
}
