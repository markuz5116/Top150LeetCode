package intermediate_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> storedAllParenthesis = new HashMap<>();
        List<String> emptyList = new ArrayList<>();
        emptyList.add("");
        storedAllParenthesis.put(0, emptyList);
        List<String> singleList = new ArrayList<>();
        singleList.add("()");
        storedAllParenthesis.put(1, singleList);

        for (int currLen = 2; currLen <= n; currLen++) {
            List<String> currList = new ArrayList<>();
            for (int leftStrLen = 0; leftStrLen < currLen; leftStrLen++) {
                int rightStrLen = currLen - leftStrLen - 1;
                for (String leftStr : storedAllParenthesis.get(leftStrLen)) {
                    for (String rightStr : storedAllParenthesis.get(rightStrLen)) {
                        currList.add(String.format("(%s)%s", leftStr, rightStr));
                    }
                }
            }
            storedAllParenthesis.put(currLen, currList);
        }
        return storedAllParenthesis.get(n);
    }
}
