import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] visited;
    static int[] count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new int[100001];
        count = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;
        count[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == k) break;
            int[] next = {now - 1, now + 1, 2 * now};
            for (int i = 0; i < 3; i++) {
                if (!isRange(next[i])) continue;
                if (visited[next[i]] == 0) {
                    visited[next[i]] = visited[now] + 1;
                    count[next[i]] = count[now];
                    q.add(next[i]);
                } else if (visited[next[i]] == visited[now] + 1) {
                    count[next[i]] += count[now];
                }
            }
        }

        System.out.println(visited[k] - 1);
        System.out.println(count[k]);

    }

    static boolean isRange(int x) {
        return x >= 0 && x <= 100000;
    }
}