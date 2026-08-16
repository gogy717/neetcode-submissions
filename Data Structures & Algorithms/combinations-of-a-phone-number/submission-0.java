class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        backtrack(digits, 0, path, result);
        return result;
    }
    private String[] digitMap = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    
    private void backtrack(String digits, int curIndex, StringBuilder path, List<String> result) {

        if (curIndex > digits.length() - 1) {
            result.add(path.toString());
            return;
        }
        char c = digits.charAt(curIndex);
        int digit = c - '0';
        String letters = digitMap[digit];
        for (char l: letters.toCharArray()) {
            path.append(l);
            backtrack(digits, curIndex + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    

    }
}
