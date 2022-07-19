import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003 {
    static int N,M;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[N+1];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int low=0;
        int high=0;
        int cnt=0;
        int sum=num[0];
        while (true) {
            if(sum==M){
                cnt++;
                sum -= num[low++];
            } else if (sum > M) {
                sum -= num[low++];
            }else{
                sum += num[++high];
            }
            if (high == N) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
