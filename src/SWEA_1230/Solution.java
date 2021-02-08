package SWEA_1230;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=Integer.parseInt(br.readLine());
			List<Integer> list= new LinkedList<>();
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens())
			{
				list.add(Integer.parseInt(st.nextToken()));
			}
			int cmdNum=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<cmdNum;i++)
			{
					String cmd=st.nextToken();
					
					if(cmd.equals("I"))
					{	int idx=Integer.parseInt(st.nextToken());
						int n=Integer.parseInt(st.nextToken());
						for(int j=0;j<n;j++)
						{
							list.add(idx++,Integer.parseInt(st.nextToken()));
						}
					}
					else if(cmd.equals("D"))
					{
						int idx=Integer.parseInt(st.nextToken());
						int n=Integer.parseInt(st.nextToken());
						for(int j=0;j<n;j++)
						{
							list.remove(idx);
						}
					}
					else if(cmd.equals("A"))
					{
						int n=Integer.parseInt(st.nextToken());
						for(int j=0;j<n;j++)
						{
							list.add(list.size()-1,Integer.parseInt(st.nextToken()));
						}
					}
			}
			System.out.print("#"+test_case+" ");
			for(int i=0;i<10;i++)
			{
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
}