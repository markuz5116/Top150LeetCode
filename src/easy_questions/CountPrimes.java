package easy_questions;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] isPrimes = new boolean[n + 1];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;

        for (int i = 2; i * i < n + 1; i++) {
            if (!isPrimes[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                isPrimes[j] = false;
            }
        }

        int numPrimes = 0;
        for (int i = 0; i < n; i++) {
            if (isPrimes[i]) {
                numPrimes++;
            }
        }

        return numPrimes;
    }
}
