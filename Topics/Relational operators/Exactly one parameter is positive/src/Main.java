import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        boolean case1 = a > 0 && b <= 0 && c <= 0;
        boolean case2 = b > 0 && a <= 0 && c <= 0;
        boolean case3 = c >= 0 && a <= 0 && b <= 0;
        System.out.println(case1 || case2 || case3);
    }
}
