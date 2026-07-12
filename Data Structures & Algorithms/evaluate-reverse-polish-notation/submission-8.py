class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        
        add = lambda a, b: a + b
        minus = lambda a, b: a - b
        mult = lambda a, b: a * b
        div = lambda a, b: int(a / b)
        
        eval_map = {"+": add, "-": minus, "*": mult, "/": div}

        num_stack = []

        for t in tokens:
            if t not in eval_map:
                num_stack.append(int(t))
            else:
                result = eval_map[t](num_stack[-2], num_stack[-1])
                num_stack.pop()
                num_stack.pop()
                num_stack.append(result)
        
        return num_stack[-1]