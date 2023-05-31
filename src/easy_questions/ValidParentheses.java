package easy_questions;

import java.util.Stack;

public class ValidParentheses {
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and
    // ']', determine if the input string is valid.
    public static boolean isValid(String s) {
        Stack<Integer> openBracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int openBracketType = getOpenBracketType(c);
            if (openBracketType != 0) {
                openBracketStack.add(openBracketType);
            }
            int closeBracketType = getCloseBracketType(c);
            if (closeBracketType != 0) {
                if (openBracketStack.empty()) {
                    return false;
                }
                int storedBracketType = openBracketStack.pop();
                if (storedBracketType != closeBracketType) {
                    return false;
                }
            }
        }
        return openBracketStack.empty();
    }

    private static int getCloseBracketType(char c) {
        switch (c) {
            case ')':
                return 1;
            case '}':
                return 2;
            case ']':
                return 3;
            default:
                return 0;
        }
    }

    private static int getOpenBracketType(char c) {
        switch (c) {
            case '(':
                return 1;
            case '{':
                return 2;
            case '[':
                return 3;
            default:
                return 0;
        }
    }

    public static void test() {
        String[] strings = new String[] { "()", "()[]{}", "(]", "[", "]" };
        boolean[] outputs = new boolean[] { true, true, false, false, false };
        boolean allPass = true;
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            boolean output = outputs[i];
            boolean myOutput = ValidParentheses.isValid(string);
            if (output != myOutput) {
                System.out.println(String.format("Input: %s", string));
                System.out.println(String.format("Your code gave: %s", myOutput));
                System.out.println(String.format("Correct output: %s", output));
                allPass = false;
            }
        }
        if (allPass) {
            System.out.println("All Correct");
        }

    }
}
