package easy_questions;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stoneToCount = new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            stoneToCount.put(stones.charAt(i), stoneToCount.getOrDefault(stones.charAt(i), 0) + 1);
        }

        int numJewels = 0;
        for (int i = 0; i < jewels.length(); i++) {
            numJewels += stoneToCount.getOrDefault(jewels.charAt(i), 0);
        }
        return numJewels;
    }
}
