package SWEA_1974;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] arr=new int[9][9];
			boolean result=true;
			///////////////////////// 입력
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					arr[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0;i<9;i++)
			{
				int[] check=new int[] {1,0,0,0,0,0,0,0,0,0};
				for(int j=0;j<9;j++)
				{
					check[arr[i][j]]++;
				}
				for(int j=1;j<=9;j++)
				{
					if(check[j]!=1)result=false;
				}
			}
			
			if(result)
			for(int i=0;i<9;i++)
			{
				int[] check=new int[] {1,0,0,0,0,0,0,0,0,0};
				for(int j=0;j<9;j++)
				{
					check[arr[j][i]]++;
				}
				for(int j=1;j<=9;j++)
				{
					if(check[j]!=1)result=false;
				}
			}
			
			if(result)
			for(int i=0;i<9;i+=3)
			{
				for(int j=0;j<9;j+=3)
				{
					int[] check=new int[] {1,0,0,0,0,0,0,0,0,0};
					for(int k=0;k<3;k++)
					{
						for(int l=0;l<3;l++)
						{
							check[arr[i+k][j+l]]++;
						}
					}
					for(int k=1;k<=9;k++)
					{
						if(check[k]!=1)result=false;
		
					}
				}
			}
			if(result)
				System.out.println("#"+test_case+" 1");
			else
				System.out.println("#"+test_case+" 0");
		}
	}
}