package SWEA_2805;
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
		
			int N=sc.nextInt();
			int result=0;
			char [][]arr=new char[N][N];
			for(int i=0;i<N;i++)
			{
				String s=sc.next();
				for(int j=0;j<N;j++)
				{
					arr[i][j]=s.charAt(j);
				}
			}
			
			for(int i=0;i<=N/2;i++)
			{
				for(int j=0;j<=i;j++)
				{
					result+=arr[i][N/2+j]-'0';
					if(j==0)continue;
					result+=arr[i][N/2-j]-'0';
				}
			}
			for(int i=N/2+1;i<N;i++)
			{
				for(int j=0;j<N-i;j++)
				{
					result+=arr[i][N/2+j]-'0';
					if(j==0)continue;
					result+=arr[i][N/2-j]-'0';
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}