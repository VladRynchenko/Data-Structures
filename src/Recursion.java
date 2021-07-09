public class Recursion {
    public static void main(String[] args) {
        System.out.println(power(2, 3));
        makeBranch(0, 10);
    }

    static int power(int number, int power) {
        if (power != 1) {
            return (number * power(number, power - 1));
        }
        return number;
    }

    static void makeBranch(int left, int right) {
        int centr = (left + right) / 2;
        for (int i = left; i < right; i++) {
            if (i == centr) {
                System.out.print("X");
            } else {
                System.out.print("-");
            }
        }
        if (left != right) {
            makeBranch(left, centr);
            makeBranch(centr, right - 1);
        }
    }
}
