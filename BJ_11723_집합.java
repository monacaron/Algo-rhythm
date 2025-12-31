package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 공집합 S가 주어졌을 때, 주어진 연산을 수행하는 프로그램
 * add x : S에 x를 추가한다. S에 x가 이미 있는 경우 연산 무시
 * remove x : S에 x를 제거한다. S에 x가 없는 경우 연산 무시
 * check x : S에 x가 있으면 1, 없으면 0 출력
 * toggle x : S에 x가 있으면 x를 제거하고, 없으면 x를 추가
 * all : S를 {1, 2, 3, ..., 20}으로 바꿈
 * empty : S를 공집합으로 바꿈
 */
public class BJ_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = stoi(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + 1);
        }

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] commands = br.readLine().split(" ");

            String command = commands[0];
            int x = 0;

            if (commands.length > 1) x = stoi(commands[1]);

            switch (command) {
                case "all" :
                    set.addAll(list);
                    break;
                case "empty" :
                    set.clear();
                    break;
                case "add" :
                    set.add(x);
                    break;
                case "remove" :
                    set.remove(x);
                    break;
                case "check" :
                    if (set.contains(x)) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle" :
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                default :
                    throw new IllegalArgumentException("Invalid command: " + command);
            }
        }

        System.out.println(sb);
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
