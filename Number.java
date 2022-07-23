package demo02;

import java.util.Scanner;

public class Number {
    private static int n, m;
    private static int[] p = new int[11];

    public static void main(String[] args) {
        p[0] = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入n");
        n = scanner.nextInt();
        m = n;
        dfs(1);
    }
     public static void print(int aa){;

         for (int i = 1; i < aa; i++) {
             System.out.println(p[i] + "+");
             System.out.println(p[aa]);
         }
     }
     public static void dfs(int a){
         for (int i = p[a - 1]; i <= m ; i++) {
             if (i ==n){
                 continue;
             }
             p[a] = i;
             m -= i;
             if (m == 0){
                 System.out.println(a);
             }else {
                 dfs(a + 1);
             }
             m += i;
         }
     }
}

