package easy_questions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romanLetterToInteger = new HashMap<>();
        romanLetterToInteger.put('I', 1);
        romanLetterToInteger.put('V', 5);
        romanLetterToInteger.put('X', 10);
        romanLetterToInteger.put('L', 50);
        romanLetterToInteger.put('C', 100);
        romanLetterToInteger.put('D', 500);
        romanLetterToInteger.put('M', 1000);

        int prevVal = romanLetterToInteger.get(s.charAt(0));
        int totalVal = 0;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            int currVal = romanLetterToInteger.get(curr);
            if (currVal > prevVal) {
                prevVal *= -1;
            }
            totalVal += prevVal;
            prevVal = currVal;

        }

        return totalVal + prevVal;
    }
}
