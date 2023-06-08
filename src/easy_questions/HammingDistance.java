package easy_questions;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xorVal = x ^ y;
        int hammingDistance = 0;
        while (xorVal > 0) {
            if (xorVal % 2 == 1) {
                hammingDistance++;
            }
            xorVal /= 2;
        }
        return hammingDistance;
    }
}
