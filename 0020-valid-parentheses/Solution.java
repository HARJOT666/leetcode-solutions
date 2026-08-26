class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        //Order preservation is also important
        // How to preserve order????????????
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' ||s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(s.charAt(i) == ')' && top != '('){
                    return false;
                }
                if(s.charAt(i) == ']' && top != '['){
                    return false;
                }
                if(s.charAt(i) == '}' && top != '{'){
                    return false;
                }
            }
       }
       return stack.isEmpty();
    }
}