#include <stack>

class Solution {
public:
    bool isValid(string s) {
        stack<char> s_stack;
        for (auto c : s) {
            if (c == '(' || c == '[' || c == '{') {
                s_stack.push(c);
            } else if (c == ')') {
                if (s_stack.empty() || s_stack.top() != '(') return false;
                s_stack.pop();
            } else if (c == ']') {
                if (s_stack.empty() || s_stack.top() != '[') return false;
                s_stack.pop();
            } else if (c == '}') {
                if (s_stack.empty() || s_stack.top() != '{') return false;
                s_stack.pop();
            }
        }
        return s_stack.empty();  // 栈不为空说明有未匹配的左括号
    }
};