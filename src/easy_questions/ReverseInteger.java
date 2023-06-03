package easy_questions;

public class ReverseInteger {
    public static int reverse(int x) {
        double reverseX = 0;
        while (x != 0) {
            reverseX *= 10;
            reverseX += x % 10;
            x /= 10;
        }

        if (reverseX < Math.pow(-2, 31) || reverseX > Math.pow(2, 31) - 1) {
            reverseX = 0;
        }
        return (int) reverseX;
    }

    public static void test() {
        int[] allXs = new int[] { 1534236469 };
        int[] allOutputs = new int[] { 0 };
        for (int i = 0; i < allXs.length; i++) {
            int x = allXs[i];
            int output = allOutputs[i];
            int myOutput = reverse(x);
            System.out.println(output == myOutput);
        }
    }
}
