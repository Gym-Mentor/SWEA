package SWEA_1233;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Nodes
{
	int idx;
	String op;
	int left=1;
	int right=1;
}
class Solution
{
	static int N;
	static boolean result;
	static Nodes[] node;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N=Integer.parseInt(br.readLine());
			node=new Nodes[N+1];
			result=true;
			for(int i=1;i<=N;i++)
			{
				node[i]=new Nodes();
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				int idx=Integer.parseInt(st.nextToken());
				int left=1;
				int right=1;
				String op=st.nextToken();
				if(st.hasMoreTokens()) {
				left=Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens())
				right=Integer.parseInt(st.nextToken());
				}	

				node[i].idx=idx;
				node[i].op=op;
				node[i].left=left;
				node[i].right=right;
			}
			dfs(1);
			System.out.print("#"+test_case);
			System.out.println(result?" 1":" 0");
		}
	}

		
		static void dfs(int idx)
		{
			if(idx>=N+1)return;
			if(node[idx].left==1)
			{
				if(node[idx].op.equals("-")||node[idx].op.equals("+")||node[idx].op.equals("/")||node[idx].op.equals("*"))
				{
					result=false;
				}
			}
			else
			{
				if(!(node[idx].op.equals("-")||node[idx].op.equals("+")||node[idx].op.equals("/")||node[idx].op.equals("*")))
				{
					result=false;
				}
			}
			dfs(idx*2);
			dfs(idx*2+1);
		}
}
	

