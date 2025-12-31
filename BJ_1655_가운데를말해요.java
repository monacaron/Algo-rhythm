package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 숫자가 하나씩 추가될 때 마다 중간값 말하기
 * 개수가 짝수개인 경우 더 작은 중간값 선택
 */
public class BJ_1655_가운데를말해요 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxpq = new PriorityQueue<>((o1, o2) -> o1 - o2); // 오름차순 ~ input보다 큼
        PriorityQueue<Integer> minpq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순 ~ input보다 작음
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            // 일단 작은 쪽에 넣기 ~ 그래야 홀수일 때 작은 쪽 뺄 수 있음
            if(minpq.size() == maxpq.size()) {
                minpq.offer(input);
            } else {
                maxpq.offer(input);
            }

            // 새로 들어간 input이 중간값이 아닌 경우 바꿔주기
            if(!minpq.isEmpty() && !maxpq.isEmpty()) {
                if(maxpq.peek() < minpq.peek()) { // max가 min보다 작은 경우 change
                    int now = maxpq.poll();
                    maxpq.offer(minpq.poll());
                    minpq.offer(now);
                }
            }

            sb.append(minpq.peek() + "\n");
        }
        System.out.println(sb);
    }
}
