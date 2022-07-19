import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806 {
    static int N,M;
    static int[] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[N + 1];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum = num[0];
        int length = 1;
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        while (true) {
            if (sum >= M) {
                ans = Math.min(ans, length);
                sum -= num[low++];
                length--;
            } else if (sum < M) {
                sum += num[++high];
                length++;
            }

            if (high == N) {
                break;
            }
        }
        if (ans==Integer.MAX_VALUE){
            ans=0;
        }
        System.out.println(ans);
    }
}
