import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] wine = new int[n + 1];
        int[][] dp = new int[3][n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        dp[0][1] = 0;
        dp[1][1] = wine[1];
        dp[2][1] = wine[1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
            dp[1][i] = dp[0][i - 1] + wine[i];
            dp[2][i] = dp[1][i - 1] + wine[i];
        }

        System.out.println(Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n])));
    }
}

/*
dp[0][n] = n번을 선택하지 않은 경우 -> dp[0][n-1], dp[1][n-1], dp[2][n-1] 중에 max 값
dp[1][n] = n-1을 선택하지 않고 n번을 선택한 경우 -> dp[0][n-1] + wine[i]
dp[2][n] = n-1을 선택하고 n번을 선택한 경우 -> dp[1][n-1] + wine[i]
 */