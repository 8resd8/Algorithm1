package _0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_회전초밥 {
    static int N, d, k, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // 초밥의 종류
        k = Integer.parseInt(st.nextToken()); // 연속해서 선택
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        arr = new int[N];
        int[] frequency = new int[d + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int select = 1; // 쿠폰은 늘 한 종류를 지급한다
        frequency[c]++;
        for (int i = 0; i < k; i++) {
            if (frequency[arr[i]] == 0) select++;
            frequency[arr[i]]++;
        }
        int chobob = select;

        for (int i = 1; i < N; i++) {
            frequency[arr[i - 1]]--;
            if (frequency[arr[i - 1]] == 0) {
                chobob--; // 앞 빼기
            }

            if (frequency[arr[(i + k - 1) % N]] == 0) {
                chobob++; // 뒤 추가
            }

            frequency[arr[(i + k - 1) % N]]++;
            select = Math.max(chobob, select);
        }

        System.out.println(select);
    }
}