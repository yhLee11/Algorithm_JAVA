import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1072 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long X = Integer.parseInt(br.readLine());
        long Y = Integer.parseInt(br.readLine());
        long z = 100 * Y / X;

        if (z >= 99) {
            System.out.println(-1);
        } else {
            long start=0;
            long end=X;
            while (start < end) {
                long mid = (start + end) / 2;
                long newRate = (100 * (Y + mid) / (X + mid));
                //승률이 그대로인 경우
                if (newRate == z) {
                    start = mid + 1;
                }
                //승률이 변한 경우
                else{
                    end=mid;
                }
            }
            System.out.println(end);
        }
    }
}
