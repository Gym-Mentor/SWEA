package SWEA_3816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++)
		{
			int result=0;
			st= new StringTokenizer(br.readLine()," ");
			String s1=st.nextToken();
			String s2=st.nextToken();
			
			int arr1[]=new int[26];
			int arr2[]=new int[26];
			for(int i=0;i<s1.length();i++) {
				arr1[s1.charAt(i)-'a']++;
			}
			for(int i=0;i<s1.length();i++) {
				arr2[s2.charAt(i)-'a']++;
			}
			if(check(arr1,arr2))
			{
				result++;
			}
			for(int i=0;i<s2.length()-s1.length();i++) {
				arr2[s2.charAt(i)-'a']--;
				arr2[s2.charAt(i+s1.length())-'a']++;
				if(check(arr1,arr2))
				{
					result++;
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	static boolean check(int[] arr1,int[] arr2)
	{
		
		for(int i=0;i<26;i++)
		{
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
	}
}
