package SWEA_2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,M,C,result=0;
	static int board[][];
	static PriorityQueue<Honey> pq=new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			result=0;
			pq.clear();
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			
			board=new int[N][N];
			for(int i=0;i<N;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			// 모든 경우의 수 들여다보기
			look();
			getResult();
			System.out.println("#"+tc+" "+result);
		}
		
	}
	static void getResult()
	{
		int Y=pq.peek().Y;
		int XStart=pq.peek().XStart;
		int XEnd=pq.peek().XEnd;
		result+=pq.peek().sum;
//		System.out.println(" Y : "+pq.peek().Y+" XS : "+pq.peek().XStart+" XE : "+pq.peek().XEnd+" SUM : "+pq.peek().sum);
		pq.poll();
		while(!pq.isEmpty())
		{
			if(pq.peek().Y!=Y)
			{
//				System.out.println(" Y : "+pq.peek().Y+" XS : "+pq.peek().XStart+" XE : "+pq.peek().XEnd+" SUM : "+pq.peek().sum);

				result+=pq.peek().sum;
				return;
			}
			else
			{
				if(XEnd<pq.peek().XStart||XStart>pq.peek().XEnd)
				{
//					System.out.println(" Y : "+pq.peek().Y+" XS : "+pq.peek().XStart+" XE : "+pq.peek().XEnd+" SUM : "+pq.peek().sum);

					result+=pq.peek().sum;
					return;
				}
				else
				{
					pq.poll();
				}
			}
		}
	}
	static void look()
	{
		for(int i=0;i<N;i++)
		{
			//초기 꿀 채취
			int temp=0;
			for(int j=0;j<M;j++)
			{
				temp+=board[i][j];
			}
			
			// 초기꿀의 최대값 구하기
			if(temp>C)
			{
				comb(0,i,0,M-1,0,0);
			}
			else
			{
				int sum=0;
				for(int j=0;j<=M-1;j++)
				{
					sum+=board[i][j]*board[i][j];
				}
				pq.add(new Honey(i,0,M-1,sum));
			}
			
			// 슬라이딩 윈도우 방식으로 하나씩 늘려나가기
			for(int j=1;j<N-M+1;j++)
			{
				temp-=board[i][j-1];
				temp+=board[i][j+M-1];
				
				// 최대값 구하기
				if(temp>C)
				{
					comb(0,i,j,j+M-1,0,0);
				}
				else
				{
					int sum=0;
					for(int k=j;k<j+M;k++)
					{
						sum+=board[i][k]*board[i][k];
					}
					pq.add(new Honey(i,j,j+M,sum));
				}
			}
		}
	}
	static void comb(int cnt,int Y,int start,int end,int sum,int S)
	{
		if(cnt==M)
		{
			pq.add(new Honey(Y,end-M+1,end,S));
			return;
		}
		for(int i=start;i<=end;i++)
		{
			if(sum+board[Y][i]<=C)
			comb(cnt+1,Y,i+1,end,sum+board[Y][i],S+board[Y][i]*board[Y][i]); // 선택함
			comb(cnt+1,Y,i+1,end,sum,S); // 선택안함
		}
	}
	static class Honey implements Comparable<Honey>{
		int Y;
		int XStart;
		int XEnd;
		int sum;
		public Honey(int y, int xStart, int xEnd, int sum) {
			super();
			Y = y;
			XStart = xStart;
			XEnd = xEnd;
			this.sum = sum;
		}
		@Override
		public int compareTo(Honey o) {
			// TODO Auto-generated method stub
			return o.sum-this.sum;
		}
	}
}
