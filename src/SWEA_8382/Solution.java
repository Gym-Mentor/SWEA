package SWEA_8382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T,x1,y1,x2,y2;
	static int result;
	static boolean visited[][][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			x1=Integer.parseInt(st.nextToken())+100;
			y1=Integer.parseInt(st.nextToken())+100;
			x2=Integer.parseInt(st.nextToken())+100;
			y2=Integer.parseInt(st.nextToken())+100;
			
			result=0;
			visited=new boolean[201][201][2];
			
			bfs();
			System.out.println("#"+tc+" "+result);
		}
		
	}
	static void bfs()
	{
		Queue<int[]> q =new LinkedList<>();
		q.offer(new int[] {y1,x1,0,0});
		q.offer(new int[] {y1,x1,1,0});
		visited[y1][x1][0]=true;
		visited[y1][x1][1]=true;
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int dir=q.peek()[2];
			int dist=q.peek()[3];
			q.poll();
			if(nowY==y2&&nowX==x2)
			{
				result=dist;
				return;
			}
			
			if(dir==0) // 세로이동
			{
				for(int i=0;i<2;i++)
				{
					int nextY=nowY+dy[i];
					int nextX=nowX+dx[i];
					if(0<=nextY&&nextY<=200&&0<=nextX&&nextX<=200&&!visited[nextY][nextX][1])
					{
						q.offer(new int[] {nextY,nextX,1,dist+1});
						visited[nextY][nextX][1]=true;
					}
				}
			}
			else
			{	
				for(int i=2;i<4;i++)
				{
					int nextY=nowY+dy[i];
					int nextX=nowX+dx[i];
					if(0<=nextY&&nextY<=200&&0<=nextX&&nextX<=200&&!visited[nextY][nextX][0])
					{
						q.offer(new int[] {nextY,nextX,0,dist+1});
						visited[nextY][nextX][0]=true;
					}
				}
			}
		}
	}
}
