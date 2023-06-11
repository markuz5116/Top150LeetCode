package easy_questions;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slowN = n;
        int fastN = getNextN(n);
        while (fastN != 1 && slowN != fastN) {
            slowN = getNextN(slowN);
            fastN = getNextN(fastN);
            if (fastN == 1) {
                break;
            }
            fastN = getNextN(fastN);
        }
        return fastN == 1;
    }

    private int getNextN(int n) {
        int temp = 0;
        while (n > 0) {
            temp += Math.pow(n % 10, 2);
            n /= 10;
        }
        return temp;
    }
}
