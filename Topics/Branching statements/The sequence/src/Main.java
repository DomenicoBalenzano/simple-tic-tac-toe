import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1;
        int count = 1;
        while (i <= n && count <= n) {
            for (int k = 1; k <= i; k++) {
                System.out.print(i + " ");
                count++;
                if (count > n) {
                    break;
                }
            }
            i++;
        }
    }
}