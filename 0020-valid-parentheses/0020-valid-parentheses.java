class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            // opening bracket → push!
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            // closing bracket → pop aur match check!
            else {
                if(stack.isEmpty()) return false;  // )(  case!
                
                char top = stack.pop();
                
                if(c == ')' && top != '(') return false;
                if(c == ']' && top != '[') return false;
                if(c == '}' && top != '{') return false;
            }
        }
        
        return stack.isEmpty();  // sab match hua?
    }
}