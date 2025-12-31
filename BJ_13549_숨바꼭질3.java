package boj;

/*
 * 언니 N, 동생 K에 위치
 * 걷기 : 1초 후 -1 or +1
 * 순간이동 : 0초 후 2 * X로 이동
 * 언니가 동생을 찾을 수 있는 가장 빠른 시간 구하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BJ_13549_숨바꼭질3 {
    static final int INF = 100_000;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = stoi(inputs[0]);
        int k = stoi(inputs[1]);

        if (k <= n) {
            System.out.println(n - k);
            return;
        }


        System.out.println(zoBFS(n, k));
    }

    public static int zoBFS(int n, int k) {
        Deque<int[]> dq = new ArrayDeque<>(); // 위치, 소요 시간

        dq.add(new int[]{n, 0});

        int[] dp = new int[INF + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        while (!dq.isEmpty()) {
            int[] now = dq.poll();

            int x = now[0];
            int time = now[1];

            if (x == k) return time;

            // 1. 순간이동
            if (x * 2 <= INF && dp[x * 2] > time) {
                dp[x * 2] = time;
                dq.addFirst(new int[]{x * 2, time});
            }

            // 2-1. 앞으로
            if (x + 1 <= INF && dp[x + 1] > time + 1) {
                dp[x + 1] = time + 1;
                dq.addLast(new int[]{x + 1, time + 1});
            }

            // 2-2. 뒤로
            if (x - 1 >= 0 && dp[x - 1] > time + 1) {
                dp[x - 1] = time + 1;
                dq.addLast(new int[]{x - 1, time + 1});
            }
        }

        return -1;
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
