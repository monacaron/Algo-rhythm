package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 두 명이서 게임 진행
 * N개의 돌
 * 번갈아가며 돌을 1 or 3개 가져감
 * 마지막 돌을 가져가는 사람이 승리
 * 두 사람이 완벽하게 게임을 했을 때, 이기는 사람 구하기
 *
 * N - 1번 돌을 가져가면 패배
 * 한 턴에 2, 4, 6
 */
public class BJ_9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}
