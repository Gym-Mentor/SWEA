package SWEA_1861;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T, N;
	static int A[][];
	static int max = -1, maxIdx = -1; // 대소비교
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			max = -1;
			maxIdx = 1 << 31 - 1;
			A = new int[N][N];

			///////////////////////// 배열 입력 받기 /////////////////////////
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			////////////////////// 처리 부분//////////////////////
			int now = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max=Math.max(max, dfs(i,j,1,A[i][j])); // 이동할 수 있는 방의 크기 비교
				}
			}
			System.out.println("#" + test_case + " " + maxIdx + " " + max);

		}
	}

	static int dfs(int startY, int startX, int total,int value) {

			int result=total;
			for (int i = 0; i < 4; i++) {
				int nextY = startY + dy[i];
				int nextX = startX + dx[i];

				if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N) // 배열 안에 있을 때
				{

					if (A[startY][startX] + 1 == A[nextY][nextX]) // 하나 차이가 날 때 dfs호출
					{
						result =  dfs(nextY, nextX, total + 1,value);
						if(result>max)
						{
							maxIdx=value;
						}
						else if(result==max)
						{
							if(maxIdx>value)
								maxIdx=value;
						}
					}
				}
			}	

		return result;
	}
}
