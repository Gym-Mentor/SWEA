package SWEA_6808;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static boolean visited[];
	static int arr[],input[];
	static int winCnt,loseCnt;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			visited=new boolean [18+1];
			arr=new int[9];
			input=new int[9];
			winCnt=0;
			loseCnt=0;
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<9;i++)
			{
				int num=Integer.parseInt(st.nextToken());
				input[i]=num;
				visited[num]=true;
			}
			int cnt=0;
			for(int i=1;i<=18;i++)
			{
				if(visited[i]==false)
				{
					arr[cnt++]=i;
				}
				else
				{
					visited[i]=false;
				}
			}
			permutation(0,0,0);
			System.out.println("#"+test_case+" "+winCnt+" "+loseCnt);
		}
		
	}
	static void permutation(int cnt,int win,int lose)
	{
		if(cnt==9)
		{
			if(win>lose)
			{
				winCnt++;
			}
			else if(win<lose)
			{
				loseCnt++;
			}
			return;
		}
		for(int i=0;i<9;i++)
		{
			if(visited[arr[i]])
			{
				continue;
			}
			visited[arr[i]]=true;
			permutation(cnt+1,input[cnt]>arr[i]?win+input[cnt]+arr[i]:win,input[cnt]<arr[i]?lose+input[cnt]+arr[i]:lose);
			visited[arr[i]]=false;
			
		}
	}
	
}
