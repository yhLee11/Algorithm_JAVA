import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805 {
    static int N,M;
    static int[] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        long start=1;
        long end = num[num.length-1];
        long mid=0;
        long sum=0;
        long res=0;
        while (true) {
            mid = (start + end)/2;
            long tree=0;
            for (int i = 0; i < N; i++) {
                if (num[i] > mid) {
                    tree += num[i] - mid;
                }
            }
            if (tree == M) {
                res=mid;
            } else if(tree<M) {
                end = mid - 1;
            }else{
                res=mid;
                start=mid+1;
            }

            if(start>end) {
                break;
            }
        }
        System.out.println(res);
    }
}


