package SWEA_5215;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int calorie,N;
	static boolean isSelected[];
	static int max=0;
	static int[] point,cal;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=(Integer.parseInt(br.readLine()));
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int result=0;
			max=0;
			String str=br.readLine();
			StringTokenizer st=new StringTokenizer(str," ");
			N=Integer.parseInt(st.nextToken());
			calorie=Integer.parseInt(st.nextToken());
			point=new int[N];
			cal=new int[N];
			isSelected=new boolean[N];
			for(int i=0;i<N;i++)
			{
				str=br.readLine();
				st=new StringTokenizer(str," ");
				int num1=Integer.parseInt(st.nextToken());
				int num2=Integer.parseInt(st.nextToken());
				point[i]=num1;
				cal[i]=num2;
			}
			powerSet(0);
			System.out.println("#"+test_case+" "+max);
		}
	}
	static int powerSet(int cnt)
	{
		if(cnt==N)
		{
			int pointSum=0;
			int calorieSum=0;
			for(int i=0;i<N;i++)
			{
				if(isSelected[i])
				{
					pointSum+=point[i];
					calorieSum+=cal[i];
				}
			}
			if(calorie>=calorieSum)
			{
				if(max<pointSum)
					max=pointSum;
			}
			return pointSum;
		}
		isSelected[cnt]=true;
		powerSet(cnt+1);
		isSelected[cnt]=false;
		powerSet(cnt+1);
		
		return 0;
	}
}