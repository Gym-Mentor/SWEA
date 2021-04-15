package SWEA_1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,M,R,C,L,result;
	static int arr[][];
	static boolean visited[][];
	static boolean check[][]=new boolean[7][4];
	static int dy[]= {-1,1,0,0};
	static int dx[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		check[0][0]=true;
		check[0][1]=true;
		check[0][2]=true;
		check[0][3]=true;
		
		check[1][0]=true;
		check[1][1]=true;
		
		check[2][2]=true;
		check[2][3]=true;
		
		check[3][0]=true;
		check[3][3]=true;
		
		check[4][1]=true;
		check[4][3]=true;
		
		check[5][1]=true;
		check[5][2]=true;
		
		check[6][0]=true;
		check[6][2]=true;
		
		T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			result=0;
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			arr=new int[N][M];
			visited=new boolean[N][M];
			
			for(int i=0;i<N;i++)
			{
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			
			System.out.println("#"+tc+" "+result);
		}
	}

	static void bfs()
	{
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {R,C,1});
		visited[R][C]=true;
		result++;
		while(!q.isEmpty()) {
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int dist=q.peek()[2];
			q.poll();
			int idx=arr[nowY][nowX];
			
			if(dist==L)return;
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&!visited[nextY][nextX]&&arr[nextY][nextX]!=0)
				{
					if(check[idx-1][i]&&check[arr[nextY][nextX]-1][i%2==0?i+1:i-1])
					{
						q.offer(new int[] {nextY,nextX,dist+1});
						visited[nextY][nextX]=true;
						result++;
					}
				}
			}
			
		}
	}
}
