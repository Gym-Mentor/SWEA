package SWEA_1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N,maxCore,maxLine;
	static int[][] arr;
	static List<pair> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			N=Integer.parseInt(br.readLine());
			arr=new int[N][N];
			list=new ArrayList<>();
			maxCore=0;maxLine=0;
			for(int i=0;i<N;i++)
			{
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(arr[i][j]==1)
						list.add(new pair(i,j));
				}
			}
			recursive(0,0,0,arr);
			System.out.println("#"+tc+" "+maxLine);
		}
	}
	
	static void recursive(int cnt,int core,int line,int[][] input)
	{
		if(cnt==list.size())
		{
			if(maxCore<core)
			{
				maxCore=core;
				maxLine=line;
			}
			else if(maxCore==core)
			{
				if(maxLine>line)
				{
					maxLine=line;
				}
			}
			
			return;
		}
		boolean total=false;
		int Y=list.get(cnt).first;
		int X=list.get(cnt).second;
		int tempLine=0;
		boolean check=true;
		int[][]	output=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				output[i][j]=input[i][j];
			}
		}
		//상
		for(int i=Y;i>=0;i--)
		{
			if(output[i][X]==1&&i!=Y)
			{
				check=false;
				break;
			}
			if(i==0)
			{
				output[i][X]=1;
				break;
			}

			output[i][X]=1;
			tempLine++;
		}
		if(check)
		{
			recursive(cnt+1,core+1,line+tempLine,output);
			total=true;
		}
		tempLine=0;
		check=true;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				output[i][j]=input[i][j];
			}
		}
		//하
		for(int i=Y;i<N;i++)
		{
			if(output[i][X]==1&&i!=Y)
			{
				check=false;
				break;
			}
			if(i==N-1)
			{
				output[i][X]=1;
				break;
			}
	
			output[i][X]=1;
			tempLine++;
		}
		if(check)
		{
			recursive(cnt+1,core+1,line+tempLine,output);
			total=true;
		}
		
		tempLine=0;
		check=true;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				output[i][j]=input[i][j];
			}
		}
		//좌
		for(int i=X;i>=0;i--)
		{
			if(output[Y][i]==1&&i!=X)
			{
				check=false;
				break;
			}
			if(i==0)
			{
				output[Y][i]=1;
				break;
			}

			output[Y][i]=1;
			tempLine++;
		}
		if(check)
		{
			recursive(cnt+1,core+1,line+tempLine,output);
			total=true;
		}
		tempLine=0;
		check=true;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				output[i][j]=input[i][j];
			}
		}
		//우
		for(int i=X;i<N;i++)
		{
			if(output[Y][i]==1&&i!=X)
			{
				check=false;
				break;
			}
			if(i==N-1)
			{
				output[Y][i]=1;
				break;
			}

			output[Y][i]=1;
			tempLine++;
		}
		if(check)
		{
			recursive(cnt+1,core+1,line+tempLine,output);
			total=true;
		}
		if(total==false)
		recursive(cnt+1,core,line,input);
	}
	static class pair
	{
		int first;
		int second;
		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
	}
}
