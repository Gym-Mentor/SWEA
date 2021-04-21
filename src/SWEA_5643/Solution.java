package SWEA_5643;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//키 순서
public class Solution {

	static int N,M,T;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		arr=new int[N+1][N+1];
//		Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i=0;i<M;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			arr[from][to]=1;
			arr[to][from]=-1;
		}
		
		
		for(int k=1;k<=N;k++)
		{
			for(int i=1;i<=N;i++)
			{
				if(i==k)continue;
				for(int j=1;j<=N;j++)
				{
					if(j==k||j==i)continue;
					if(arr[i][j]==0)
					{
						if(arr[i][k]==1&&arr[k][j]==1)
							arr[i][j]=1;
						if(arr[i][k]==-1&&arr[k][j]==-1)
							arr[i][j]=-1;
					}
				}
			}
		}
		int result=0;
		for(int i=1;i<=N;i++)
		{
			boolean check=false;
			for(int j=1;j<=N;j++)
			{
				if(i!=j&&arr[i][j]==0)
				{
					check=true;
					break;
				}
			}
			if(!check)
			{
				result++;
			}
		}
		System.out.println("#"+tc+" "+result);
	}
	}
}