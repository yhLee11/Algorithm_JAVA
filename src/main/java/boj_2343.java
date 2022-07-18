import java.io.*;
public class boj_2343 {
    static int n,m;
    static int[] lesson;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        lesson = new int[n];

        arr = br.readLine().split(" ");

        int max=0;
        for (int i = 0; i < n; i++) {
            lesson[i] = Integer.parseInt(arr[i]);
            max = Math.max(max, lesson[i]);
        }
        bw.write(bSearch(max, 1000000000) + "\n");
        bw.flush();
    }
    private static int bSearch(int left, int right) {
        int mid, cnt, sum;
        while (left<=right){
            mid=(left+right)/2;
            cnt=1;
            sum=0;
            for(int i=0;i<n;i++){
                sum+=lesson[i];
                if(sum>mid){
                    sum=lesson[i];
                    cnt++;
                }
            }
            if(cnt>m) left=mid+1;
            else right=mid-1;
        }
        return left;
    }
}
