package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수 구하기
 * 합을 이루고 있는 수의 순서만 다른 것은 같은 것
 */
public class BJ_15989_123더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = stoi(br.readLine());

            int[] dp = new int[n + 1];
            Arrays.fill(dp, 1); // 1. 초기값 : 1로만 만드는 경우의 수 ~ 모두 1가지

            // 2. 숫자 2 추가
            for (int i = 2; i <= n; i++) {
                dp[i] += dp[i - 2];
            }

            // 3. 숫자 3 추가
            for (int i = 3; i <= n; i++) {
                dp[i] += dp[i - 3];
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);

    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
