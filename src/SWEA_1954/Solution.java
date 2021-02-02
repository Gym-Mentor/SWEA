package SWEA_1954;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[] dirX= {1,0,-1,0};
		int[] dirY= {0,1,0,-1};
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=sc.nextInt();
			int nextY=0,nextX=0;
			int idx=0;
			int[][] arr=new int[N][N];
			for(int i=1;i<=N*N;i++)
			{
				arr[nextY][nextX]=i;
				nextY+=dirY[idx];
				nextX+=dirX[idx];
				if(!(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&arr[nextY][nextX]==0))
				{
					nextY-=dirY[idx];
					nextX-=dirX[idx];
					idx++;
					idx%=4;
					nextY+=dirY[idx];
					nextX+=dirX[idx];
				}
			}
			System.out.println("#"+test_case);
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}