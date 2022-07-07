import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int min = Math.min(n, m);
        if ((k < min) || !(k % n == 0 || k % m == 0) || (k > n * m)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}