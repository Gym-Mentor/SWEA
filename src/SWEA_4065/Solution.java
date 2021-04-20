package SWEA_4065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int T;
	static int DP[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			String str1=br.readLine();
			String str2=br.readLine();
			
			DP=new int[str1.length()+1][str2.length()+1];
			for(int i=1;i<=str1.length();i++)
			{
				for(int j=1;j<=str2.length();j++) 
				{
					if(str1.charAt(i-1)==str2.charAt(j-1))
					{
						DP[i][j]=DP[i-1][j-1]+1;
					}
					else
					{
						DP[i][j]=Math.max(DP[i][j-1], DP[i-1][j]);
					}
				}
			}
			System.out.println("#"+tc+" "+DP[str1.length()][str2.length()]);
		}
	}

}
