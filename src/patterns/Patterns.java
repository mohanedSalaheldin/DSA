package patterns;

public class Patterns {

    public static void p1(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" *" );
            }
            System.out.println();
        }
    }
    public static void p2(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(" *" );
            }
            System.out.println();
        }
    }
    public static void p3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(" "+(j+1) );
            }
            System.out.println();
        }
    }
    public static void p4(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(" "+(i+1) );
            }
            System.out.println();
        }
    }
    public static void p5(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
    public static void p6(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" "+ (j+1));
            }
            System.out.println();
        }
    }
    public static void p7(int n){
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n-(i+1); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*i + 1); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n-(i+1); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void p8(int n){
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*n-1)- (2*i); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void p9(int n){
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*n-1)- (2*i); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void p10(int n){
        int stars = 0;
        for (int i = 0; i < 2*n; i++) {
            if (i < (2*n+1)/2) stars = i;
            else stars = 2*n-i;
            for (int j = 0; j < stars; j++) {
                System.out.print(" *" );
            }
            System.out.println();
        }
    }
    public static void p11(int n){
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) num = 1 ;
            else num = 0;
            for (int j = 0; j < i+1; j++) {
                System.out.print(" "+(num) );
                num = 1 - num;
            }
            System.out.println();
        }
    }
    public static void p12(int n){
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print((j+1));
            }

            for (int j = 0; j < 2*n - 2*(i+1); j++) {
                System.out.print(" ");
            }


            for (int j = i+1; j > 0 ; j--) {
                System.out.print((j));
            }
            System.out.println();
        }
    }
    public static void p13(int n){
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(" "+(num++) );
            }
            System.out.println();
        }
    }
    public static void p14(int n){
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j <= 'A'+i; j++) {
                System.out.print(" "+j );
            }
            System.out.println();
        }
    }
    public static void p15(int n){
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j < 'A' + (n-i); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void p16(int n){
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j <= 'A'+i; j++) {
                System.out.print((char) ('A' + i));
            }
            System.out.println();
        }
    }
    public static void p17(int n){
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n-(i+1); j++) {
                System.out.print(" ");
            }
            char ch = 'A';
            int breakbPoint = (2*i +1)/2;
            for (int j = 0; j < (2*i + 1); j++) {
                System.out.print((char) (ch));
                if (j < breakbPoint) ch++;
                else ch--;
            }
            for (int j = 0; j < n-(i+1); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int n = 5;
//        p11(n);
        p12(n);
//        p13(n);
//        p14(n);
//        p17(n);
//        p7(n);
    }
}
