package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1 ~ 4번 버튼을 이용해 리스트의 순서를 바꿀 수 있음
 * 1 : 화살표를 한 칸 아래로 ~ i -> i + 1
 * 2 : 화살표를 한 칸 위로 ~ i -> i - 1
 * 3 : 현재 선택한 채널을 한 칸 아래로 ~ i <-> i + 1
 * 4 : 현재 선택한 채널을 한 칸 위로 ~ i <-> i - 1
 * 범위를 넘어가는 명령은 무시
 * KBS1을 첫 번째로, KBS2를 두 번째 순서로 바꾸는 방법을 구하기
 * 방법의 길이는 500보다 작아야 함
 *
 * 1. KBS1, KBS2 찾기
 * 2. 지정 위치로 이동
 */
public class BJ_2816_디지털티비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());

        String[] channels = new String[N];

        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            channels[i] = br.readLine();

            if (channels[i].equals("KBS1")) x = i;
            if (channels[i].equals("KBS2")) y = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append(1);
        }

        for (int i = 0; i < x; i++) {
            sb.append(4);
        }

        if (x > y) y++;

        for (int i = 0; i < y; i++) {
            sb.append(1);
        }

        for (int i = 0; i < y - 1; i++) {
            sb.append(4);
        }

        System.out.println(sb);

    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
