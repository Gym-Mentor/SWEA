package SWEA_2001;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N,M;
			N=sc.nextInt();
			M=sc.nextInt();
			int[][] arr= new int[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					arr[i][j]=sc.nextInt();
				}
			}
			int result=0;
			int max=0;
			for(int i=0;i<=N-M;i++)
			{
				for(int j=0;j<=N-M;j++)
				{
					max=0;
					for(int k=i;k<i+M;k++)
					{
						for(int l=j;l<j+M;l++)
						{
							max+=arr[k][l];
						}
					}
					result=Math.max(result, max);
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}