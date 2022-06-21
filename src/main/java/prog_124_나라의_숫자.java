public class prog_124_나라의_숫자 {
    public String solution(int n) {
        String[] nums={"4","1","2"};
        String ans="";
        while (n>0){
            ans=nums[n%3]+ans;
            n=(n-1)/3;
        }
        return ans;
    }
}