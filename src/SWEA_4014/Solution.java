package SWEA_4014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T,N,X;
	static int arr[][],countX[][],countY[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			
			arr=new int[N][N];
			countX=new int[N][N];
			countY=new int[N][N];
			int result=0;
			for(int i=0;i<N;i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++)
			{
				countX[i][0]=1;
				for(int j=1;j<N;j++)
				{
					if(arr[i][j-1]==arr[i][j]) // X축 count
					{
						countX[i][j]=countX[i][j-1]+1;
					}
					else
					{
						countX[i][j]=1;
					}
				}
			}
			
			//Y축 카운트
			for(int i=0;i<N;i++)
			{
				countY[0][i]=1;
				for(int j=1;j<N;j++)
				{
					if(arr[j-1][i]==arr[j][i]) // X축 count
					{
						countY[j][i]=countY[j-1][i]+1;
					}
					else
					{
						countY[j][i]=1;
					}
				}
			}
			for(int i=0;i<N;i++)
			{
				for(int j=1;j<N;j++)
				{
					if(arr[i][j-1]==arr[i][j])
					{
					}
					else if(arr[i][j-1]+1==arr[i][j]) // 한층 더 높은 지형이 오면
					{
						if(countX[i][j-1]>=X)
						{
							if(j-X>=0) {
								boolean check=true;
							for(int idx=j-1;idx>=j-X;idx--)
							{
								if(countX[i][idx]==-1)
								{
									check=false;
								}
							}
							if(!check)break;
							countX[i][j-1]=-1;
							}
						}
						else
						{
							break;
						}
					}
					else if(arr[i][j-1]-1==arr[i][j]) // 한층 더 낮은 지형이 오면
					{
						if(j-1+X<N&&countX[i][j-1+X]>=X)
						{
							countX[i][j-1+X]=-1;
						}
						else
						{
							break;
						}
					}
					else if(arr[i][j-1]!=arr[i][j])
					{
						break;
					}
					if(j==N-1)
						result++;
				}
			}
			
			for(int i=0;i<N;i++)
			{
				for(int j=1;j<N;j++)
				{
					if(arr[j-1][i]==arr[j][i])
					{
					}
					else if(arr[j-1][i]+1==arr[j][i]) // 한층 더 높은 지형이 오면
					{
						if(countY[j-1][i]>=X)
						{
							if(j-X>=0) {
								boolean check=true;
								for(int idx=j-1;idx>=j-X;idx--)
								{
									if(countY[idx][i]==-1)
									{
										check=false;
									}
								}
								if(!check)break;
								countY[j-1][i]=-1;
							}
						}
						else
						{
							break;
						}
					}
					else if(arr[j-1][i]-1==arr[j][i]) // 한층 더 낮은 지형이 오면
					{
						if(j-1+X<N&&countY[j-1+X][i]>=X)
						{
							countY[j-1+X][i]=-1;
						}
						else
						{
							break;
						}
					}
					else if(arr[j-1][i]!=arr[j][i])
					{
						break;
					}
					if(j==N-1)
						result++;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
		
	}

}
