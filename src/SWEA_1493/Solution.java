package SWEA_1493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

	static int T;
	static int num1,num2;
	static int arr[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		
		T=Integer.parseInt(br.readLine());
		arr=new int[301][301];
		for(int test_case=1;test_case<=T;test_case++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
			num1=Integer.parseInt(st.nextToken());
			num2=Integer.parseInt(st.nextToken());
			int num1X=0,num1Y=0;
			int num2X=0,num2Y=0;
			int num3X=0,num3Y=0;
			int num=1;
			for(int i=1;i<=300;i++)
			{
				for(int j=1;i-j>=0;j++)
				{
					if(num1==num)
					{
						num1X=i-j+1;
						num1Y=j;
					}
					if(num2==num)
					{
						num2X=i-j+1;
						num2Y=j;
					}
					arr[i-j+1][j]=num++;
				}
			}
			num3X=num1X+num2X;
			num3Y=num1Y+num2Y;
			System.out.println("#"+test_case+" "+arr[num3X][num3Y]);
		}
	}

}
