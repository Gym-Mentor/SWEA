package SWEA_1263;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T,N,dist[][],min,max=10000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			min=max;
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			dist=new int[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					dist[i][j]=max;
					int num=Integer.parseInt(st.nextToken());
					if(num==1)
					dist[i][j]=num;
				}
			}
			
			for(int k=0;k<N;k++)
			{
				for(int i=0;i<N;i++)
				{
					if(i==k)continue;
					for(int j=0;j<N;j++)
					{
						if(j==k&&j==i)continue;
						dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			for(int i=0;i<N;i++)
			{
				int temp=0;
				for(int j=0;j<N;j++)
				{
					if(i==j)continue;
					temp+=dist[i][j];
				}
				if(min>temp)min=temp;
			}
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
