import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] seats = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        boolean isNear = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m - k; j++) {
                int start = j;
                int end = j + 1;
                isNear = true;
                int count = 1;
                while (isNear && end < m && count < k) {
                    if (seats[i][start] == 0 && seats[i][start] == seats[i][end]) {
                        start++;
                        end++;
                        count++;
                    } else {
                        isNear = false;
                    }
                }
                if (isNear) {
                    break;
                }
            }
            if (isNear) {
                System.out.println(i + 1);
                break;
            }
        }
        if (!isNear) {
            System.out.println(0);
        }
    }
}