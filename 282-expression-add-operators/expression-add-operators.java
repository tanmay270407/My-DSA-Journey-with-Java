import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, 0, 0, 0, "");
        return result;
    }

    private void backtrack(List<String> result, String num, int target, int index,
                           long currentValue, long prevNumber, String path) {
        
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i != index && num.charAt(index) == '0') break;

            long currentNum = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                backtrack(result, num, target, i + 1, currentNum, currentNum, "" + currentNum);
            } else {
       
                backtrack(result, num, target, i + 1,
                        currentValue + currentNum,
                        currentNum,
                        path + "+" + currentNum);

                backtrack(result, num, target, i + 1,
                        currentValue - currentNum,
                        -currentNum,
                        path + "-" + currentNum);

                backtrack(result, num, target, i + 1,
                        currentValue - prevNumber + (prevNumber * currentNum),
                        prevNumber * currentNum,
                        path + "*" + currentNum);
            }
        }
    }
}