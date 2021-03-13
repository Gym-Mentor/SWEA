package SWEA_5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int atom[][];
	static int visited[][]=new int[4001][4001];
	static boolean collide[][]=new boolean[4001][4001];
	static int N,maxIdx,result,T;
	
	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			T=Integer.parseInt(br.readLine());
			for(int tc=1;tc<=T;tc++)
			{
				N=Integer.parseInt(br.readLine());
				atom=new int[N][4];
				maxIdx=N-1;
				result=0;
				for(int i=0;i<N;i++)
				{
					st=new StringTokenizer(br.readLine()," ");
					for(int j=0;j<2;j++)
					{
						atom[i][j]=(1000+Integer.parseInt(st.nextToken()))*2; // 모두 양수로 바꾸고 실수 계산을 정수 계산으로 하기위해 2를 곱함
					}
					for(int j=2;j<4;j++)
					{
						atom[i][j]=Integer.parseInt(st.nextToken());
					}
					visited[atom[i][1]][atom[i][0]]++;
				}
				
				
				while(maxIdx>=0) {
					for(int i=0;i<=maxIdx;i++) // 원소 옮기기
					{
						////////////////// 원소 옮기고 충돌있는지 체크////////////////
						int x=atom[i][0];
						int y=atom[i][1];
						int dist=atom[i][2];
						
						if(dist==0)atom[i][1]++;  //상
						else if(dist==1)atom[i][1]--; //하
						else if(dist==2)atom[i][0]--; //좌
						else if(dist==3)atom[i][0]++; //우
						visited[y][x]--; // 방문하고 있던 곳에서 옮기기
						
						x=atom[i][0];
						y=atom[i][1];
						if(0>x||x>4000||0>y||4000<y) // 범위를 벗어난 경우
						{
							remove(i);
							i--;
						}
						else
						{
							visited[y][x]++;
							if(visited[y][x]>1)
							{
								collide[y][x]=true;
							}
						}
					}
					
					/////////////////충돌 원소 처리///////////////////
					for(int i=0;i<=maxIdx;i++)
					{
						int x=atom[i][0];
						int y=atom[i][1];
						
						if(collide[y][x]==true)
						{
							result+=atom[i][3];
							if(visited[y][x]==1)collide[y][x]=false;
							visited[y][x]--;
							remove(i);
							i--;
						}
					}
				}
				System.out.println("#"+tc+" "+result);
			}
	}
	
	static void remove(int i)
	{
		atom[i][0]=atom[maxIdx][0];
		atom[i][1]=atom[maxIdx][1];
		atom[i][2]=atom[maxIdx][2];
		atom[i][3]=atom[maxIdx][3];
		maxIdx--;
	}
}

