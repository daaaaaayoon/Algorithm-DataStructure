package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15656N과M7 {
	// N개의 자연수 중에서 M개를 고른 수열 + 같은 수를 여러번 골라도 된다 => 중복순열
	// 입력받은 숫자들로 중복 순열을 만들어서 출력하는 문제

	static int N, M;
	static int[] input, ans;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		input = new int[N];
		ans = new int[M];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input); // 사전순으로 증가하는 순서로 출력하기 위해서 정렬

		perm(0);

		System.out.println(sb.toString());
	}

	static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			ans[cnt] = input[i];
			perm(cnt + 1);
		}
	}
}
