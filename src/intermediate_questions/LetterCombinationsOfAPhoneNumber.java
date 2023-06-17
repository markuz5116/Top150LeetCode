package intermediate_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> digitToLetters = new HashMap<>();
        digitToLetters.put('2', List.of('a', 'b', 'c'));
        digitToLetters.put('3', List.of('d', 'e', 'f'));
        digitToLetters.put('4', List.of('g', 'h', 'i'));
        digitToLetters.put('5', List.of('j', 'k', 'l'));
        digitToLetters.put('6', List.of('m', 'n', 'o'));
        digitToLetters.put('7', List.of('p', 'q', 'r', 's'));
        digitToLetters.put('8', List.of('t', 'u', 'v'));
        digitToLetters.put('9', List.of('w', 'x', 'y', 'z'));
        List<String> combinations = helper(digitToLetters, digits, 0);
        return combinations;
    }

    private List<String> helper(Map<Character, List<Character>> digitToLetters,
            String digits, int digitsIdx) {
        if (digitsIdx >= digits.length()) {
            return new ArrayList<>();
        }
        List<String> nextCombis = helper(digitToLetters, digits, digitsIdx + 1);
        if (nextCombis.isEmpty()) {
            nextCombis = List.of("");
        }
        List<String> currCombis = new ArrayList<>();
        for (char c : digitToLetters.get(digits.charAt(digitsIdx))) {
            for (String nextCombi : nextCombis) {
                currCombis.add(c + nextCombi);
            }
        }
        return currCombis;
    }
}
