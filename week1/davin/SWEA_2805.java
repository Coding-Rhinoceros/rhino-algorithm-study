//20분~

import java.util.*;
import java.io.*;

public class SWEA_2805 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 //BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] nums = new int[n][n];
			for (int j = 0; j < n; j++) {
				char[] chars = br.readLine().toCharArray();
				for (int k = 0; k < n; k++) {
					nums[j][k] = chars[k] - '0';

				}
			}

			int mid = n / 2;
			int sum = 0;
			for (int j = 0; j < n/2; j++) {
				for (int k = mid - j; k <= mid + j; k++) {
					sum += nums[j][k];
				}
			}
			for (int j = n/2; j < n; j++) {
				for (int k = mid - (n-1-j); k <= mid + (n-1-j); k++) {
					sum += nums[j][k];
				}
			}
			
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
