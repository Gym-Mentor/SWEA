package SWEA_1225;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);


		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
			Queue<Integer> q =new LinkedList<Integer>();
			for(int i=0;i<8;i++)
			{
				q.offer(sc.nextInt());
			}
			int cnt=1;
			while(true)
			{
				int num=q.poll();
				if(num-cnt<=0)
				{
					q.offer(0);
					break;
				}
				q.offer(num-cnt);
				cnt++;
				if(cnt==6)
				{
					cnt=1;
				}
			}
			System.out.print("#"+test_case+" ");
			for(int i=0;i<8;i++)
			{
				System.out.print(q.poll()%10+" ");
			}
			System.out.println("");
		}
	}
}