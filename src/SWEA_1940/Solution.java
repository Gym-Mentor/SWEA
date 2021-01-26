package SWEA_1940;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner sc=new Scanner(System.in);
		
		T=sc.nextInt();
		for(int tc=1;tc<=T;tc++)
		{
			int N;
			int result=0,now=0;
			N=sc.nextInt();
			for(int i=0;i<N;i++)
			{
				
				int num1,num2;
				num1=sc.nextInt();
				if(num1==0)
				{
					result+=now;
				}
				else if(num1==1)
				{
					num2=sc.nextInt();
					now+=num2;
					result+=now;
				}
				else if(num1==2)
				{
					num2=sc.nextInt();
					now-=num2;
					if(now<0)
					{
						now=0;
					}
					result+=now;
				}
			}
			System.out.println("#"+tc+ " "+result);
		}
	}

}
