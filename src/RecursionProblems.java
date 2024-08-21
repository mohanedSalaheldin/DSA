public class RecursionProblems {

    public static void main(String[] args) {
        System.out.println(myPow(4.0, -1));
    }

    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) {
            nn = -nn;
            x = 1.0 / x;
        }
        while (nn > 0){
            if (nn%2==1){
                ans = ans * x;
                nn = nn - 1;
            }else {
                x = x * x;
                nn = nn/2;
            }
        }
        return  ans;
    }
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1;
        int r = x;
        int ans = 0;
        while(l<=r){
            int m = l + (r-l)/2;
            if (m <= x/m) {
                ans = m;
                l = m + 1;
            }else
                r = m - 1;
        }
        return ans;
    }
}
