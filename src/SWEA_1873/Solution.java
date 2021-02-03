package SWEA_1873;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			/////////////////////선언 및 생성 /////////////
			int H,W,N;
			H=sc.nextInt(); // 행
			W=sc.nextInt(); // 열
			char[][] field=new char[H][W]; //현재 배틀필드
			int X=0,Y=0; // 현재 전차의 위치
			char dir=' '; //현재 전차의 방향
			///////////////////배틀필드 입력받기 ///////////
			for(int i=0;i<H;i++)
			{
				String s=sc.next();
				for(int j=0;j<W;j++)
				{
					field[i][j]=s.charAt(j);
					if(field[i][j]=='<') //////전차의 위치 저장
					{
						X=j;
						Y=i;
						dir='<';
					}
					else if(field[i][j]=='>') //////전차의 위치 저장
					{
						X=j;
						Y=i;
						dir='>';
					}
					else if(field[i][j]=='^') //////전차의 위치 저장
					{
						X=j;
						Y=i;
						dir='^';
					}
					else if(field[i][j]=='v') //////전차의 위치 저장
					{
						X=j;
						Y=i;
						dir='v';
					}
						
				}
			}
			
			///////////////////커맨드 입력받기////////////
			N=sc.nextInt();
			char[] cmd = new char[N];
			String s=sc.next();
			for(int i=0;i<N;i++)
			{
				cmd[i]=s.charAt(i);
			}
			
			/////////////////처리 부분 ////////////////
			for(int i=0;i<N;i++)
			{
				if(cmd[i]=='U') //위로 바꾸기
				{
					dir='^';
					field[Y][X]='^';
					if(0<=Y-1)//배열의 밖을 벗어나지 않을 때
					{
						if(field[Y-1][X]=='.') //평지일 경우 이동
						{
							field[Y][X]='.'; //현재 전차가 있는 곳을 평지로 바꾼 후 이동
							Y=Y-1;  //전차의 좌표 변경
							field[Y][X]='^';  /// 전차의 위치 이동
						}
					}
				}
				else if(cmd[i]=='D') //아래로 바꾸기
				{
					dir='v';
					field[Y][X]='v';
					if(Y+1<H)//배열의 밖을 벗어나지 않을 때
					{
						if(field[Y+1][X]=='.') //평지일 경우 이동
						{
							field[Y][X]='.'; //현재 전차가 있는 곳을 평지로 바꾼 후 이동
							Y=Y+1;
							field[Y][X]='v';
						}
					}
				}
				else if(cmd[i]=='L') //왼쪽으로 바꾸기
				{
					dir='<';
					field[Y][X]='<';
					if(0<=X-1)//배열의 밖을 벗어나지 않을 때
					{
						if(field[Y][X-1]=='.') //평지일 경우 이동
						{
							field[Y][X]='.'; //현재 전차가 있는 곳을 평지로 바꾼 후 이동
							X=X-1;
							field[Y][X]='<';
						}
					}
				}
				else if(cmd[i]=='R') //오른쪽으로 바꾸기
				{
					dir='>';
					field[Y][X]='>';
					if(X+1<W)//배열의 밖을 벗어나지 않을 때
					{
						if(field[Y][X+1]=='.') //평지일 경우 이동
						{
							field[Y][X]='.'; //현재 전차가 있는 곳을 평지로 바꾼 후 이동
							X=X+1;
							field[Y][X]='>';
						}
					}
				}
				else if(cmd[i]=='S') // 포탄 발사하기
				{
					if(dir=='^')
					{
						for(int j=Y-1;j>=0;j--)
						{
							if(field[j][X]=='*') //벽돌인 벽을 만났을 때
							{
								field[j][X]='.';
								break;
							}
							if(field[j][X]=='#') //강철인 벽을 만났을 때
							{
								break;
							}
						}
					}
					if(dir=='v')
					{
						for(int j=Y+1;j<H;j++)
						{
							if(field[j][X]=='*') //벽돌인 벽을 만났을 때
							{
								field[j][X]='.';
								break;
							}
							if(field[j][X]=='#') //강철인 벽을 만났을 때
							{
								break;
							}
						}
					}
					if(dir=='<')
					{
						for(int j=X-1;j>=0;j--)
						{
							if(field[Y][j]=='*') //벽돌인 벽을 만났을 때
							{
								field[Y][j]='.';
								break;
							}
							if(field[Y][j]=='#') //강철인 벽을 만났을 때
							{
								break;
							}
						}
					}
					if(dir=='>')
					{
						for(int j=X+1;j<W;j++)
						{
							if(field[Y][j]=='*') //벽돌인 벽을 만났을 때
							{
								field[Y][j]='.';
								break;
							}
							if(field[Y][j]=='#') //강철인 벽을 만났을 때
							{
								break;
							}
						}
					}
				}
			}
			
			//////////////////////출력/////////////////
			System.out.print("#"+test_case+" ");
			for(int i=0;i<H;i++)
			{
				for(int j=0;j<W;j++)
				{
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}
}