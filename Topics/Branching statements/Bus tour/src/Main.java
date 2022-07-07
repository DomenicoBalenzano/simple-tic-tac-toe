import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int busHeight = scanner.nextInt();
        int numOfBridges = scanner.nextInt();
        int[] bridges = new int[numOfBridges];
        for (int i = 0; i < bridges.length; i++) {
            bridges[i] = scanner.nextInt();
        }
        boolean crash = false;
        int i = 0;
        while (i < bridges.length) {
            if (busHeight >= bridges[i]) {
                crash = true;
                System.out.println("Will crash on bridge " + (i + 1));
                break;
            }
            i++;
        }
        if (!crash) {
            System.out.println("Will not crash");
        }
    }
}